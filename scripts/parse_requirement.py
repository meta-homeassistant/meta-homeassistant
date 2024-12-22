"""Module providing a way of creating a CSV with all the dependencies of HomeAssistant"""

import re
import os
import json
import argparse
import shutil
import sys
from git import Repo, GitCommandError
import pandas as pd
from packaging import version


SCRIPT_DIR = os.path.dirname(os.path.realpath(__file__))


def extract_component_test_packages(file_path):
    """
    Extract the COMPONENT_TEST_PACKAGES from the integration-test.inc file.

    Args:
        file_path (str): Path to the integration-test.inc file.

    Returns:
        list: A list of component package names without the '${PN}-' prefix.
    """

    with open(file_path, 'r') as file:
        content = file.read()

    # Regular expression to find the COMPONENT_TEST_PACKAGES block
    match = re.search(r'COMPONENT_TEST_PACKAGES\s*=\s*"([^"]+)"', content, re.DOTALL)
    if not match:
        print("COMPONENT_TEST_PACKAGES block not found.")
        return []

    # Extract the packages block and split it into lines
    packages_block = match.group(1)
    packages_list = packages_block.split("\\\n")

    # Clean up the package names by removing '${PN}-' prefix and trimming whitespace
    extracted_packages = [
        line.strip().replace("${PN}-", "")
        for line in packages_list if line.strip()
    ]

    return extracted_packages


def load_layers():
    """
    Load and return layer configurations from the 'layers.json' file.

    The JSON file is expected to be in the same directory as this script.

    Returns:
        dict: Parsed layer configurations from 'layers.json'.
    """
    layers_path = os.path.join(SCRIPT_DIR, "layers.json")
    with open(layers_path, "r", encoding="utf8") as file:
        return json.load(file)


def load_integrations():
    """
    Load and return integration configurations from the 'integrations.json' file.

    The JSON file is expected to be in the same directory as this script.

    Returns:
        dict: Parsed integration configurations from 'integrations.json'.
    """
    integrations_path = os.path.join(SCRIPT_DIR, "integrations.json")
    with open(integrations_path, "r", encoding="utf8") as file:
        return json.load(file)


def parse_arguments():
    """
    Parse command-line arguments for the Home Assistant dependency parser.

    Supported arguments:
        -v, --version   : Home Assistant version (default: latest version).
        -u, --upgrade   : Show only packages that need upgrading ('y' or 'n').
        -c, --clean     : Clean HA Core repository after parsing ('y' or 'n').
        -i, --integrate : Show only available configurations ('y' or 'n').

    Returns:
        argparse.Namespace: Parsed arguments with version, upgrade, clean,
                            and integrate options.
    """
    parser = argparse.ArgumentParser()

    parser.add_argument("-v", "--version", help="HA Version", type=str, default="")
    parser.add_argument(
        "-u", "--upgrade",
        help="Only print packages which need upgrading",
        type=str,
        default="n",
        choices=["y", "n"],
    )
    parser.add_argument(
        "-c", "--clean",
        help="Clean HA Core Repository after parsing",
        type=str,
        default="y",
        choices=["y", "n"],
    )
    parser.add_argument(
        "-i", "--integrate",
        help="Show only available configuration",
        type=str,
        default="n",
        choices=["y", "n"],
    )
    return parser.parse_args()


def get_repo(ha_path, ha_version=""):
    """
    Clone or initialize the Home Assistant repository and checkout a specific version.

    If a version is not provided, the function defaults to the latest available tag.

    Args:
        ha_path (str): Local path to store the cloned Home Assistant repository.
        ha_version (str, optional): Specific Home Assistant version to checkout. Defaults to latest version.

    Returns:
        str: The checked-out version tag name.
    """
    try:
        # Initialize or clone repository if not present
        repo = (
            Repo(ha_path)
            if os.path.isdir(ha_path)
            else Repo.clone_from("https://github.com/home-assistant/core.git", ha_path)
        )

        # Get the desired tag
        tags = sorted(repo.tags, key=lambda t: t.commit.committed_datetime)
        if not ha_version:
            ha_version = tags[-1].name
            print(f"Using the latest tag: {ha_version}")
        else:
            print(f"Using specified tag: {ha_version}")

        # Attempt to checkout the tag
        repo.git.checkout(ha_version)
        return ha_version

    except GitCommandError as e:
        print(f"Failed to checkout tag {ha_version}. Error: {e}")
        sys.exit(1)
    except Exception as e:
        print(f"An error occurred while setting up the repository: {e}")
        sys.exit(1)


def get_recipes(ha_path):
    """Get a list of all recipes and versions available in Yocto/OE"""
    list_of_recipes = []
    layers = load_layers()  # Call function to load layers from the JSON file

    for layer in layers:
        search_path = os.path.join(ha_path, layer)
        if os.path.exists(search_path):
            list_of_recipes.extend(
                f.name.strip(".bb")
                for f in os.scandir(search_path)
                if (f.is_file() and f.name.endswith(".bb"))
            )
    version_pattern = re.compile(r'_([\d.]+)$')
    
    # Filter items that match the version pattern
    filtered_recipes = [i for i in list_of_recipes if version_pattern.search(i)]
    
    # Split the items into parts
    return [i.rsplit("_", 1)[0] for i in filtered_recipes], [
        version_pattern.search(i).group(1) for i in filtered_recipes
    ]


def parse_manifests(ha_path, upgrade_only, integrations_only):
    """Parse HomeAssistant manifests to gather requirements."""
    integrations = load_integrations()
    components_path = os.path.join(ha_path, "homeassistant/components")
    test_path = os.path.join(ha_path, "tests/components")
    list_of_components = [f.path for f in os.scandir(components_path) if f.is_dir()]
    list_of_tests = [os.path.basename(f.path) for f in os.scandir(test_path) if f.is_dir()]

    test_packages = extract_component_test_packages(os.path.join(SCRIPT_DIR, "../recipes-homeassistant/homeassistant/python3-homeassistant/integrations-tests.inc"))

    df = []
    for component in list_of_components:
        try:
            manifest = load_manifest(component)
            list_of_recipes, list_of_versions = get_recipes(ha_path)

            requirements = manifest.get("requirements", [])
            has_test = manifest["domain"] in list_of_tests

            is_test_package = manifest["domain"].replace('_','-') in test_packages
            if not requirements:

                df.append(create_entry(
                    manifest["domain"],
                    "y" if has_test else "n",
                    "y" if is_test_package else "n",
                    " ",
                    " ",
                    " ",
                ))
            for requirement in requirements:
                package_name, ha_version = parse_requirement(requirement)
                yocto_version = get_yocto_version(
                    package_name, list_of_recipes, list_of_versions
                )

                if should_include(
                    manifest["domain"],
                    ha_version,
                    yocto_version,
                    integrations,
                    upgrade_only,
                    integrations_only,
                ):
                    df.append(create_entry(
                        manifest["domain"],
                        "y" if has_test else "n",
                        "y" if is_test_package else "n",
                        package_name,
                        ha_version,
                        yocto_version,

                    ))
        except FileNotFoundError:
            print(f"Manifest file not found for component: {component.split('/')[-1]}")
        except json.JSONDecodeError:
            print(f"Error decoding JSON for component: {component.split('/')[-1]}")

    return pd.DataFrame(
        df,
        columns=[
            "Component",
            "Tests Available",
            "In Test Packages",
            "Requirements",
            "Required HA Version",
            "Available Yocto/OE Version",
        ],
    )


def load_manifest(component_path):
    """Load the manifest file of a component."""
    manifest_path = os.path.join(component_path, "manifest.json")
    with open(manifest_path, encoding="utf8") as f:
        return json.load(f)


def parse_requirement(requirement):
    """Parse the requirement into a package name and version."""
    package_name, ha_version = requirement.split("==")
    package_name = "python3-" + package_name.lower().replace("_", "-")
    return package_name, ha_version


def get_yocto_version(package_name, list_of_recipes, list_of_versions):
    """Get the Yocto/OE version of a package if available, otherwise return empty string."""
    if package_name in list_of_recipes:
        return list_of_versions[list_of_recipes.index(package_name)]
    return ""


def should_include(
    domain,
    ha_version,
    yocto_version,
    integrations,
    upgrade_only,
    integrations_only,
):
    """
    Determine if a package should be included
    based on upgrade and integration filters.
    """
    if integrations_only == "y" and domain not in integrations:
        return False
    if (
        upgrade_only == "y"
        and yocto_version
        and version.parse(ha_version) <= version.parse(yocto_version)
    ):
        return False
    return True


def create_entry(domain, tests, test_package, package_name, ha_version, yocto_version):
    """Create a dictionary entry for a component's requirements."""
    return {
        "Component": domain,
        "Tests Available": tests,
        "In Test Packages": test_package,
        "Requirements": package_name,
        "Required HA Version": ha_version,
        "Available Yocto/OE Version": yocto_version or "",
    }


def main() -> None:
    """Main function to generate Home Assistant dependency CSV."""
    args = parse_arguments()
    ha_path = os.path.join(SCRIPT_DIR, "HA")

    # Clone or initialize the repository, then parse
    # and save manifest information
    get_repo(ha_path, args.version)
    manifest_info = parse_manifests(ha_path, args.upgrade, args.integrate)
    save_csv(manifest_info, args.version)

    # Clean up if specified
    if args.clean == "y":
        cleanup_repo(ha_path)
    print("Finished")


def save_csv(data, filename):
    """Save manifest information to a CSV file."""
    output_path = os.path.join(SCRIPT_DIR, f"{filename}.csv")
    data.to_csv(output_path, index=False)
    print(f"Saved CSV: {output_path}")


def cleanup_repo(ha_path):
    """Remove the Home Assistant repository directory."""
    shutil.rmtree(ha_path)
    print("Removed checked out HA repository")


if __name__ == "__main__":
    main()

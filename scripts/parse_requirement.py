"""Module providing a way of creating a CSV with all the dependencies of HomeAssistant"""

import os
import json
import csv
import shutil
import sys
import argparse
from git import Repo, GitCommandError
from packaging import version


def parse_arguments():
    """Parse the user input"""
    parser = argparse.ArgumentParser()

    parser.add_argument("-v", "--version", help="HA Version", type=str, default="")
    parser.add_argument(
        "-u",
        "--upgrade",
        help="Only print packages which need upgrading",
        type=str,
        default="n",
        choices=["y", "n"],
    )
    parser.add_argument(
        "-c",
        "--clean",
        help="Clean HA Core Repository after parsing",
        type=str,
        default="y",
        choices=["y", "n"],
    )
    args = parser.parse_args()

    return args


def get_repo(ha_path, ha_version):
    """Clone or initialize the Home Assistant repository."""
    if os.path.isdir(ha_path):
        repo = Repo(ha_path)
    else:
        repo = Repo.clone_from("https://github.com/home-assistant/core.git", ha_path)

    # Get the tags and sort them
    tags = sorted(repo.tags, key=lambda t: t.commit.committed_datetime)
    if ha_version == "":
        latest_tag = tags[-1]
        ha_version = latest_tag.name
        print("Found the following latest tag: " + ha_version)
    else:
        print("Using tag: " + ha_version)
    # Now that we have it, check out this branch
    try:
        repo.git.checkout(ha_version)
    except GitCommandError:
        print("Cannot find the required version. Does the tag exist?")
        sys.exit()
    return ha_version


def parse_manifests(ha_path):
    """Parse the HomeAssistant manifest for the components, dependencies and reqs"""
    components_path = os.path.join(ha_path, "homeassistant/components")
    list_of_components = [f.path for f in os.scandir(components_path) if f.is_dir()]
    manifest_info = {}
    for component in list_of_components:
        with open(component + "/manifest.json", encoding="utf8") as f:
            manifest = json.load(f)
            # Initialize manifest info as an empty dictionary
            manifest_info[manifest["domain"]] = {}
            # Check if manifest specifies dependencies
            if "dependencies" in manifest:
                manifest_info[manifest["domain"]]["dependencies"] = manifest[
                    "dependencies"
                ]
            # Check if it specifies any requirements
            if "requirements" in manifest:
                manifest_info[manifest["domain"]]["requirements"] = manifest[
                    "requirements"
                ]
            f.close()
    return manifest_info


def get_unique_python_requirements(manifest_info, csv_writer):
    """Parse manifest_info to create unique list of requirements"""
    requirements = []
    for component in manifest_info:
        if "requirements" in manifest_info[component]:
            csv_writer.writerow(
                [
                    component.lower().replace(" ", "-"),
                    manifest_info[component]["requirements"],
                ]
            )
            requirements = requirements + (manifest_info[component]["requirements"])
    requirements = list(set(requirements))
    return requirements


def compare_with_layers(requirements, ha_path, layers, csv_writer, upgrade_only):
    """Compare Home Assistant manifest with available Yocto recipes"""
    list_of_recipes = []
    missing_recipes_list = {}
    found_recipes_list = {}
    for layer in layers:
        search_path = os.path.join(ha_path, layer)
        list_of_recipes = [
            f.name.strip(".bb")
            for f in os.scandir(search_path)
            if (f.is_file() and f.name.endswith(".bb"))
        ]

        for requirement in requirements:
            # Split requirement in name and version of package
            package = requirement.split("==")
            package[0] = "python3-" + package[0].lower().replace("_", "-")
            # Now for each requirement loop over the list of discovered recipes
            for recipe in list_of_recipes:
                recipe = recipe.split("_")
                # Case 1: check if recipe is available and is an exact match
                if package[0] + "_" + package[1] == recipe[0] + "_" + recipe[1]:
                    try:
                        del missing_recipes_list[package[0]]
                    # pylint: disable=W0718
                    except Exception:
                        pass
                    found_recipes_list[package[0]] = package[1]
                    if upgrade_only != "y":
                        csv_writer.writerow([package[0], package[1], package[1], layer])
                    break
                # Case 2: if not, check if recipe is available but has a lower version
                elif package[0] == recipe[0]:
                    try:
                        del missing_recipes_list[package[0]]
                    # pylint: disable=W0718
                    except Exception:
                        pass
                    # Now if the needed package version is higher than the found one,
                    # and no other package has been found in a
                    # layer which is higher in the bblayers order, then add it to the list
                    if (version.parse(package[1]) > version.parse(recipe[1])) and (
                        package[0] not in found_recipes_list
                    ):
                        csv_writer.writerow([package[0], package[1], recipe[1], layer])
                    if (version.parse(package[1]) < version.parse(recipe[1])) and (
                        package[0] not in found_recipes_list
                    ):
                        csv_writer.writerow([package[0], package[1], recipe[1], layer])
                    found_recipes_list[package[0]] = package[1]
                    break
                # Case 3: There is no recipe at all
                else:
                    # Didn't find it in this layer so save it until we scanned all layers
                    if package[0] not in found_recipes_list:
                        missing_recipes_list[package[0]] = package[1]
    # Now add all missing items to csv as well
    if upgrade_only != "y":
        for recipe, recipe_version in missing_recipes_list.items():
            csv_writer.writerow([recipe, recipe_version, "-", "-"])


def main() -> None:
    """Main"""
    args = parse_arguments()

    ha_path = os.path.join(os.path.dirname(__file__), "HA")
    # First get the repository for scanning, read the manifest and distill the requirements
    name = get_repo(ha_path, args.version)
    with open(name + ".csv", "w", encoding="utf8") as output_file:
        csv_writer = csv.writer(output_file)
        csv_writer.writerow(
            [
                "Package Name",
                "Required Package Version",
                "Found Package Version",
                "Layer Located",
            ]
        )

        manifest_info = parse_manifests(ha_path)
        with open(name + "-components.csv", "w", encoding="utf8") as component_file:
            csv_writer2 = csv.writer(component_file)
            csv_writer2.writerow(
                [
                    "Component Name",
                    "Required Package",
                ]
            )
            requirements = get_unique_python_requirements(manifest_info, csv_writer2)

        # Now there are multiple places where the python recipes can be found
        # 1: the meta-homeassistant layer
        # 2: poky
        # 3: the openembedded layer
        # pylint: disable=C0301
        layers = [
            "../../recipes-devtools/python",
            "../../recipes-homeassistant/homeassistant",
            "../../recipes-homeassistant/home-assistant-libs",
            "../../recipes-homeassistant/nabucasa",
            "../../../../sources/meta-openembedded/meta-python/recipes-connectivity/python-gsocketpool",
            "../../../../sources/meta-openembedded/meta-python/recipes-connectivity/python-h2",
            "../../../../sources/meta-openembedded/meta-python/recipes-connectivity/python-hpack",
            "../../../../sources/meta-openembedded/meta-python/recipes-connectivity/python-hyperframe",
            "../../../../sources/meta-openembedded/meta-python/recipes-connectivity/python-priority",
            "../../../../sources/meta-openembedded/meta-python/recipes-connectivity/python-pyconnman",
            "../../../../sources/meta-openembedded/meta-python/recipes-connectivity/python-pyro4",
            "../../../../sources/meta-openembedded/meta-python/recipes-connectivity/python-thrift",
            "../../../../sources/meta-openembedded/meta-python/recipes-connectivity/python-txws",
            "../../../../sources/meta-openembedded/meta-python/recipes-connectivity/python3-pytun",
            "../../../../sources/meta-openembedded/meta-python/recipes-devtools/python",
            "../../../../sources/meta-openembedded/meta-python/recipes-devtools/python-jsonref",
            "../../../../sources/meta-openembedded/meta-python/recipes-devtools/python3-attrdict3",
            "../../../../sources/meta-openembedded/meta-python/recipes-devtools/python3-reedsolo",
            "../../../../sources/meta-openembedded/meta-python/recipes-devtools/python3-wxgtk4",
            "../../../../sources/meta-openembedded/meta-python/recipes-extended/python-blivet",
            "../../../../sources/meta-openembedded/meta-python/recipes-extended/python-cson",
            "../../../../sources/meta-openembedded/meta-python/recipes-extended/python-meh",
            "../../../../sources/meta-openembedded/meta-python/recipes-extended/python-pyephem",
            "../../../../sources/meta-openembedded/meta-python/recipes-extended/python-pykickstart",
            "../../../../sources/meta-openembedded/meta-python/recipes-extended/python-pyparted",
            "../../../../sources/meta-openembedded/meta-python/recipes-extended/python-rich",
            "../../../../sources/meta-openembedded/meta-python/recipes-extended/python3-portalocker",
            "../../../../sources/meta-openembedded/meta-python/recipes-extended/python3-pydot",
            "../../../../sources/meta-openembedded/meta-python/recipes-extended/pywbem",
            "../../../../sources/meta-openembedded/meta-python/recipes-extended/pywbemtools",
            "../../../../sources/meta-openembedded/meta-python/recipes-extended/send2trash",
            "../../../../sources/meta-openembedded/meta-networking/recipes-devtools/python",
            "../../../../sources/poky/meta/recipes-devtools/python",
        ]
        compare_with_layers(requirements, ha_path, layers, csv_writer, args.upgrade)

        # Clean everything
        if args.clean == "y":
            shutil.rmtree(ha_path)
            print("Removed checked out HA repository")
        print("Finished")


if __name__ == "__main__":
    main()

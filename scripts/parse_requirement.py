"""Module providing a way of creating a CSV with all the dependencies of HomeAssistant"""

import os
import json
import shutil
import sys
import argparse
import pandas as pd
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
    parser.add_argument(
        "-i",
        "--integrate",
        help="Show only available configuration",
        type=str,
        default="n",
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

def get_recipes(ha_path):
    """Get a list of all recipes and versions available in Yocto/OE"""
    list_of_recipes = []
    # Now there are multiple places where the python recipes can be found
    # 1: the meta-homeassistant layer
    # 2: poky
    # 3: the openembedded layer
    # pylint: disable=C0301
    layers = [
        "../../recipes-devtools/python",
        "../../recipes-homeassistant/homeassistant",
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
        "../../../../sources/meta-openembedded/meta-python/recipes-devtools/python3_oauth2client",
        "../../../../sources/meta-openembedded/meta-python/recipes-devtools/python3-attrdict3",
        "../../../../sources/meta-openembedded/meta-python/recipes-devtools/python3-gspread",
        "../../../../sources/meta-openembedded/meta-python/recipes-devtools/python3-piccata",
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
        "../../../../sources/meta-openembedded/meta-python/recipes-networking/python",
        "../../../../sources/meta-openembedded/meta-networking/recipes-devtools/python",
        "../../../../sources/meta-openembedded/meta-oe/recipes-devtools/python",
        "../../../../sources/poky/meta/recipes-devtools/python",
    ]
    for layer in layers:
        search_path = os.path.join(ha_path, layer)
        list_of_recipes = list_of_recipes + [
            f.name.strip(".bb")
            for f in os.scandir(search_path)
            if (f.is_file() and f.name.endswith(".bb"))
        ]
    return [i.split("_")[0] for i in list_of_recipes], [i.split("_")[1] for i in list_of_recipes]

def parse_manifests(ha_path, upgrade_only, integrations_only):
    """Parse the HomeAssistant manifest for the components, dependencies and reqs"""
    components_path = os.path.join(ha_path, "homeassistant/components")
    list_of_components = [f.path for f in os.scandir(components_path) if f.is_dir()]

    df = []
    for component in list_of_components:
        try:
            with open(component + "/manifest.json", encoding="utf8") as f:
                manifest = json.load(f)
                # Check if manifest specifies dependencies
                if "dependencies" in manifest:
                    dependencies = manifest["dependencies"]
                else:
                    dependencies = ['']

                [list_of_recipes, list_of_versions] = get_recipes(ha_path)

                integrations = [
                    "acer_projector",
                    "accuweather",
                    "acmeda",
                    "adax",
                    "adguard",
                    "advantage_air",
                    "airthings_ble",
                    "amazon_polly",
                    "aruba",
                    "assist_pipeline",
                    "axis",
                    "backup",
                    "bluesound",
                    "bluetooth",
                    "camera",
                    "cast",
                    "cisco_ios",
                    "cloud",
                    "compensation",
                    "conversation",
                    "cpuspeed",
                    "debugpy",
                    "dhcp",
                    "dlna_dmr",
                    "dlna_dms",
                    "dunehd",
                    "evohome",
                    "ffmpeg",
                    "folder_watcher",
                    "fritz",
                    "fritzbox",
                    "fritzbox_callmonitor",
                    "frontend",
                    "generic",
                    "github",
                    "google_mail",
                    "google_tasks",
                    "google_translate",
                    "hacs",
                    "hardware",
                    "hue",
                    "image_upload",
                    "ipp",
                    "isal",
                    "keyboard_remote",
                    "kwb",
                    "matter",
                    "met",
                    "mobile_app",
                    "modbus",
                    "mqtt",
                    "namecheapdns",
                    "network",
                    "norway_air",
                    "octoprint",
                    "ohmconnect",
                    "otp",
                    "owntracks",
                    "pandora",
                    "private_ble_device",
                    "proxy",
                    "pulseaudio_loopback",
                    "qwikswitch",
                    "radio_browser",
                    "recorder",
                    "route53",
                    "scrape",
                    "sentry",
                    "seven_segments",
                    "shelly",
                    "speedtestdotnet",
                    "sql",
                    "ssdp",
                    "startca",
                    "stream",
                    "switchbot",
                    "systemmonitor",
                    "ted5000",
                    "trafikverket_camera",
                    "trafikverket_ferry",
                    "trafikverket_train",
                    "trafikverket_weatherstation",
                    "trend",
                    "tts",
                    "upnp",
                    "usb",
                    "utility_meter",
                    "vlc",
                    "zabbix",
                    "zeroconf",
                    "zestimate",
                    "zoneminder",
                    "zwave_js",
                    "zwave_me"
                ]

                # Check if the component specifies any requirements
                if "requirements" in manifest:
                    requirements = manifest["requirements"]
                    for requirement in requirements:
                        # Get the individual packages and convert them to OpenEmbedded naming convention
                        package = requirement.split("==")
                        package[0] = "python3-" + package[0].lower().replace("_", "-")

                        if integrations_only == "y":
                            if manifest["domain"] in integrations:
                                if upgrade_only == "y":
                                    if package[0] in list_of_recipes and version.parse(package[1]) != version.parse(list_of_versions[list_of_recipes.index(package[0])]):
                                        df.append(
                                            {
                                                "Component": manifest["domain"],
                                                "Dependencies": dependencies,
                                                "Requirements": package[0],
                                                "Required HA Version": package[1],
                                                "Availabe Yocto/OE Version": list_of_versions[list_of_recipes.index(package[0])],
                                            }
                                        )
                                else:
                                    if package[0] in list_of_recipes:
                                        df.append(
                                            {
                                                "Component": manifest["domain"],
                                                "Dependencies": dependencies,
                                                "Requirements": package[0],
                                                "Required HA Version": package[1],
                                                "Availabe Yocto/OE Version": list_of_versions[list_of_recipes.index(package[0])],
                                            }
                                        )
                                    else:
                                        df.append(
                                            {
                                                "Component": manifest["domain"],
                                                "Dependencies": dependencies,
                                                "Requirements": package[0],
                                                "Required HA Version": package[1],
                                                "Availabe Yocto/OE Version": [''],
                                            }
                                        )
                        else:
                            if upgrade_only == "y":
                                if package[0] in list_of_recipes and version.parse(package[1]) > version.parse(list_of_versions[list_of_recipes.index(package[0])]):
                                    df.append(
                                        {
                                            "Component": manifest["domain"],
                                            "Dependencies": dependencies,
                                            "Requirements": package[0],
                                            "Required HA Version": package[1],
                                            "Availabe Yocto/OE Version": list_of_versions[list_of_recipes.index(package[0])],
                                        }
                                    )
                            else:
                                if package[0] in list_of_recipes:
                                    df.append(
                                        {
                                            "Component": manifest["domain"],
                                            "Dependencies": dependencies,
                                            "Requirements": package[0],
                                            "Required HA Version": package[1],
                                            "Availabe Yocto/OE Version": list_of_versions[list_of_recipes.index(package[0])],
                                        }
                                    )
                                else:
                                    df.append(
                                        {
                                            "Component": manifest["domain"],
                                            "Dependencies": dependencies,
                                            "Requirements": package[0],
                                            "Required HA Version": package[1],
                                            "Availabe Yocto/OE Version": [''],
                                        }
                                    )

                # Uncomment below if you want also to see all components which have no requirements at all (and are auto included)
                # else: # Add dummy fields to the CSV
                #     package = ['', '']            
                #     df.append(
                #         {
                #             "Component": manifest["domain"],
                #             "Dependencies": dependencies,
                #             "Requirements": package[0],
                #             "Required Version": package[1],
                #         }
                #     )
                f.close()
        except FileNotFoundError:       
            print("Component manifest for " + component.split('/')[-1] + " not found!")
    return pd.DataFrame(df, columns=["Component", "Requirements", "Required HA Version", "Availabe Yocto/OE Version"]).explode("Requirements")

def main() -> None:
    """Main"""
    args = parse_arguments()

    ha_path = os.path.join(os.path.dirname(__file__), "HA")
    # First get the repository for scanning, read the manifest and distill the requirements
    get_repo(ha_path, args.version)
    manifest_info = parse_manifests(ha_path, args.upgrade, args.integrate)
    manifest_info.to_csv(args.version + '.csv', index=False)

    # Clean everything
    if args.clean == "y":
        shutil.rmtree(ha_path)
        print("Removed checked out HA repository")
    print("Finished")


if __name__ == "__main__":
    main()

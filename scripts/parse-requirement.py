from git import Repo
import os as os
import json as json
import csv
import shutil
import argparse


def parseArguments():
    # Create argument parser
    parser = argparse.ArgumentParser()

    parser.add_argument("-v", "--version", help="HA Version", type=str, default="")
    # Parse arguments
    args = parser.parse_args()

    return args


def getRepo(haPath, version):
    # Clone the HomeAssistant repository, or if it is already there initialize it
    try:
        repo = Repo.clone_from("https://github.com/home-assistant/core.git", haPath)
    except:
        repo = Repo(haPath)
    # Get the tags and sort them
    tags = sorted(repo.tags, key=lambda t: t.commit.committed_datetime)
    if version == "":
        latest_tag = tags[-1]
        version = latest_tag.name
        print("Found the following latest tag: " + version)
    else:
        print("Using tag: " + version)
    # Now that we have it, check out this branch
    repo.git.checkout(version)
    return repo, version


def parseManifests(haPath):
    componentsPath = os.path.join(haPath, "homeassistant/components")
    listOfComponents = [f.path for f in os.scandir(componentsPath) if f.is_dir()]
    manifestInfo = {}
    for component in listOfComponents:
        f = open(component + "/manifest.json")
        manifest = json.load(f)
        # Initialize manifest info as an empty dictionary
        manifestInfo[manifest["name"]] = {}
        # Check if manifest specifies dependencies
        if "dependencies" in manifest:
            manifestInfo[manifest["name"]]["dependencies"] = manifest["dependencies"]
        # Check if it specifies any requirements
        if "requirements" in manifest:
            manifestInfo[manifest["name"]]["requirements"] = manifest["requirements"]
        f.close()
    return manifestInfo


def getUniquePythonRequirements(manifestInfo):
    # Parse manifestInfo to create unique list of requirements
    requirements = []
    for component in manifestInfo:
        if "requirements" in manifestInfo[component]:
            requirements = requirements + (manifestInfo[component]["requirements"])
    requirements = list(set(requirements))
    return requirements


def compareWithLayers(requirements, haPath, layers, csvWriter):
    listOfRecipes = []
    missingRecipesList = {}
    foundRecipesList = {}
    for layer in layers:
        searchPath = os.path.join(haPath, layer)
        listOfRecipes = [
            f.name.strip(".bb")
            for f in os.scandir(searchPath)
            if (f.is_file() and f.name.endswith(".bb"))
        ]

        for requirement in requirements:
            # Split requirement in name and version of package
            package = requirement.split("==")
            package[0] = "python3-" + package[0].lower().replace("_","-")
            # Now for each requirement loop over the list of discovered recipes
            for recipe in listOfRecipes:
                recipe = recipe.split("_")
                # Case 1: check if recipe is available and is an exact match
                if package[0] + "_" + package[1] == recipe[0] + "_" + recipe[1]:
                    try:
                        del missingRecipesList[package[0]]
                    except:
                        pass
                    foundRecipesList[package[0]] = package[1]
                    csvWriter.writerow([package[0], package[1], package[1], layer])
                    break
                # Case 2: check if recipe is available but has the wrong version
                if package[0] == recipe[0]:
                    try:
                        del missingRecipesList[package[0]]
                    except:
                        pass
                    foundRecipesList[package[0]] = package[1]
                    csvWriter.writerow([package[0], package[1], recipe[1], layer])
                    break
                # Case 3: There is no recipe at all
            else:
                # Didn't find it in this layer so save it until we scanned all layers
                if package[0] not in foundRecipesList:
                    missingRecipesList[package[0]] = package[1]
    # Now add all missing items to csv as well
    for item in missingRecipesList:
        csvWriter.writerow([item, missingRecipesList[item], "-", "-"])


def main() -> None:
    args = parseArguments()

    haPath = os.path.join(os.path.dirname(__file__), "HA")
    # First get the repository for scanning, read the manifest and distill the requirements
    repo, name = getRepo(haPath, args.version)
    with open(name + ".csv", "w") as outputFile:
        csvWriter = csv.writer(outputFile)
        csvWriter.writerow(
            [
                "Package Name",
                "Required Package Version",
                "Found Package Version",
                "Layer Located",
            ]
        )

        manifestInfo = parseManifests(haPath)
        requirements = getUniquePythonRequirements(manifestInfo)

        # Now there are multiple places where the python recipes can be found, we need to combine them
        # 1: the meta-homeassistant layer
        # 2: poky
        # 3: the openembedded layer
        layers = [
            "../../../../sources/poky/meta/recipes-devtools/python",
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
            "../../recipes-devtools/python",
            "../../recipes-homeassistant/homeassistant",
            "../../recipes-homeassistant/homeassistant-core-deps",
            "../../recipes-homeassistant/homeassistant-component-deps",
        ]
        compareWithLayers(requirements, haPath, layers, csvWriter)

        # Clean everything
        shutil.rmtree(haPath)
        print("Finished")


if __name__ == "__main__":
    main()

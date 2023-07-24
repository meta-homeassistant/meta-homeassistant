from git import Repo
import os as os
import json as json

def getRepo(haPath):
    # Clone the HomeAssistant repository, or if it is already there initialize it
    try:
        repo = Repo.clone_from("https://github.com/home-assistant/core.git", haPath)
    except:
        repo = Repo(haPath)
    # Get the tags and sort them
    tags = sorted(repo.tags, key=lambda t: t.commit.committed_datetime)
    latest_tag = tags[-1]
    print("Found the following latest tag: " + latest_tag.name)
    # Now that we have it, check out this branch
    repo.git.checkout(latest_tag.name)
    return repo

def parseManifests(haPath):
    componentsPath = os.path.join(haPath, 'homeassistant/components')
    listOfComponents = [f.path for f in os.scandir(componentsPath) if f.is_dir()]
    manifestInfo = {}
    for component in listOfComponents:
        f = open(component + '/manifest.json')
        manifest = json.load(f)
        # Initialize manifest info as an empty dictionary
        manifestInfo[manifest['name']] = {}
        # Check if manifest specifies dependencies
        if 'dependencies' in manifest:
            manifestInfo[manifest['name']]['dependencies'] = manifest['dependencies']
        # Check if it specifies any requirements
        if 'requirements' in manifest:
            manifestInfo[manifest['name']]['requirements'] = manifest['requirements']
        f.close()
    return manifestInfo

def getUniquePythonRequirements(manifestInfo):
    # Parse manifestInfo to create unique list of requirements
    requirements = []
    for component in manifestInfo:
        if 'requirements' in manifestInfo[component]:
            requirements = requirements + (manifestInfo[component]['requirements'])
    requirements = list(set(requirements))
    return requirements

def compareWithLayer(requirements, path, outputFile):
    listOfRecipes = [f.name.strip('.bb') for f in os.scandir(path) if f.is_file()]
    for requirement in requirements:
        # Split requirement in name and version of package
        package = requirement.split('==')
        package[0] = 'python3-' + package[0]
        # Case 1: check if recipe is available and is an exact match
        searchQuery = package[0] + '_' + package[1]
        if searchQuery in listOfRecipes:
            outputFile.write('Found exact match for the following:\n\tRecipeName: ' + package[0] + '\n\tVersion number: ' + package[1] + '\n')
        else:
        # Case 2: check if recipe is available but has the wrong version
            searchQuery = package[0]
            for recipe in listOfRecipes:
                recipe = recipe.split('_')
                if searchQuery == recipe[0]:
                    outputFile.write('Found recipe but wrong version number for the following recipe:\n\tRecipeName: ' + package[0] + '\n\tRequired version number: ' + package[1] + '\n\tCurrently Available version number: ' + recipe[1] + '\n')
                    break
            # Case 3: There is no recipe at all
            outputFile.write('Found no recipe for the following:\n\tRecipeName: ' + package[0] + '\n\tRequired version number: ' + package[1] + '\n')
          
def main() -> None:
    outputFile = open('result.txt', 'w')
    haPath = os.path.join(os.getcwd(),"HA")
    repo = getRepo(haPath)
    manifestInfo = parseManifests(haPath)
    requirements = getUniquePythonRequirements(manifestInfo)
    # Now there are multiple places where the python recipes can be found
    # 1: the meta-homeassistant layer
    path = os.path.join(haPath, '../../recipes-devtools/python')
    compareWithLayer(requirements, path, outputFile)
    # 2: 
    print("Finished")
    outputFile.close()

if __name__ == "__main__":
    main()
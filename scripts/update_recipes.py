#!/usr/bin/env python3
"""
Script to update version numbers in integrations.inc based on a CSV file.
Usage: ./update_versions.py <date>
"""
import sys
import csv
import re
import os

if len(sys.argv) != 2:
    print(f"Usage: {sys.argv[0]} <date>")
    sys.exit(1)

date = sys.argv[1]
script_dir = os.path.dirname(os.path.abspath(__file__))
csv_file = os.path.join(script_dir, f"{date}.csv")
integrations_file = os.path.join(script_dir, "../recipes-homeassistant/homeassistant/python3-homeassistant/integrations.inc")

# Read CSV and build update map: {package_name: new_version}
updates = {}
with open(csv_file, newline='') as f:
    reader = csv.reader(f)
    header = next(reader)
    for row in reader:
        if not row or row[0].strip().lower() == 'component':
            continue
        pkg_col = row[3].strip() if len(row) > 3 else ''
        new_version = row[4].strip() if len(row) > 4 else ''
        if pkg_col and new_version:
            pkg_key = pkg_col.replace('python3-', '').replace('-', '_')
            updates[pkg_key] = (pkg_col, new_version)

# Read integrations.inc
with open(integrations_file, 'r') as f:
    lines = f.readlines()

updated = []
new_lines = []
for line in lines:
    # Match lines like: python3-zwave-js-server-python (>=0.63.0) or python3-zwave-js-server-python (>=0.63.0) \
    m = re.match(r'(\s*python3-([a-z0-9_\-]+) \(>=?|=) ?([0-9a-zA-Z\.-]+)(\))([ \\]*)', line)
    if m:
        pkg_name = m.group(2).replace('-', '_')
        for update_key, (pkg_col, new_version) in updates.items():
            if pkg_name == update_key:
                old_version = m.group(3)
                if old_version != new_version:
                    # Always add a trailing ' \' at the end of the line
                    new_line = f"{m.group(1)}{new_version}{m.group(4)} \\\n"
                    new_lines.append(new_line)
                    updated.append(f"{pkg_col}: {old_version} -> {new_version}")
                    break
        else:
            new_lines.append(line)
    else:
        new_lines.append(line)

with open(integrations_file, 'w') as f:
    f.writelines(new_lines)

if updated:
    print("Upgraded components:")
    for u in updated:
        print(u)
else:
    print("No upgrades performed.")

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

# Write upgraded components to a CSV next to this script
output_csv = os.path.join(script_dir, f"upgraded_components_{date}.csv")
with open(output_csv, 'w', newline='') as out_f:
    out_writer = csv.writer(out_f)
    out_writer.writerow(['package', 'old_version', 'new_version'])
    for u in updated:
        # entries are like 'python3-xxx: old -> new'
        m = re.match(r'([^:]+):\s*([0-9a-zA-Z\.\-]+)\s*->\s*([0-9a-zA-Z\.\-]+)', u)
        if m:
            out_writer.writerow([m.group(1).strip(), m.group(2).strip(), m.group(3).strip()])
        else:
            out_writer.writerow([u, '', ''])
print(f"Wrote upgraded components to: {output_csv}")

# --- Update integrations-tests.inc ---
tests_file = os.path.join(script_dir, "../recipes-homeassistant/homeassistant/python3-homeassistant/integrations-tests.inc")

# Read CSV again to get test status
add_tests = set()
remove_tests = set()
test_status = {}
with open(csv_file, newline='') as f:
    reader = csv.reader(f)
    header = next(reader)
    for row in reader:
        if not row or row[0].strip().lower() == 'component':
            continue
        component_col = row[0].strip() if len(row) > 0 else ''
        test_col = row[1].strip().lower() if len(row) > 1 else ''
        if component_col:
            comp_key = component_col.replace('-', '_')
            test_status[comp_key] = (component_col, test_col)

with open(tests_file, 'r') as f:
    tests_lines = f.readlines()

current_tests = set()
# Find block start and end
for section in ['COMPONENT_TEST_PACKAGES_FLAKY:append', 'COMPONENT_TEST_PACKAGES:append']:
    block_start_idx = None
    block_end_idx = None
    for idx, line in enumerate(tests_lines):
        if block_start_idx is None and line.strip().startswith(section + ' = "\\'):
            block_start_idx = idx + 1  # block starts after this line
        if block_start_idx is not None and "', '', d)}" in line:
            block_end_idx = idx
            break

    if block_start_idx is None or block_end_idx is None:
        print("COMPONENT_TEST_PACKAGES:append block not found.")
        sys.exit(1)

    # Parse current test packages
    
    for line in tests_lines[block_start_idx:block_end_idx]:
        m = re.match(r'\s*\$\{PN\}-([a-z0-9_\-]+) \\', line)
        if m:
            current_tests.add(m.group(1).replace('-', '_'))

for comp_key, (component_col, test_col) in test_status.items():
    if test_col == 'y' and comp_key not in current_tests:
        add_tests.add(comp_key)
    if test_col == 'n' and comp_key in current_tests:
        remove_tests.add(comp_key)

# Build new block
block_lines = []
for line in tests_lines[block_start_idx:block_end_idx]:
    m = re.match(r'\s*\$\{PN\}-([a-z0-9_\-]+) \\', line)
    pkg = m.group(1).replace('-', '_') if m else None
    if pkg and pkg in remove_tests:
        continue
    if line.strip():
        block_lines.append(line.rstrip())
for comp_key in sorted(add_tests):
    block_lines.append(f"    ${{PN}}-{comp_key.replace('_', '-')} \\")

# Write new file
new_tests_lines = (
    tests_lines[:block_start_idx]
    + [l + '\n' for l in block_lines]
    + tests_lines[block_end_idx:]
)
with open(tests_file, 'w') as f:
    f.writelines(new_tests_lines)

if add_tests:
    print("Added tests:")
    for t in sorted(add_tests):
        print(t)
if remove_tests:
    print("Removed tests:")
    for t in sorted(remove_tests):
        print(t)

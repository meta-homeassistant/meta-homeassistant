"""Offline unit tests for Home Assistant integration inventory generation."""

import json
import tempfile
import unittest
from pathlib import Path

from scripts.integration_inventory import (
    build_report,
    compare_integrations,
    parse_layer_metadata,
    read_upstream_integrations,
    render_report,
)


class ParseLayerMetadataTests(unittest.TestCase):
    def test_reads_supported_domains_dependencies_and_both_test_lists(self):
        integrations = '''INTEGRATIONS = "\\
    ${PN}-living-room \\
    ${PN}-no-dependency \\
"
PACKAGES += "${INTEGRATIONS}"
RDEPENDS:${PN}-living-room = "\\
    python3-sensor-lib (>=1.2.0) \\
"
'''
        integration_tests = '''COMPONENT_TEST_PACKAGES_FLAKY:append = "\\
    ${PN}-living-room \\
    ${@bb.utils.contains('PACKAGECONFIG', 'integration-tests', '', '', d)}"
COMPONENT_TEST_PACKAGES:append = "\\
    ${PN}-no-dependency \\
    ${@bb.utils.contains('PACKAGECONFIG', 'integration-tests', '', '', d)}"
'''

        supported, dependencies, test_domains = parse_layer_metadata(integrations, integration_tests)

        self.assertEqual(supported, {"living_room", "no_dependency"})
        self.assertEqual(dependencies["living_room"], {"python3-sensor-lib": ">=1.2.0"})
        self.assertEqual(test_domains, {"living_room", "no_dependency"})


class ReadUpstreamIntegrationsTests(unittest.TestCase):
    def test_reads_manifests_and_test_directories(self):
        with tempfile.TemporaryDirectory() as temp_dir:
            source_dir = Path(temp_dir)
            component_dir = source_dir / "homeassistant/components/living_room"
            component_dir.mkdir(parents=True)
            (component_dir / "manifest.json").write_text(
                json.dumps({"domain": "living_room", "requirements": ["Sensor_Lib==2.0"]}),
                encoding="utf-8",
            )
            (source_dir / "tests/components/living_room").mkdir(parents=True)
            (source_dir / "homeassistant/components/new_domain").mkdir()
            (source_dir / "homeassistant/components/new_domain/manifest.json").write_text(
                json.dumps({"domain": "new_domain", "requirements": []}),
                encoding="utf-8",
            )
            (source_dir / "tests/components").mkdir(parents=True, exist_ok=True)

            integrations, tested, errors = read_upstream_integrations(source_dir)

        self.assertEqual(integrations, {"living_room": {"python3-sensor-lib": "2.0"}, "new_domain": {}})
        self.assertEqual(tested, {"living_room"})
        self.assertEqual(errors, [])


class CompareAndRenderTests(unittest.TestCase):
    def test_equivalent_version_spellings_are_not_reported_as_different(self):
        result = compare_integrations(
            supported={"living_room"},
            current_dependencies={"living_room": {"python3-sensor-lib": ">=2.0.0"}},
            listed_test_domains=set(),
            upstream={"living_room": {"python3-sensor-lib": "2.0"}},
            upstream_test_domains=set(),
            errors=[],
        )

        self.assertEqual(result["dependency_findings"], [])

    def test_reports_membership_test_and_dependency_differences_stably(self):
        result = compare_integrations(
            supported={"living_room", "removed_domain"},
            current_dependencies={
                "living_room": {
                    "python3-sensor-lib": ">=1.0",
                    "python3-local-addon": "=3",
                }
            },
            listed_test_domains={"living_room"},
            upstream={
                "living_room": {
                    "python3-sensor-lib": "2.0",
                    "python3-new-addon": "1.0",
                },
                "new_domain": {},
            },
            upstream_test_domains={"new_domain"},
            errors=["bad manifest"],
        )

        self.assertEqual(result["new_upstream"], ["new_domain"])
        self.assertEqual(result["removed_upstream"], ["removed_domain"])
        self.assertEqual(result["new_tests"], [])
        self.assertEqual(result["listed_tests_missing_upstream"], ["living_room"])
        self.assertEqual(
            result["dependency_findings"],
            [
                ("missing", "living_room", "python3-new-addon", "", "1.0"),
                ("review", "living_room", "python3-local-addon", "=3", "not in manifest"),
                ("version", "living_room", "python3-sensor-lib", ">=1.0", "2.0"),
            ],
        )
        report = render_report("2026.10", "abc123", result)
        self.assertEqual(report, render_report("2026.10", "abc123", result))
        self.assertIn("No BitBake metadata was changed", report)
        self.assertIn("Source commit: `abc123`", report)
        self.assertIn("Upstream integrations not currently supported", report)

    def test_build_report_uses_layer_include_files(self):
        with tempfile.TemporaryDirectory() as temp_dir:
            layer_dir = Path(temp_dir) / "layer"
            metadata_dir = layer_dir / "recipes-homeassistant/homeassistant/python3-homeassistant"
            metadata_dir.mkdir(parents=True)
            (metadata_dir / "integrations.inc").write_text(
                'INTEGRATIONS = "\\\n    ${PN}-living-room \\\n"\n', encoding="utf-8"
            )
            (metadata_dir / "integrations-tests.inc").write_text("", encoding="utf-8")

            source_dir = Path(temp_dir) / "source"
            component_dir = source_dir / "homeassistant/components/living_room"
            component_dir.mkdir(parents=True)
            (component_dir / "manifest.json").write_text(
                json.dumps({"domain": "living_room", "requirements": []}),
                encoding="utf-8",
            )
            (source_dir / "tests/components").mkdir(parents=True)

            report = build_report(layer_dir, source_dir, "test-release", "abc123")

        self.assertIn("Home Assistant Integration Inventory: test-release", report)
        self.assertIn("Supported integrations present upstream: 1", report)


if __name__ == "__main__":
    unittest.main()
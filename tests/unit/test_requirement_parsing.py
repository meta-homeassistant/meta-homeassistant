"""Offline unit tests for Home Assistant manifest requirement parsing."""

import unittest

from scripts.integration_inventory import parse_requirement


class RequirementParsingTests(unittest.TestCase):
    def test_normalizes_distribution_name_and_accepts_extras(self):
        self.assertEqual(
            parse_requirement("Some_Package.extra[feature]==1.2.3"),
            ("python3-some-package-extra", "1.2.3"),
        )

    def test_rejects_non_exact_requirement(self):
        for requirement in ("some-package>=1.2", "some-package==1.*", "some-package==1,!=1.2"):
            with self.subTest(requirement=requirement):
                with self.assertRaisesRegex(ValueError, "expected one exact"):
                    parse_requirement(requirement)

    def test_rejects_markers_and_direct_urls(self):
        for requirement in (
            "some-package==1.2; python_version < '3.14'",
            "some-package @ https://example.invalid/some-package.whl",
        ):
            with self.subTest(requirement=requirement):
                with self.assertRaisesRegex(ValueError, "not handled"):
                    parse_requirement(requirement)

    def test_reports_invalid_requirement(self):
        with self.assertRaisesRegex(ValueError, "Unsupported Home Assistant requirement"):
            parse_requirement("not a valid requirement")

if __name__ == "__main__":
    unittest.main()
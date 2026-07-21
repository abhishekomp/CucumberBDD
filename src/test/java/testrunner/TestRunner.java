package testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * Cucumber JUnit test runner.
 *
 * @RunWith(Cucumber.class) – tells JUnit to hand control to Cucumber's runner,
 *   which discovers and executes all feature files.
 *
 * @CucumberOptions configures how Cucumber behaves:
 *   features  – path(s) to the .feature files (relative to project root)
 *   glue      – package(s) containing step-definition and hook classes
 *   plugin    – output formatters:
 *               "pretty"  → coloured console output showing each step result
 *               "html:…"  → self-contained HTML report in target/
 *               "json:…"  → machine-readable report (useful for CI integrations)
 *   dryRun    – when true, checks that every step has a matching definition
 *               WITHOUT actually executing them; useful for quick validation
 *   tags      – filter scenarios at runtime, e.g. "@P1 or @P2"
 *               Can also be passed from CLI: -Dcucumber.filter.tags=@P1
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"features"},
        glue     = {"steps"},
        plugin   = {
                "pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json"
        }
        // dryRun = true   ← uncomment to validate step bindings without running tests
        // tags = "@P1"    ← uncomment (or use -Dcucumber.filter.tags=@P1) to filter
)
public class TestRunner {
    // No code needed – Cucumber's runner handles everything via the annotations above.
}

package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (
        features = "src/test/resources/features",
        glue = {"stepDefinitions"},
        plugin = {
                "pretty","html:target/cucumber-reports.html",
                "json:target/cucumber-reports.json",
                "junit:target/cucumber-reports.xml"},
        monochrome = true,                          // Makes console output readable
        tags = "@SmokeTest",                        // Tags to include in the test run
        dryRun = false                          // Set to true to check mappings without executing the tests
)
public class TestRunner {
}

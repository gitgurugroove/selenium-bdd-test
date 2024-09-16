package runner;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/OpenCart_Automation.feature",
        glue = {"stepDefinitions"},
        plugin = {
                "pretty",
                "html:target/site/serenity/cucumber-reports.html",
                "json:target/site/serenity/cucumber-reports.json",
                "junit:target/site/serenity/cucumber-reports.xml"},
        monochrome = true,                          // Makes console output readable
        tags = "@OpenCart",                        // Tags to include in the test run
        dryRun = false                          // Set to true to check mappings without executing the tests
)
public class OpenCart_Test_Runner {
}

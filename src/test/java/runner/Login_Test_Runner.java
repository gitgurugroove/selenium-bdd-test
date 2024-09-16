package runner;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions"},
        plugin = {
                "pretty",
                "html:target/site/serenity/cucumber-reports.html",
                "json:target/site/serenity/cucumber-reports.json",
                "junit:target/site/serenity/cucumber-reports.xml"},
        monochrome = true,                          // Makes console output readable
        tags = "@Login_Functionality",                        // Tags to include in the test run
        dryRun = false                          // Set to true to check mappings without executing the tests
)
public class Login_Test_Runner {
}

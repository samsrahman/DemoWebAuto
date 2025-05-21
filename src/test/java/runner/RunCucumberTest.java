package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * The RunCucumberTest class is the entry point for running Cucumber tests.
 * It uses JUnit to execute the tests defined in the feature files.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        // Path to the directory containing Cucumber feature files
        features = "src/test/resources/features",
        // Package containing the step definitions
        glue = "steps",
        // Plugins for generating reports and output
        plugin = {
                "pretty", // Prints the Gherkin steps in the console in a readable format
                "html:target/cucumber-report.html", // Generates an HTML report in the specified location
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", // Integrates ExtentReports for advanced reporting

        }


)
public class RunCucumberTest {
        // This class remains empty and serves as a configuration for the Cucumber test runner
}
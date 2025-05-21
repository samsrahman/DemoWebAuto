package steps;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

/**
 * Hooks class to manage WebDriver setup, teardown, and additional functionality
 * such as capturing screenshots for failed test steps.
 */
public class Hooks {
    public static WebDriver driver;

    /**
     * Captures a screenshot if a test step fails and attaches it to the Cucumber scenario.
     *
     * @param scenario The current Cucumber scenario being executed.
     */
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed() && driver != null && driver instanceof TakesScreenshot) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/jpg", "Failed Step Screenshot");
        }
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * Initializes the WebDriver before each scenario.
     * Sets up a new ChromeDriver instance and maximizes the browser window.
     */
    @Before
    public void setUp(Scenario scenario) {
        boolean isMobile = scenario.getSourceTagNames().contains("@mobile");
        if (isMobile) {
            Map<String, String> mobileEmulation = new HashMap<>();
            mobileEmulation.put("deviceName", "Pixel 2");
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("mobileEmulation", mobileEmulation);
            driver = new ChromeDriver(options);
        } else {
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
    }


}
package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class stepDefinitions {
    WebDriver driver;

    @Given("User navigate to the login page")
    public void User_navigate_to_the_login_page() {
        // Set the path to the chromedriver executable
//        WebDriverManager.firefoxdriver().setup();  // Use WebDriverManager to setup GeckoDriver
//        driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "F:\\Dev Softwares\\chromedriver-win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    @When("User enters valid credentials")
    public void User_enters_valid_credentials() {
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();
    }

    @Then("User should be on the login page")
    public void User_should_be_on_the_login_page() {
        String expectedUrl = "practicetestautomation.com/logged-in-successfully/";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)) {
            System.out.println("Test is Passed and User Logged in Successfully");
            try {
                driver.wait(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Test Failed !");
        }

    }

    @Then("I should see a message saying {string}")
    public void i_should_see_a_message_saying_or(String string) {
        WebElement successMessgae = driver.findElement(By.className("post-title"));
        String message = successMessgae.getText();
        Assert.assertTrue("Expected Message Not found on the Login Page", message.contains("Logged In Successfully"));
    }

    @Then("I should see the Log out button")
    public void i_should_see_the_log_out_button() {
        WebElement logoutButton = driver.findElement(By.xpath("//a[text()='Log out']"));
        Assert.assertTrue("LogOut Button is not displayed", logoutButton.isDisplayed());

    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }

    }
}


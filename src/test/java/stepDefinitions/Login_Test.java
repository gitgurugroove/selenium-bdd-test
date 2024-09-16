package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Login_Test {
    WebDriver driver;

    @Given("User navigate to the login page")
    public void User_navigate_to_the_login_page() {
        // Set the path to the chromedriver executable
//        WebDriverManager.firefoxdriver().setup();  // Use WebDriverManager to setup GeckoDriver
//        driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
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

    @When("User enters Invalid Username and Valid Password")
    public void user_enters_invalid_username_and_valid_password() {
        driver.findElement(By.id("username")).sendKeys("incorrectUser");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();

    }

    @When("User enters valid Username and invalid Password")
    public void user_enters_valid_username_and_invalid_password() {
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("incorrectPassword");
        driver.findElement(By.id("submit")).click();
    }

    @Then("Login Error message is displayed and message is {string}")
    public void login_error_message_is_displayed_and_message_is(String string) {
        WebElement errorMessgae = driver.findElement(By.id("error"));
        String message = errorMessgae.getText();
        Assert.assertTrue("Expected Message Not found on the Login Page", message.contains("Your username is invalid!") || message.contains("Your password is invalid!"));
        driver.quit();
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
        driver.quit();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }

    }
}


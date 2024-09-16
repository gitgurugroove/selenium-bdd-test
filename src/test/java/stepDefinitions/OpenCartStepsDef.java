package stepDefinitions;

import Test_Classes.AccountDashboardPage;
import Test_Classes.HomePage;
import Test_Classes.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;


public class OpenCartStepsDef {

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private AccountDashboardPage dashboardPage;

    @Given("the user is on the OpenCart homepage")
    public void the_user_is_on_the_open_cart_homepage() throws InterruptedException {
        //Uncoomment if you want to run in a firefox driver
        //        WebDriverManager.firefoxdriver().setup();  // Use WebDriverManager to setup GeckoDriver
        //        driver = new FirefoxDriver();

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        // Instantiate HomePage object and open homepage
        homePage = new HomePage(driver);
        homePage.openHomePage();

        // Explicit wait for page load and simulate human-like behavior
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Thread.sleep(new Random().nextInt(3000) + 1000);

        // Verify homepage is loaded
        Assert.assertTrue("Homepage is not loaded", homePage.isSearchBoxVisible());
    }

    @Given("the user is on the OpenCart login page")
    public void the_user_is_on_the_open_cart_login_page() throws InterruptedException {
        // Instantiate LoginPage object and open login page
        loginPage = new LoginPage(driver);
        loginPage.openLoginPage();

        // Wait for the login page to load
        Thread.sleep(5000);

        // Verify the login page is loaded
        Assert.assertTrue("Login page is not loaded", loginPage.isLoginPage());
    }

    @When("they enter valid credentials and click on login")
    public void they_enter_valid_credentials_and_click_on_login() {
        // Use the loginPage object to enter credentials
        String validEmail = "sushil.18ben1029@gmail.com";  // Replace with valid email
        String validPassword = "password123";  // Replace with valid password
        loginPage.enterCredentials(validEmail, validPassword);
    }

    @Then("they should be redirected to the  my account dashboard")
    public void they_should_be_redirected_to_the_my_account_dashboard() {
        // Instantiate AccountDashboardPage object
        dashboardPage = new AccountDashboardPage(driver);

        // Wait for the URL to change to the dashboard
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(webDriver -> dashboardPage.isOnDashboard());

        // Verify that the user is on the account dashboard
        Assert.assertTrue("Not on the dashboard", dashboardPage.isOnDashboard());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

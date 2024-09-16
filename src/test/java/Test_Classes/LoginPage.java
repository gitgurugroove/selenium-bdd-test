package Test_Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to open the login page
    public void openLoginPage() {
        driver.get("https://demo.opencart.com/en-gb?route=account/login");
    }

    // Method to enter credentials
    public void enterCredentials(String email, String password) {
        WebElement emailField = driver.findElement(By.id("input-email"));
        WebElement passwordField = driver.findElement(By.id("input-password"));

        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        passwordField.submit(); // Submitting the form
    }

    // Method to check if login page is displayed
    public boolean isLoginPage() {
        return driver.getCurrentUrl().contains("route=account/login");
    }
}
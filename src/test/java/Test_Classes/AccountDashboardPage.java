package Test_Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountDashboardPage {
    private WebDriver driver;

    // Constructor
    public AccountDashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to verify user is on the dashboard
    public boolean isOnDashboard() {
        return driver.getCurrentUrl().contains("account/account");
    }
}
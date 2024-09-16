package Test_Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to open the homepage
    public void openHomePage() {
        driver.get("https://demo.opencart.com/en-gb?route=common/home");
    }

    // Any other interactions with homepage can go here
    public boolean isSearchBoxVisible() {
        return driver.findElement(By.name("search")).isDisplayed();
    }
}
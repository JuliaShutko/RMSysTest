package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static helpers.Locators.get;

public class HomePage {
    WebDriver driver;

    private By logout = get("homePage.logoutLink");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage logout() {
        WebElement logoutLink = driver.findElement(logout);
        logoutLink.click();
        return new LoginPage(driver);
    }
}

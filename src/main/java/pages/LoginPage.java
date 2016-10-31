package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static helpers.Locators.get;

public class LoginPage {
    public WebDriver driver;

    private static final By userName = get("loginPage.userName");
    private static final By password = get("loginPage.password");
    private static final By submit = get("loginPage.submit");
    private static final By passwordValidation = get("loginPage.validationMessage");
    private static final By loginForm = get("loginPage.loginForm");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private void setUserName(String strUserName){
        WebElement userNameField = driver.findElement(userName);
        userNameField.sendKeys(strUserName);
    }

    private void setPassword(String strPassword){
        WebElement passwordField = driver.findElement(password);
        passwordField.sendKeys(strPassword);
    }

    private void clickLogin(){
        WebElement submitButton = driver.findElement(submit);
        submitButton.click();
    }

    public HomePage login(String userName, String password) throws InterruptedException {
        setUserName(userName);
        setPassword(password);
        clickLogin();
        return new HomePage(driver);
    }

    public WebElement getValidationMessageElement() {
        return driver.findElement(passwordValidation);
    }

    public WebElement getLoginFormElement() {
        return driver.findElement(loginForm);
    }

}

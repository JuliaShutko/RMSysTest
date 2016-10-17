package pages;


import com.sun.deploy.util.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static helpers.Locators.get;

public class LoginPage {
    WebDriver driver;

    private By userName = get("loginPage.userName");
    private By password = get("loginPage.password");
    private By submit = get("loginPage.submit");
    private By passwordValidation = get("loginPage.validationMessage");
    private By loginForm = get("loginPage.loginForm");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUserName(String strUserName){
        WebElement userNameField = driver.findElement(userName);
        userNameField.sendKeys(strUserName);
    }

    public void setPassword(String strPassword){
        WebElement passwordField = driver.findElement(password);
        passwordField.sendKeys(strPassword);
    }

    public void clickLogin(){
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

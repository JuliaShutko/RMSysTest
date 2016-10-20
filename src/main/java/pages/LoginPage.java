package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    WebDriver driver;

    @FindBy(id = "Username")
    private WebElement userNameField;

    @FindBy(id = "Password")
    private WebElement passwordField;

    @FindBy(id = "SubmitButton")
    private WebElement submitButton;

    @FindBy(id = "password-box-validation")
    private WebElement passwordValidation;

    @FindBy(css = ".form-container")
    private WebElement loginForm;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setPassword(String strPassword) {
        passwordField.sendKeys(strPassword);
    }

    public void clickLogin() {
        submitButton.click();
    }

    public HomePage login(String userName, String password) throws InterruptedException {
        userNameField.sendKeys(userName);
        passwordField.sendKeys(password);
        submitButton.click();
        return new HomePage(driver);
    }

    public WebElement getValidationMessageElement() {
        return passwordValidation;
    }

    public WebElement getLoginFormElement() {
        return loginForm;
    }

}

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    public WebDriver driver;
    public LoginPage objLogin;
    public HomePage objHomePage;
    public static final String BASE_URL = "https://192.168.100.26/";
    public static final String LOGIN = "EugenBorisik";
    public static final String PASSWORD = "123";
    public static final String EMPTY_PASSWORD = "";
    public static final String HOME_PAGE_NAME = "RMSys - Home";
    public static final String PASSWORD_FIELD_VALIDATION_MESSAGE = "Password is required";

    @BeforeMethod
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    @AfterMethod
    public void quit() {
        driver.quit();
    }

    @Test
    public void successLoginTest() throws InterruptedException {
        objLogin = new LoginPage(driver);
        objHomePage = objLogin.login(LOGIN, PASSWORD);
        Assert.assertTrue(driver.getTitle().equals(HOME_PAGE_NAME));
    }

    @Test
    public void failedLoginTest() throws InterruptedException {
        objLogin = new LoginPage(driver);
        objHomePage = objLogin.login(LOGIN, EMPTY_PASSWORD);
        WebElement passwordValidationMessage = objLogin.getValidationMessageElement();
        Assert.assertEquals(passwordValidationMessage.getText(), PASSWORD_FIELD_VALIDATION_MESSAGE);
    }
}

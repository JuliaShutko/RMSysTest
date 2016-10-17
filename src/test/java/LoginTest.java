import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    WebDriver driver;
    LoginPage objLogin;
    HomePage objHomePage;
    public static final String BASE_URL = "https://192.168.100.26/";

    @BeforeMethod
    public void setup(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    @AfterMethod
    public void  quit() {
        driver.quit();
    }

    @Test
    public void successLoginTest() throws InterruptedException {
        objLogin = new LoginPage(driver);
        objHomePage = objLogin.login("EugenBorisik","123");
        Assert.assertTrue(driver.getTitle().equals("RMSys - Home"));
    }

    @Test
    public void failedLoginTest() throws InterruptedException {
        objLogin = new LoginPage(driver);
        objHomePage = objLogin.login("EugenBorisik","");
        Assert.assertTrue(driver.getTitle().equals("RMSys - Sign In"));
        WebElement passwordValidationMessage = objLogin.getValidationMessageElement();
        Assert.assertTrue(passwordValidationMessage.isDisplayed());
        Assert.assertEquals(passwordValidationMessage.getText(), "Password is required");
    }
}

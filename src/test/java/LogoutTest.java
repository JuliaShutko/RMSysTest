import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class LogoutTest {

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
    public void logoutTest() throws InterruptedException {
        objLogin = new LoginPage(driver);
        objHomePage = objLogin.login("EugenBorisik","123");
        Assert.assertTrue(driver.getTitle().equals("RMSys - Home"));
        objLogin = objHomePage.logout();
        Assert.assertEquals(driver.getTitle(), "RMSys - Sign In");
        WebElement loginForm = objLogin.getLoginFormElement();
        Assert.assertTrue(loginForm.isDisplayed());
    }

}

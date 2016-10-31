package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public WebDriver driver;

    @FindBy(css = ".sign-out-span ins")
    private WebElement logout;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage logout() {
        logout.click();
        return new LoginPage(driver);
    }

}

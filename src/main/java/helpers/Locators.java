package helpers;

import org.openqa.selenium.By;

import java.io.InputStream;
import java.util.Properties;

public class Locators {
    private static final Properties LOCATORS;

    private enum LocatorType {
        id, name, css, xpath, tag, text, partText
    }

    static {
        LOCATORS = new Properties();
        try {
            InputStream in = Locators.class.getResourceAsStream("/Locators.properties");
            LOCATORS.load(in);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static By get(String elementName) {
        String locator = LOCATORS.getProperty(elementName);
        return getLocator(locator);
    }

    public static String get() {
        return LOCATORS.getProperty("");
    }

    public static By get(String elementName, String value) {
        String locator = LOCATORS.getProperty(elementName);
        return getLocator(String.format(locator, value));
    }

    private static By getLocator(String locator) {
        String[] locatorItems = locator.split("=", 2);
        LocatorType locatorType = LocatorType.valueOf(locatorItems[0]);

        switch (locatorType) {

            case id: {
                return By.id(locatorItems[1]);
            }

            case name: {
                return By.name(locatorItems[1]);
            }

            case css: {
                return By.cssSelector(locatorItems[1]);
            }

            case xpath: {
                return By.xpath(locatorItems[1]);
            }

            case tag: {
                return By.tagName(locatorItems[1]);
            }

            case text: {
                return By.linkText(locatorItems[1]);
            }

            case partText: {
                return By.partialLinkText(locatorItems[1]);
            }

            default: {
                throw new IllegalArgumentException("No such locator type: " + locatorItems[0]);
            }
        }
    }
}

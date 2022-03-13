package tests;

import configuration.ConfigurationProperties;
import configuration.PropertiesLoader;
import driverManager.BrowserType;
import driverManager.DriverManager;
import driverManager.DriverUtils;
import navigation.ApplicationURLs;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    @BeforeClass
    public void beforeClass() {
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        Properties propertiesFromFile = propertiesLoader.getPropertiesFromFile("configuration.properties");
        ConfigurationProperties.setProperties(propertiesFromFile);
    }
    @Parameters("browser")
    @BeforeMethod
    public void beforeTest(@Optional BrowserType browserType) {
        DriverManager.setWebDriver(browserType);
        DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage(ApplicationURLs.APLICATION_URI);

    }

    @AfterMethod
    public void afterTest() {
        DriverManager.disposeDriver();
    }
}

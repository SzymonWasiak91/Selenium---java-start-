package tests;

import configuration.ConfigurationProperties;
import configuration.PropertiesLoader;
import driverManager.DriverManager;
import driverManager.DriverUtils;
import navigation.ApplicationURLs;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    @BeforeClass
    public void beforeClass() {
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        Properties propertiesFromFile = propertiesLoader.getPropertiesFromFile("configuration.properties");
        ConfigurationProperties.setProperties(propertiesFromFile);
    }

    @BeforeMethod
    public void beforeTest() {
        DriverManager.getWebdriver();
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage(ApplicationURLs.APLICATION_URI);

    }

    @AfterMethod
    public void afterTest() {
        DriverManager.disposeDriver();
    }
}

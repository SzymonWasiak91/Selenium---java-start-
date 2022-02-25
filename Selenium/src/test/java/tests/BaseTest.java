package tests;

import driverManager.DriverManager;
import driverManager.DriverUtils;
import navigation.ApplicationURLs;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {



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

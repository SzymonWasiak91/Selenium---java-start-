package tests;

import driverManager.DriverManager;
import driverManager.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {



    @BeforeMethod
    public void beforeTest() {
        DriverManager.getWebdriver();
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage("http://przyklady.javastart.pl/jpetstore/");

    }

    @AfterMethod
    public void afterTest() {
        DriverManager.disposeDriver();
    }
}

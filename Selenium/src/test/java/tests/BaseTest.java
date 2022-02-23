package tests;

import driverManager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
   private WebDriver driver;
    @BeforeMethod
    public void beforeTest() {

        driver = DriverManager.getWebdriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://przyklady.javastart.pl/jpetstore/");
    }

    @AfterMethod
    public void afterTest() {
        DriverManager.disposeDriver();
    }
}

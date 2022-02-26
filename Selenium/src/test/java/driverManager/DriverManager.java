package driverManager;

import configuration.LocalWebDriverProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    private static WebDriver driver;
    private DriverManager(){

    }
    public static WebDriver getWebdriver(){
        if(driver==null){
            driver = BrowserFactory.getBrowser(LocalWebDriverProperties.getLocalBrowser());
        }
        return driver;
    }
    public static void disposeDriver() {
        driver.close();
        driver = null;
    }
}

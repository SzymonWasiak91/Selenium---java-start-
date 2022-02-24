package driverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private static final BrowserType BROWSER_TYPE = BrowserType.EDGE;
    private static WebDriver driver;
    private DriverManager(){

    }
    public static WebDriver getWebdriver(){
        if(driver==null){
            driver = BrowserFactory.getBrowser(BROWSER_TYPE);
        }
        return driver;
    }
    public static void disposeDriver() {
        driver.close();
        driver = null;
    }
}

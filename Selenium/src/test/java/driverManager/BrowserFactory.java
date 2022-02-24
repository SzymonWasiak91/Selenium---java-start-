package driverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {


    public static WebDriver getBrowser(BrowserType browserType){
        switch (browserType){
            case CHROME:
                 System.setProperty("webdriver.chrome.driver", "C:/Users/wasia/IdeaProjects/advanced-selenium-webdriver/BEGINNING/MultiPomProject/Selenium/src/test/java/driverManager/drivers/chromedriver.exe");
                 return new ChromeDriver();
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "C:/Users/wasia/IdeaProjects/advanced-selenium-webdriver/BEGINNING/MultiPomProject/Selenium/src/test/java/driverManager/drivers/geckodriver.exe");
                return new FirefoxDriver();
            case IE:
                System.setProperty("webdriver.ie.driver", "C:/Users/wasia/IdeaProjects/advanced-selenium-webdriver/BEGINNING/MultiPomProject/Selenium/src/test/java/driverManager/drivers/IEDriverServer.exe");
                return new InternetExplorerDriver();
            default:
                throw new IllegalStateException("Unknown browser type! Please check your configuration");
        }
    }
}

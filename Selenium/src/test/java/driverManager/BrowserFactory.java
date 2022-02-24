package driverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class BrowserFactory {


    public static WebDriver getBrowser(BrowserType browserType){
        switch (browserType){
            case CHROME:
                WebDriverManager.chromedriver().setup();
//                 System.setProperty("webdriver.chrome.driver", "C:/Users/wasia/IdeaProjects/advanced-selenium-webdriver/BEGINNING/MultiPomProject/Selenium/src/test/java/driverManager/drivers/chromedriver.exe");
                 return new ChromeDriver();
            case EDGE:
//                System.setProperty("webdriver.gecko.driver", "C:/Users/wasia/IdeaProjects/advanced-selenium-webdriver/BEGINNING/MultiPomProject/Selenium/src/test/java/driverManager/drivers/geckodriver.exe");
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            case OPERA:
//                System.setProperty("webdriver.ie.driver", "C:/Users/wasia/IdeaProjects/advanced-selenium-webdriver/BEGINNING/MultiPomProject/Selenium/src/test/java/driverManager/drivers/IEDriverServer.exe");
                  WebDriverManager.operadriver().setup();
                return new OperaDriver();
            default:
                throw new IllegalStateException("Unknown browser type! Please check your configuration");
        }
    }
}

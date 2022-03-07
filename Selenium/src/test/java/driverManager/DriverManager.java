package driverManager;

import configuration.LocalWebDriverProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static configuration.TestRunProperties.getBrowserToRun;
import static configuration.TestRunProperties.getIsRemoteRun;

public class DriverManager {


    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    private DriverManager(){

    }

    public static WebDriver getWebDriver() {

        if (webDriverThreadLocal.get() == null) {

            //Wywołanie metody getBrowser() z klasy BrowserFactory zwraca instancję WebDrivera, który następnie jest
            // dodana do puli instancji klasy ThreadLocal za pomocą metody set()
            webDriverThreadLocal.set(new BrowserFactory(getBrowserToRun(), getIsRemoteRun()).getBrowser());
        }

        return webDriverThreadLocal.get();
    }
    public static void disposeDriver() {
        webDriverThreadLocal.get().close();
        webDriverThreadLocal = null;
    }
}

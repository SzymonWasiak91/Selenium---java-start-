package driverManager;

import configuration.LocalWebDriverProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static configuration.TestRunProperties.getBrowserToRun;
import static configuration.TestRunProperties.getIsRemoteRun;

public class DriverManager {


    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
    private static ThreadLocal<BrowserType>browserTypeThreadLocal = new ThreadLocal<>();
    private DriverManager(){

    }
    //Metoda służy od ustawiania typu przeglądarki dla danego wątku
    public static void setWebDriver(BrowserType browserType) {

        //Obiekt typu WebDriver, który w kolejnych liniach zostanie zainicjalizowany wywołaniem metody getBrowser() z klasy BrowserFactory
        WebDriver browser = null;

        //Jeśli obiekt browserType będzie nullem, wtedy dla danego wątku zostanie wybrana przeglądarka zdefiniowana
        // w pliku configuration.properties
        if (browserType == null) {

            //Utworzenie instancji WebDrivera dla opcji gdy browserType jest nullem
            //Zostanie wtedy wybrana przeglądarka zdefiniowana w pliku configuration.properties
            browserType = getBrowserToRun();
            browser = new BrowserFactory(browserType, getIsRemoteRun()).getBrowser();
        } else {
            //Utworzenie instancji WebDrivera dla opcji gdy browserType nie jest nullem
            //To znaczy, że został on zdefiniowany w pliku TestNG XML i możemy go używać
            browser = new BrowserFactory(browserType, getIsRemoteRun()).getBrowser();
        }

        //Dodanie do puli instancji ThreadLocal za pomocą metody set() instancji klasy BrowserType
        browserTypeThreadLocal.set(browserType);

        //Dodanie do puli instancji ThreadLocal za pomocą metody set() instancji klasy WebDriver
        webDriverThreadLocal.set(browser);
    }





    public static WebDriver getWebDriver() {


        if (webDriverThreadLocal.get() == null) {
            webDriverThreadLocal.set(new BrowserFactory(getBrowserToRun(), getIsRemoteRun()).getBrowser());
        }

        return webDriverThreadLocal.get();
    }
    public static void disposeDriver() {
        webDriverThreadLocal.get().close();
        webDriverThreadLocal = null;
    }
}

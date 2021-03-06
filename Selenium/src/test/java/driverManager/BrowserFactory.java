package driverManager;

import configuration.LocalWebDriverProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserFactory {

    private static final String MESSAGE_UNKNOWN_BROWSER = "Unknown browser type! Please check your configuration";

    //Pole określające typ przeglądarki
    private BrowserType browserType;

    //Pole określające czy uruchomienie jest zdalne czy lokalne
    private boolean isRemoteRun;

    //Konstruktor dla klasy, który ustawia wartości pól browserType or isRemoteRun
    public BrowserFactory(BrowserType browserType, boolean isRemoteRun) {
        this.browserType = browserType;
        this.isRemoteRun = isRemoteRun;
    }


    //Metoda dostarcza obiekt WebDrivera
    public WebDriver getBrowser() {

        //Sprawdzamy czy uruchomienie jest zdalne, jeśli tak to kod wejdzie do warunku
        if (isRemoteRun) {

            //Tworzymy obiekt desiredCapabilities, który jest wymagany do wyboru przeglądarki
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

            //Wybór przeglądarki w zależności od wartości pola browserType
            switch (browserType) {
                case CHROME:

                    //Do wyboru przeglądarki Chrome używamy klasy ChromeOptions
                    ChromeOptions chromeOptions = new ChromeOptions();
                    desiredCapabilities.merge(chromeOptions);
                    return getRemoteWebDriver(desiredCapabilities);
                case EDGE:

                    //Do wyboru przeglądarki FireFox używamy klasy FireFoxOptions
                    EdgeOptions edgeOptions = new EdgeOptions();
                    desiredCapabilities.merge(edgeOptions);
                    return getRemoteWebDriver(desiredCapabilities);
                case OPERA:

                    //Do wyboru przeglądarki InternetExplorer używamy klasy InternetExplorerOptions
                    OperaOptions operaOptions = new OperaOptions();
                    desiredCapabilities.merge(operaOptions);
                    return getRemoteWebDriver(desiredCapabilities);
                default:
                    throw new IllegalStateException(MESSAGE_UNKNOWN_BROWSER);
            }

            //Jeśli uruchomienie nie jest zdalne, kod wchodzi do else. Jest to uruchomienie lokalne
        } else {

            //Wybór przeglądarki w zależności od wartości pola browserType. Analogicznie jak wyżej
            switch (browserType) {
                case CHROME:
                    System.setProperty("webdriver.chrome.driver", LocalWebDriverProperties.getChromeWebDriverLocation());
                    return new ChromeDriver();
                case EDGE:
                    System.setProperty("webdriver.edge.driver", LocalWebDriverProperties.getEdgeWebDriverLocation());
                    return new EdgeDriver();
                case OPERA:
                    System.setProperty("webdriver.opera.driver", LocalWebDriverProperties.getOperaWebDriverLocation());
                    return new OperaDriver();
                default:
                    throw new IllegalStateException(MESSAGE_UNKNOWN_BROWSER);
            }

        }
    }

    //Metoda zwraca nam obiekt RemoteWebDrivera na podstawie obiektu desiredCapabilities
    private WebDriver getRemoteWebDriver(DesiredCapabilities desiredCapabilities) {
        RemoteWebDriver remoteWebDriver = null;

        //Zauważ, że RemoteWebDriver znajduje się w bloku try-catch. Wynika to z faktu, że obiekt URL rzuca wyjątkiem MalformedURLException
        try {
            remoteWebDriver = new RemoteWebDriver(new URL("GRID_URL"), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to create RemoteWebDriver due to: " + e.getMessage());
        }
        return remoteWebDriver;
    }
}
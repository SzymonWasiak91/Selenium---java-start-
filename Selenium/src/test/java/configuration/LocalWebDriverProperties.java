package configuration;

import driverManager.BrowserType;

public class LocalWebDriverProperties {


    public static String getChromeWebDriverLocation() {
        return ConfigurationProperties.getProperties().getProperty("chrome.driver.location");
    }

    public static String getEdgeWebDriverLocation() {
        return ConfigurationProperties.getProperties().getProperty("edge.driver.location");
    }

    public static String getOperaWebDriverLocation() {
        return ConfigurationProperties.getProperties().getProperty("opera.driver.location");
    }
}
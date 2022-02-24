package driverManager;

public enum BrowserType {



        EDGE("edge"),
        CHROME("chrome"),
        OPERA("internetexplorer");

        private final String browser;

        BrowserType(String browser) {
            this.browser = browser;
        }
}

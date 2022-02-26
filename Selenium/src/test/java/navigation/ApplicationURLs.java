package navigation;

import configuration.AppProperties;

public class ApplicationURLs {
    public static final String APLICATION_URI = AppProperties.getAllUrl();
    public static final String LOGIN_URL = APLICATION_URI + "actions/Account.action?signonForm=";
}

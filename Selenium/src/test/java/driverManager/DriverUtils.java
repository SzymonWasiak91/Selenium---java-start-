package driverManager;

import java.time.Duration;

public class DriverUtils {


    public static void setInitialConfiguration(){
//        DriverManager.getWebdriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        DriverManager.getWebdriver().manage().window().maximize();
    }
    public static void navigateToPage(String pageUrl){
        DriverManager.getWebdriver().navigate().to(pageUrl);
    }
}

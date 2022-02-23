package waits;

import driverManager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitForElement {


    public static WebDriverWait getWebdriverWait(){
        return new WebDriverWait(DriverManager.getWebdriver(), Duration.ofSeconds(10));
    }
    public static void waitUntilElementIsClickable(WebElement element){
        WebDriverWait webDriverWait = getWebdriverWait();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void waitUntilElementIsVisible(WebElement element){
        WebDriverWait wait = getWebdriverWait();
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}

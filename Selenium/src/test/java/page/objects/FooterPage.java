package page.objects;

import driverManager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class FooterPage {
    @FindBy(css = "#Banner img[src*='dog']")
    private WebElement footerBanner;

    public FooterPage(){
        PageFactory.initElements(DriverManager.getWebdriver(),this);
    }
    public Boolean isBannerIsDisplayed(){
        WaitForElement.waitUntilElementIsVisible(footerBanner);
       Boolean isDisplayed = footerBanner.isDisplayed();
       return  isDisplayed;
    }






}

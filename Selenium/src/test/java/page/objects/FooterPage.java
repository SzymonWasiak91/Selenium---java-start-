package page.objects;

import driverManager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class FooterPage {
    @FindBy(css = "#Banner img[src*='dog']")
    private WebElement footerBanner;
    private Logger logger = LogManager.getRootLogger();

    public FooterPage(){
        PageFactory.initElements(DriverManager.getWebdriver(),this);
    }
    public Boolean isBannerIsDisplayed(){
        logger.info("Wait for visible footer banner");
        WaitForElement.waitUntilElementIsVisible(footerBanner);
       Boolean isDisplayed = footerBanner.isDisplayed();
        logger.info("Footer banner is visible");
       return  isDisplayed;


    }






}

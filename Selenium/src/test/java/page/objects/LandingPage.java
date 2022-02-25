package page.objects;

import driverManager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class LandingPage {
    @FindBy(css = "#Content a")
    private WebElement enterStoreLink;
    private Logger logger = LogManager.getRootLogger();
    public LandingPage() {
        PageFactory.initElements(DriverManager.getWebdriver(), this);
    }

    public TopMenuPage clickOnEnterStoreLink() {
        logger.info("Trying to click Enter Store link");
        WaitForElement.waitUntilElementIsClickable(enterStoreLink);
        enterStoreLink.click();
        logger.info("Clicked on Enter Store link");
        return new TopMenuPage();
    }
}

package page.objects;

import driverManager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class FishListPage {
    @FindBy(css = "tr:nth-child(2) a")
    private WebElement angelfishIdLink;

    private Logger logger = LogManager.getRootLogger();
    public FishListPage() {

        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public AngelFishListPage clickOnAngelfishId() {
        logger.info("Click on angel fish");
        WaitForElement.waitUntilElementIsClickable(angelfishIdLink);
        angelfishIdLink.click();
        logger.info("Click on angel fish is done");
        return new AngelFishListPage();
    }
}

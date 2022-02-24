package page.objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driverManager.DriverManager;
import waits.WaitForElement;

public class AngelFishListPage {

    @FindBy(css = "a.Button[href$='EST-2']")
    private WebElement smallAngelfishAddToCartButton;
    private Logger logger = LogManager.getRootLogger();

    public AngelFishListPage() {
        PageFactory.initElements(DriverManager.getWebdriver(), this);
    }

    public void clickOnAddToCartSmallAngelfish() {
        logger.info("Trying to click small angel fish");
        WaitForElement.waitUntilElementIsClickable(smallAngelfishAddToCartButton);
        smallAngelfishAddToCartButton.click();
        logger.info("Click on samll angel fish is done");
    }
}

package page.objects;

import driverManager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class TopMenuPage {

    @FindBy(xpath = "//*[@id='MenuContent']/a[2]")
    private WebElement singLink;
    private Logger logger = LogManager.getRootLogger();
    public TopMenuPage() {
        PageFactory.initElements(DriverManager.getWebdriver(), this);
    }

    public void singInLink() {
        logger.info("Trying to click sing in link");
        WaitForElement.waitUntilElementIsClickable(singLink);
        singLink.click();
        logger.info("Click in link button done");
    }
}

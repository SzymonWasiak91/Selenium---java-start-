package page.objects;
import driverManager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class ShoppingCartPage {
    @FindBy(css = "a[href$='newOrderForm=']")
    private WebElement proceedToCheckoutButton;
    private Logger logger = LogManager.getRootLogger();
    public ShoppingCartPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void clickOnProceedToCheckout() {
        logger.info("Trying click to checkout button");
        WaitForElement.waitUntilElementIsClickable(proceedToCheckoutButton);
        proceedToCheckoutButton.click();
        logger.info("Done to click checkout button");
    }
}

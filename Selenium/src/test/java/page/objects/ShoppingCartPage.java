package page.objects;

import driverManager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
    @FindBy(css = "a[href$='newOrderForm=']")
    private WebElement proceedToCheckoutButton;

    public ShoppingCartPage() {
        PageFactory.initElements(DriverManager.getWebdriver(), this);
    }

    public void clickOnProceedToCheckout() {
        proceedToCheckoutButton.click();
    }
}

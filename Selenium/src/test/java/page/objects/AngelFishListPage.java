package page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driverManager.DriverManager;

public class AngelFishListPage {

    @FindBy(css = "a.Button[href$='EST-2']")
    private WebElement smallAngelfishAddToCartButton;


    public AngelFishListPage() {
        PageFactory.initElements(DriverManager.getWebdriver(), this);
    }

    public void clickOnAddToCartSmallAngelfish() {
        smallAngelfishAddToCartButton.click();
    }
}

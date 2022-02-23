package page.objects;

import driverManager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FishListPage {
    @FindBy(css = "tr:nth-child(2) a")
    private WebElement angelfishIdLink;


    public FishListPage() {

        PageFactory.initElements(DriverManager.getWebdriver(), this);
    }

    public void clickOnAngelfishId() {

        angelfishIdLink.click();
    }
}

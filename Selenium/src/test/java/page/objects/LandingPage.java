package page.objects;

import driverManager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class LandingPage {
    @FindBy(css = "#Content a")
    private WebElement enterStoreLink;

    public LandingPage() {
        PageFactory.initElements(DriverManager.getWebdriver(), this);
    }

    public void clickOnEnterStoreLink() {
        WaitForElement.waitUntilElementIsClickable(enterStoreLink);
        enterStoreLink.click();
    }
}

package page.objects;

import driverManager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopMenuPage {

    @FindBy(xpath = "//*[@id='MenuContent']/a[2]")
    private WebElement singLink;

    public TopMenuPage() {
        PageFactory.initElements(DriverManager.getWebdriver(), this);
    }

    public void singInLink() {
        singLink.click();
    }
}

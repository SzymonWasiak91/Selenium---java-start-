package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterPage {
    @FindBy(css = "#Banner img[src*='dog']")
    private WebElement footerBanner;

    WebDriver driver;
    public FooterPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public Boolean isBannerIsDisplayed(){
       Boolean isDisplayed = footerBanner.isDisplayed();
       return  isDisplayed;
    }






}

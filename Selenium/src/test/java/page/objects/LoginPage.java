package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(name = "username")
    private WebElement userNameField;
    @FindBy(name = "password")
    private WebElement passwordField;
    @FindBy(xpath = "//input[@value='Login']")
    private WebElement buttonLogIn;
    @FindBy(xpath = "//*[@id='Content']/ul/li")
    private WebElement wrongText;
    @FindBy(css = "area[alt='Fish']")
    private WebElement btnFishImage;
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setUserName(String userName) {
        userNameField.sendKeys(userName);
    }

    public void setPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickButtonLogin() {
        buttonLogIn.click();
    }

    public String woringMessage() {
        String warningText = wrongText.getText();
        return warningText;
    }
    public void clickOnFishImageButton() {
        btnFishImage.click();
    }
}

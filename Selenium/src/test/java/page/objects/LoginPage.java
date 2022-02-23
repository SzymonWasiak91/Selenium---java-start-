package page.objects;

import driverManager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

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


    public LoginPage() {
        PageFactory.initElements(DriverManager.getWebdriver(), this);
    }

    public void setUserName(String userName) {
        WaitForElement.waitUntilElementIsVisible(userNameField);
        userNameField.sendKeys(userName);
    }

    public void setPassword(String password) {
        WaitForElement.waitUntilElementIsVisible(passwordField);
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickButtonLogin() {
        WaitForElement.waitUntilElementIsClickable(buttonLogIn);
        buttonLogIn.click();
    }

    public String woringMessage() {
        WaitForElement.waitUntilElementIsVisible(wrongText);
        String warningText = wrongText.getText();
        return warningText;
    }
    public void clickOnFishImageButton() {
        WaitForElement.waitUntilElementIsClickable(btnFishImage);
        btnFishImage.click();
    }
}

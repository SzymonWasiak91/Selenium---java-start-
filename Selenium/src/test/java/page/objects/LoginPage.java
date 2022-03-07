package page.objects;

import driverManager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    private Logger logger = LogManager.getRootLogger();

    public LoginPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public LoginPage setUserName(String userName) {
        logger.info("Wait for user name filed");
        WaitForElement.waitUntilElementIsVisible(userNameField);
        userNameField.sendKeys(userName);
        logger.info("User field is full " + userName);
        return this;
    }

    public LoginPage setPassword(String password) {
        logger.info("Wait for password filed");
        WaitForElement.waitUntilElementIsVisible(passwordField);
        passwordField.clear();
        passwordField.sendKeys(password);
        logger.info("Password field is full " + password);
        return  this;
    }

    public FooterPage clickButtonLogin() {
        logger.info("After clicking button loggin");
        WaitForElement.waitUntilElementIsClickable(buttonLogIn);
        buttonLogIn.click();
        logger.info("After clicking button loggin");
        return new FooterPage();
    }

    public String woringMessage() {
        logger.info("Waiting for worning message");
        WaitForElement.waitUntilElementIsVisible(wrongText);
        String warningText = wrongText.getText();
        logger.info("Worning message view");
        return warningText;
    }
    public FishListPage clickOnFishImageButton() {
        logger.info("Trying to click finish button");
        WaitForElement.waitUntilElementIsClickable(btnFishImage);
        btnFishImage.click();
        logger.info("Clicked on finish button");
        return new FishListPage();
    }
}

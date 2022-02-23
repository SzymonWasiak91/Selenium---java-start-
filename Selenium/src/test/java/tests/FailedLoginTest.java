package tests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import page.objects.LandingPage;
import page.objects.LoginPage;
import page.objects.TopMenuPage;
import static org.testng.AssertJUnit.assertEquals;

public class FailedLoginTest extends BaseTest {



    @Test
    public void asUserTryToLogInWithIncorrectLoginAndPassword() {
        LandingPage landingPage = new LandingPage();
        landingPage.clickOnEnterStoreLink();

        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage.singInLink();

        LoginPage loginPage = new LoginPage();
        loginPage.setUserName("NotExistingLogin");
        loginPage.setPassword("NotProperPassword");
        loginPage.clickButtonLogin();
        String warningMessage = loginPage.woringMessage();

        assertEquals(warningMessage, "Invalid username or password. Signon failed.");
    }

}

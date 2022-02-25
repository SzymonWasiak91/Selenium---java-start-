package tests;

import driverManager.DriverUtils;
import org.testng.annotations.Test;
import page.objects.LandingPage;
import page.objects.LoginPage;

import static navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.AssertJUnit.assertEquals;

public class FailedLoginTest extends BaseTest {



    @Test
    public void asUserTryToLogInWithIncorrectLoginAndPassword() {
        DriverUtils.navigateToPage(LOGIN_URL);
        LandingPage landingPage = new LandingPage();
        landingPage.clickOnEnterStoreLink()
                    .singInLink()
                    .setUserName("NotExistingLogin")
                    .setPassword("NotProperPassword")
                    .clickButtonLogin();
        LoginPage loginPage = new LoginPage();
        String warningMessage = loginPage.woringMessage();
        assertEquals(warningMessage, "Invalid username or password. Signon failed.");
    }

}

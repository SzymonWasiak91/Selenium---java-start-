package tests;

import org.testng.annotations.Test;
import page.objects.LandingPage;
import page.objects.LoginPage;

import static org.testng.AssertJUnit.assertEquals;

public class FailedLoginTest extends BaseTest {



    @Test
    public void asUserTryToLogInWithIncorrectLoginAndPassword() {
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

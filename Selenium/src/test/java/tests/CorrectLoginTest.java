package tests;
import driverManager.DriverUtils;
import org.testng.annotations.Test;
import page.objects.FooterPage;
import page.objects.LandingPage;

import static navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.AssertJUnit.assertTrue;

public class CorrectLoginTest extends BaseTest {

    @Test
    public void asUserLoginUsingValidLoginAndPassword() {
        DriverUtils.navigateToPage(LOGIN_URL);
        LandingPage landingPage = new LandingPage();
        FooterPage footerPage = new FooterPage();
        landingPage
                .clickOnEnterStoreLink()
                .singInLink()
                .setUserName("j2ee")
                .setPassword("j2ee")
                .clickButtonLogin();
        assertTrue(footerPage.isBannerIsDisplayed());
    }

}

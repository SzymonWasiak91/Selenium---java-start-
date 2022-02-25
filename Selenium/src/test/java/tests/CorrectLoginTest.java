package tests;
import org.testng.annotations.Test;
import page.objects.FooterPage;
import page.objects.LandingPage;
import static org.testng.AssertJUnit.assertTrue;

public class CorrectLoginTest extends BaseTest {

    @Test
    public void asUserLoginUsingValidLoginAndPassword() {
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

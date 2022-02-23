package tests;
import org.testng.annotations.Test;
import page.objects.FooterPage;
import page.objects.LandingPage;
import page.objects.LoginPage;
import page.objects.TopMenuPage;
import static org.testng.AssertJUnit.assertTrue;

public class CorrectLoginTest extends BaseTest {


    @Test
    public void asUserLoginUsingValidLoginAndPassword(){
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnEnterStoreLink();

        TopMenuPage topMenuPage = new TopMenuPage(driver);
        topMenuPage.singInLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("j2ee");
        loginPage.setPassword("j2ee");
        loginPage.clickButtonLogin();

        FooterPage footerPage = new FooterPage(driver);
        assertTrue(footerPage.isBannerIsDisplayed());
    }

}

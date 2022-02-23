package tests;

import org.testng.annotations.Test;
import page.objects.*;

import static org.testng.AssertJUnit.assertEquals;

public class E2eTest extends BaseTest{


    @Test
    public void gotToTheCardE2eTest(){
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnEnterStoreLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnFishImageButton();

        FishListPage fishListPage = new FishListPage(driver);
        fishListPage.clickOnAngelfishId();

        AngelFishListPage angelfishListPage = new AngelFishListPage(driver);
        angelfishListPage.clickOnAddToCartSmallAngelfish();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.clickOnProceedToCheckout();

        loginPage = new LoginPage(driver);
        String warningMessage = loginPage.woringMessage();
        assertEquals(warningMessage, "You must sign on before attempting to check out. Please sign on and try checking out again.");

    }

}

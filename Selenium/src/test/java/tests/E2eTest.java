package tests;

import org.testng.annotations.Test;
import page.objects.*;

import static org.testng.AssertJUnit.assertEquals;

public class E2eTest extends BaseTest{


    @Test
    public void gotToTheCardE2eTest(){
        LandingPage landingPage = new LandingPage();
        landingPage.clickOnEnterStoreLink();

        LoginPage loginPage = new LoginPage();
        loginPage.clickOnFishImageButton();

        FishListPage fishListPage = new FishListPage();
        fishListPage.clickOnAngelfishId();

        AngelFishListPage angelfishListPage = new AngelFishListPage();
        angelfishListPage.clickOnAddToCartSmallAngelfish();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.clickOnProceedToCheckout();

        loginPage = new LoginPage();
        String warningMessage = loginPage.woringMessage();
        assertEquals(warningMessage, "You must sign on before attempting to check out. Please sign on and try checking out again.");

    }

}

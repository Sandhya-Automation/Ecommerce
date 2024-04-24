package tests;

import Base.BaseTest;
import Listeners.RetryListener;
import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.HomePage;
import Pages.LandingPage;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class ErrorValidations extends BaseTest {
    HomePage homepge;
//    @Test(groups={"ErrorHandling"}) //, retryAnalyzer = RetryListener.class
//    public void LoginErrorValidation()
//    {
//        landPage.login("sandhya.vanga@gmail.com","Queen@12");
//        Assert.assertEquals("Incorrect email or password.",landPage.getErrorMessage());
//
//    }
    @Test
    public void ProductErrorValidation() throws InterruptedException {
        String productName="ZARA COAT 33";
        landPage.login("sandhya.vanga@gmail.com","Queen@1234");
      //  List<WebElement> products=homepge.getProductList();
//        homepge.getProductByName(productName);
//        homepge.addToCart(productName);
//        Thread.sleep(3000);
//        CartPage cartpage=homepge.gotoCart();
//        Thread.sleep(3000);
//        Boolean match=cartpage.searchForProductInCart(productName);
//        Assert.assertTrue(match);

    }

}

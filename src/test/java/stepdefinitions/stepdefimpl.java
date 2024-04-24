package stepdefinitions;

import Base.BaseTest;
import Pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class stepdefimpl extends BaseTest {
    public LandingPage landingpage;
    public HomePage homepge;
    public CartPage cartpage;
    public OrdersPage orderpage;
    @Given("I landed on the ecommerce page")
    public void I_landed_on_the_ecommerce_page() throws IOException {
        landingpage=LaunchApplication();
    }
    @Given("^Logged in with username (.+) and password (.+)$")
    public void Logged_in_with_username_and_password(String user, String pass){
        homepge=landPage.login(user,pass);
    }
    @When("^search for the product (.+) from the list and add to cart$")
    public void search_for_the_product_from_the_list_and_add_to_cart(String productName) throws InterruptedException {
        homepge.getProductByName(productName);
        homepge.addToCart(productName);
        Thread.sleep(3000);
    }
    @When("^checkout (.+) and submit the order$")
    public void checkout_and_submit_the_order(String productName) throws InterruptedException {
        cartpage=homepge.gotoCart();
        Thread.sleep(3000);
        cartpage.searchForProductInCart(productName);
        CheckoutPage checkout=cartpage.goToCheckout();
        Thread.sleep(3000);
        checkout.enterShippingDetails();
        orderpage=checkout.goToOrders();
        Thread.sleep(3000);
    }
    @Then("Verify the item in orders and orderid")
    public void Verify_the_item_in_orders_and_orderid(){
        orderpage.getOrderId();
        tearDown();
    }



}

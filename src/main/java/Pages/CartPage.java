package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {


    WebDriver driver;
    By checkoutbtn=By.xpath("//button[contains(text(),'Checkout')]");
    public CartPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }
    public Boolean searchForProductInCart(String productName){
        List<WebElement> cartproducts=driver.findElements(By.cssSelector(".cartSection h3"));
        Boolean match=cartproducts.stream().anyMatch(s->s.getText().equalsIgnoreCase(productName));
        return match;
    }
    public CheckoutPage goToCheckout(){
        driver.findElement(checkoutbtn).click();
        CheckoutPage checkout=new CheckoutPage(driver);
        return checkout;
    }

}

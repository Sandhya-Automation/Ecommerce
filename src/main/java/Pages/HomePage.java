package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class HomePage extends BasePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);

        this.driver = driver;

    }

    By itemnames = By.xpath("//*[@class='card-body']");
    By lbladdedcard = By.cssSelector(".toast-bottom-right");
    By addtocart=By.cssSelector(".btn.w-10");
    By spinner=By.cssSelector(".ng-animating");
    By carticon=By.xpath("//*[@routerlink='/dashboard/cart']");
    public List<WebElement> getProductList() {
        List<WebElement> itemslist = driver.findElements(itemnames);
        return itemslist;
    }

    public WebElement getProductByName(String nameofproduct) {
        WebElement prodname = getProductList().stream().filter(s -> s.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(nameofproduct)).findFirst().orElse(null);
        String prodnametext = prodname.findElement(By.cssSelector("b")).getText();
        System.out.println("the product name in homepage is:" + prodnametext);
        return prodname;
    }
public void addToCart(String productName){
    getProductByName(productName).findElement(By.cssSelector(".btn.w-10")).click();
    waitForElementToAppear(lbladdedcard);
   // waitForElementToDisppear(driver.findElement(spinner));

}
public CartPage gotoCart(){
    driver.findElement(carticon).click();
    CartPage cartpage=new CartPage(driver);
    return cartpage;
}







}


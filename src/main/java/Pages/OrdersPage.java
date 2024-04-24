package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class OrdersPage extends BasePage {


    WebDriver driver;
    By orderid=By.cssSelector(".em-spacer-1 .ng-star-inserted");
    public OrdersPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }

    public void getOrderId(){

        String orderId=driver.findElement(orderid).getText();
        System.out.println("The order id is:"+orderId);
    }
}

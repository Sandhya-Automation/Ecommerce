package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class CheckoutPage extends BasePage {


    WebDriver driver;
    By nameoncard=By.xpath("//div[contains(text(),'Name on Card')]/following-sibling::input");
    By entercountry=By.xpath("//div[@class='form-group']/input");
    By selectcountry=By.xpath("//button[contains(@class,'ta-item')][1]");
    By submit=By.cssSelector(".action__submit");
    public CheckoutPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }
    public void enterShippingDetails()
    {
        driver.findElement(nameoncard).sendKeys("Sandhya Vanga");
        Actions a=new Actions(driver);
        a.sendKeys(driver.findElement(entercountry),"United Kingdom").build().perform();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ta-results")));
        driver.findElement(selectcountry).click();


    }
    public OrdersPage goToOrders(){
        driver.findElement(submit).click();
        OrdersPage orderpage=new OrdersPage(driver);
        return orderpage;
    }
}

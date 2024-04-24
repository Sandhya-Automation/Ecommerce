package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePage {
    WebDriver driver;
    public LandingPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }
    By email= By.id("userEmail");
    By passwrd=By.id("userPassword");
    By submit=By.xpath("//input[@name='login']");
    By errormessage=By.cssSelector("[class*='flyInOut'");


    public HomePage login(String username, String passw)
    {
        driver.findElement(email).sendKeys(username);
        driver.findElement(passwrd).sendKeys(passw);
        driver.findElement(submit).click();
        HomePage homepge=new HomePage(driver);
        return homepge;
    }
    public void gotoPage(){
        driver.get("https://rahulshettyacademy.com/client");
    }
    public String getErrorMessage(){
        waitForElementToAppear(errormessage);
        System.out.println(driver.findElement(errormessage).getText());
        //div[aria-label='Incorrect email or password.']
        return driver.findElement(errormessage).getText();
    }

}

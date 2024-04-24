package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver=driver;
        wait= new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    public void waitForElementToAppear(By findby)
    {


        wait.until(ExpectedConditions.visibilityOfElementLocated(findby));


    }
    public void waitForElementToDisppear(WebElement backimg)
    {


        wait.until(ExpectedConditions.invisibilityOf(backimg));


    }
}

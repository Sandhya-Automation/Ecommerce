package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.annotations.*;

public class LoginTests {

    @Test
    public void maintest(){
        System.out.println("in main test method");
    }
    @BeforeTest
    public String beforetest(){
        System.out.println("in before method");
        String var="kmlk";
        return var;
    }
    @AfterTest
    public void aftertest(){
        System.out.println("in after method");
    }





}

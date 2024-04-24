package tests;


import Base.BaseTest;
import Pages.*;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.*;
import Listeners.RetryListener;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class sampleflowtests extends BaseTest{
    @Test(dataProvider = "getData", groups = {"Smoke"},retryAnalyzer= RetryListener.class)
    public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException {
       // String productName="Iphone 13 Pro";


       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
   //     driver.get("https://rahulshettyacademy.com/client");
       //LandingPage landPage=LaunchApplication();
        String productName=input.get("product");
        HomePage homepge=landPage.login(input.get("email"),input.get("password"));
        Assert.assertEquals("Login Successfully", landPage.getErrorMessage());
       // HomePage homepge=new HomePage(driver);
        homepge.getProductByName(productName);
        homepge.addToCart(productName);
        Thread.sleep(3000);
        CartPage cartpage=homepge.gotoCart();

        Thread.sleep(3000);


        Boolean match=cartpage.searchForProductInCart(productName);
        Assert.assertTrue(match);
        CheckoutPage checkout=cartpage.goToCheckout();
        Thread.sleep(3000);

        checkout.enterShippingDetails();
        OrdersPage orderpage=checkout.goToOrders();
        orderpage.getOrderId();







//        for(int i=0;i<itemsnames.size();i++)
//        {
//            String nameofitem=itemsnames.get(i).getText();
//            if(nameofitem.equalsIgnoreCase("Iphone 13 pro"))
//            {
//                System.out.println("we found the correct item");
//                driver.findElements(By.cssSelector(".btn.w-10")).get(i).click();
//                Thread.sleep(4000);
//                String floatmessage=driver.findElement(By.cssSelector(".toast-bottom-right")).getText();
//                System.out.println(floatmessage);
//                String correctmessage="Product added to cart";
//                Assert.assertEquals(floatmessage, correctmessage);
//
//            }
//        }


    }
    @DataProvider
   public Object[][] getData() throws IOException {
//        HashMap<String,String> map=new HashMap<String,String>();
//        map.put("email","sandhyavg@gmail.com");
//        map.put("password","Queen@1234");
//        map.put("product","ADIDAS ORIGINAL");
//
//
//    HashMap<String,String> map1=new HashMap<String,String>();
//        map1.put("email","anshika@gmail.com");
//        map1.put("password","Iamking@000");
//        map1.put("product","Iphone 13 Pro");
        List<HashMap<String,String>> data=getJsondatatoHashMap(System.getProperty("user.dir")+"//src//test//testdata//user-logins.json");

        return new Object[][] {{data.get(0)},{data.get(1)}};

  }
//   public String getScreenshot(String testcseName) throws IOException {
//       TakesScreenshot ts=(TakesScreenshot) driver;
//       File source=ts.getScreenshotAs(OutputType.FILE);
//       File destination=new File(System.getProperty("user.dir")+"//target//reports//"+testcseName+".png");
//       FileUtils.copyFile(source,destination);
//       String path=System.getProperty("user.dir")+"//target//reports//"+testcseName+".png";
//       return path;
//
//
//   }
//    @DataProvider
//    public Object[][] getData(){
//        System.out.println("we are in getdata method");
//        return new Object[][] {{"sandhyavg@gmail.com","Queen@1234","ADIDAS ORIGINAL"},{"anshika@gmail.com","Iamking@000","Iphone 13 Pro" }};
//    }




}

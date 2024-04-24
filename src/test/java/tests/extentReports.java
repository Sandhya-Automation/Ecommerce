package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class extentReports {
    ExtentReports extent;
    @BeforeTest
    public void reportConfig(){
        String path=System.getProperty("user.dir")+"//target/reports//index.html";
        ExtentSparkReporter reporter=new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Result");
        reporter.config().setDocumentTitle("Test Results");
        extent=new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Sandhya");



    }
    @Test
    public void InitialDemo() throws IOException {
        ExtentTest test=extent.createTest("Initial Demo");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        System.out.println(driver.getTitle());
       // test.addScreenCaptureFromBase64String("test report");
        test.fail("Results do not match");
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File destination = new File(System.getProperty("user.dir") + "//target//reports//" + "screenshot1.png");
        FileUtils.copyFile(source, destination);
        String path = System.getProperty("user.dir") + "//target//reports//" + "screenshot1.png";
        test.addScreenCaptureFromPath(path,"Failed Screenshot");
        extent.flush();
        driver.close();



    }
}

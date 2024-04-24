package Listeners;

import Base.BaseTest;
import Utilities.ReportScreenshots;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import resources.extentReportsNG;

import java.io.IOException;

public class TestListener extends BaseTest implements ITestListener {


  //
    //  ExtentReports extent=extentReportsNG.reportConfig();
ExtentReports extent=extentReportsNG.reportConfig();


@Override
public void onTestStart(ITestResult result){
test=extent.createTest(result.getMethod().getMethodName());

}
@Override
public void onTestSuccess(ITestResult result){
    test.log(Status.PASS,"Test Passed");

}
@Override
public void onTestFailure(ITestResult result){
    test.fail(result.getThrowable());

    try{
        driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
    } catch (Exception e) {
        e.printStackTrace();
    }
    //screenshot
    ReportScreenshots reportscreen=new ReportScreenshots();
    String path= null;
    try {
        path = reportscreen.getScreenshot(result.getMethod().getMethodName(),driver);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    test.addScreenCaptureFromPath(path,result.getName());
}
@Override
public void onFinish(ITestContext context){
    extent.flush();
}





}

package Utilities;

import Base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ReportScreenshots extends BaseTest {
    public String getScreenshot(String testcseName, WebDriver driver) throws IOException {

        System.out.println("in screenshot method");
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File destination = new File(System.getProperty("user.dir") + "//target//reports//" + testcseName + ".png");
        FileUtils.copyFile(source, destination);
        String path = System.getProperty("user.dir") + "//target//reports//" + testcseName + ".png";
        return path;

    }
}

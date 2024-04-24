package Base;

import Pages.LandingPage;
import com.aventstack.extentreports.ExtentTest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import org.testng.annotations.*;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public abstract class BaseTest {
    public WebDriver driver;
    public LandingPage landPage;
    public ExtentTest test;

    public WebDriver InitializeDriver() throws IOException {
        Properties prop = new Properties();
        FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//resources//GlobalData.properties");
        prop.load(fs);
        //System.getProperty("browser") is the browser property coming from terminal

        String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") :  prop.getProperty("browser");
        if (browserName.contains("Chrome")) {
            ChromeOptions options=new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            if(browserName.contains("headless")){
                options.addArguments("--headless");
            }
           // options.addArguments("--start-fullscreen");
           // options.addArguments("--window-size=1440x900");
            driver = new ChromeDriver(options);
            driver.manage().window().setSize(new Dimension(1440,900));




        } else if (browserName.equalsIgnoreCase("Firefox")) {
            WebDriverManager.chromedriver().setup();
            driver = new FirefoxDriver();

        } else if (browserName.equalsIgnoreCase("Safari")) {
            WebDriverManager.chromedriver().setup();
            driver = new SafariDriver();

        }
        driver.manage().window().maximize();
        return driver;
    }


    @BeforeMethod(alwaysRun = true)
    public LandingPage LaunchApplication() throws IOException {
        driver = InitializeDriver();
        if(driver!=null) {
            landPage = new LandingPage(driver);
            landPage.gotoPage();
            System.out.println("in before method");
            return landPage;
        }
        return null;

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        System.out.println("in teardown method");
        System.out.println("close driver");
        if(driver!=null) {
            driver.close();
        }
    }

    public List<HashMap<String, String>> getJsondatatoHashMap(String filePath) throws IOException {

        //read json to string
        String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
        //string to hashmap using jackson databind dependency
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
        });
        return data;
        //data is nothing but a hashmap of two list {map,map1}

    }
//    public String getScreenshot(String testcseName, WebDriver driver) throws IOException {
//
//        TakesScreenshot ts = (TakesScreenshot) this.driver;
//        File source = ts.getScreenshotAs(OutputType.FILE);
//        File destination = new File(System.getProperty("user.dir") + "//target//reports//" + testcseName + ".png");
//        FileUtils.copyFile(source, destination);
//        String path = System.getProperty("user.dir") + "//target//reports//" + testcseName + ".png";
//        return path;
//
//    }


}



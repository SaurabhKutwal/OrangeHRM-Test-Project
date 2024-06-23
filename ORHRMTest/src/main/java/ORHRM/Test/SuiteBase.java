package ORHRM.Test;

import ORHRM.Test.pages.UtilityPages.PageFunctions;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class SuiteBase {

    public static WebDriver driver;
    public static Properties param;
    public static WebDriverWait wait;
    public static ExtentReports extent;

    @BeforeSuite
    public void init() throws IOException {

        //load Properties file;
        param = new Properties();
        FileInputStream src = new FileInputStream(System.getProperty("user.dir") + "//properties//test.properties");
        param.load(src);

        //Browser Initialization
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        wait = new WebDriverWait(driver,Duration.ofSeconds(5));

        //Report Initialization
        reportInit();
    }

    //@BeforeSuite
    public void reportInit(){
        String timeDate = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss").format(new Date());
        String reportPath = System.getProperty("user.dir") + "//reports//extentngreport-"+timeDate+".html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
        reporter.config().setReportName("Orange HRM Testing");
        reporter.config().setDocumentTitle("Test Report (Orange HRM Testing)");

        extent = new ExtentReports();
        extent.attachReporter(reporter);

    }

    public void launchBrowser(){
        driver.get(param.getProperty("siteURL"));
    }

    @AfterSuite
    public void closeBrowser(){
        driver.quit();
    }
}

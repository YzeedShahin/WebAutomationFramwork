package base;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.ConfigReader;
import utils.DriverManager;
import utils.ExtentReport;
import utils.TestDataReader;

import java.io.IOException;


public class BaseTest {

    public ConfigReader configReader = new ConfigReader();
    public TestDataReader testData = new TestDataReader();
    public WebDriver driver;

    public static ExtentReport report;
    public static ExtentTest test;

    @BeforeSuite
    public void beforeSuite() throws IOException {
        report = new ExtentReport(test);
        report.initReport();
    }


    @BeforeMethod
    public void setup(ITestResult result) {
        driver = DriverManager.initDriver();
        test = report.createTest(result.getMethod().getMethodName());
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        report.logTestResults(result);
        DriverManager.quitDriver();
    }

    @AfterSuite
    public void afterSuite() {
        report.closeReport();
    }

    public void visit(String url) {
        driver.get(url);
    }

    public String getData(String key) {
        return testData.getValue(key);
    }
}

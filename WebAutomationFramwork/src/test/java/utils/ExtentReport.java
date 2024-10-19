package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class ExtentReport {
    public static ExtentReports extent;
    public static ExtentTest test;

    public ExtentReport(ExtentTest test){
        ExtentReport.test = test;
    }

    public void initReport() throws IOException {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                + File.separator + "resources" + File.separator + "reportConfigs.json";
        final File CONF = new File(path);
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator + "test-output" + File.separator + "automation_report.html");
        htmlReporter.loadJSONConfig(CONF);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    public void logTestResults(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test case failed: " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test case passed");
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test case skipped");
        }
    }
    public void closeReport(){
        extent.flush();
    }

    public ExtentTest createTest(String testName){
        return test = extent.createTest(testName);
    }
}

package ORHRM.Testcomponents;

import ORHRM.Test.SuiteBase;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.*;

import java.util.Arrays;

public class ListenersTest extends SuiteBase implements ITestListener {

    ExtentTest test;
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("OnTestStart triggered" + result.getInstanceName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS,"Test Case Passed: "+ result.getName() + " " + Arrays.toString(result.getParameters()));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL,"Test Case failed: " + result.getInstanceName() + " " + Arrays.toString(result.getParameters())
                + "\n" + result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP,"Test Case skipped:");

    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("OnStart Triggered" + context.getName());
        test = extent.createTest(context.getName());
    }

    public void onFinish(ITestContext context) {
        System.out.println("OnFinish Triggered");
        extent.flush();
    }
}

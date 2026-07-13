package listeners;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;
import base.BaseClass;
import reports.ExtentManager;
import utilties.ScreenshotUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
public class TestListener implements ITestListener {
	
	ExtentReports extent = ExtentManager.getReport();
	ExtentTest test;
	@Override
    public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName());
        System.out.println(result.getName() + " Started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    	test.pass("Test Passed");
        System.out.println(result.getName() + " Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	test.fail(result.getThrowable());
       Object currentClass = result.getInstance();
       BaseClass base = (BaseClass) currentClass;
       ScreenshotUtil.capture(base.getDriver(), result.getName());
           System.out.println(result.getName() + " Failed");
    }
    @Override
    public void onFinish(ITestContext context) {   //This Create the Html Report
      extent.flush();
}
    }

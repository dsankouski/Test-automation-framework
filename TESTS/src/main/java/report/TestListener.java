package report;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import test.BaseTest;


/**
 * Created by Dzmitry_Sankouski
 */
public class TestListener extends BaseTest implements ITestListener {

    private static String getTestName(ITestResult iTestResult) {
        System.out.println(iTestResult.getTestClass().getRealClass().getName());
        return iTestResult.getTestClass().getRealClass().getName();
    }

    //Before starting all tests, below method runs.
    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("I am in onStart method " + iTestContext.getName());
//        iTestContext.setAttribute("WebDriver", this.driver);
    }

    //After ending all tests, below method runs.
    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("I am in onFinish method " + iTestContext.getName());
        //Do tier down operations for extentreports reporting!
        ExtentTestManager.endTest();
        ExtentManager.getReporter().flush();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("I am in onTestStart method " +  getTestName(iTestResult) + " start");
        //Start operation for extentreports.
        ExtentTestManager.startTest(iTestResult.getTestClass().getRealClass().getName(),"");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("I am in onTestSuccess method " +  getTestName(iTestResult) + " succeed");
        //Extentreports log operation for passed tests.
        ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("I am in onTestFailure method " +  getTestName(iTestResult) + " failed");

        //Get driver from test.BaseTest and assign to local webdriver variable.
        Object testClass = iTestResult.getInstance();
//        WebDriver webDriver = ((test.BaseTest) testClass).getDriver();
//
//        //Take base64Screenshot screenshot.
//        String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)webDriver).
//                getScreenshotAs(OutputType.BASE64);
//
//        //Extentreports log and screenshot operations for failed tests.

        report.ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed. Reason:\n"
                + iTestResult.getThrowable().getMessage());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("I am in onTestSkipped method "+  getTestName(iTestResult) + " skipped");
        //Extentreports log operation for skipped tests.
        ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Test failed but it is in defined success ratio " + getTestName(iTestResult));
    }

}

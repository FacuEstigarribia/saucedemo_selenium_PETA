package base;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.core.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.util.logging.Level;

public class Listener implements ITestListener{
    private static final Log LOG = LogFactory.getLog(Listener.class);

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        LOG.info("Success of test cases and its details are : "+iTestResult.getName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        LOG.info("Failure of test cases and its details are : "+iTestResult.getName());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        LOG.info("Skip of test cases and its details are : "+ iTestResult.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        LOG.info("Failure of test cases and its details are : "+iTestResult.getName());
    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}

package classwork.day24;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyTestNGListener implements ITestListener {

    private static final Logger LOGGER = LogManager.getLogger(MyTestNGListener.class);

    String runId = "1579";

    public void onTestStart(ITestResult result) {
        LOGGER.info("Test started: " + result.getMethod().getDescription());
    }

    public void onTestSuccess(ITestResult result) {
        LOGGER.info("Test onTestSuccess: " + result.getMethod().getDescription());
        TestRailReporterUtil.reportResult(runId, result.getMethod().getDescription(), new Result(1));
    }

    public void onTestFailure(ITestResult result) {
        LOGGER.info("Test onTestFailure: " + result.getMethod().getDescription());
        TestRailReporterUtil.reportResult(runId, result.getMethod().getDescription(), new Result(5));

    }
}

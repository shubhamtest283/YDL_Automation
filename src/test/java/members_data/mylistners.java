package members_data;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class mylistners implements ITestListener {
	public ExtentSparkReporter SparkReporter;
	public ExtentReports extent;
	public ExtentTest test;

	public void onStart(ITestContext context) {
		SparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/myreports.html");
		SparkReporter.config().setDocumentTitle("Automation Report");
		SparkReporter.config().setReportName("Regression Testing");
		SparkReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(SparkReporter);

		extent.setSystemInfo("Computer Name", "Acer Localhost");
		extent.setSystemInfo("Envoirnment", "QA");
		extent.setSystemInfo("Tester Name", "Shubham");
		extent.setSystemInfo("OS", "Windows ");
		extent.setSystemInfo("Browser Name", "Chrome");
	}

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.INFO, "Test Started");
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test case passed is: " + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Tset case failed is: " + result.getName());
		test.log(Status.FAIL, "Test case failed cause is: " + result.getThrowable());
		Object currentclass = result.getInstance();
		membersdata2 obj = (membersdata2) currentclass;
		try {
			String path = obj.capturescreenshot(result.getName());
			test.fail("screenshot attached", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Test case skipped is: " + result.getName());
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}
}

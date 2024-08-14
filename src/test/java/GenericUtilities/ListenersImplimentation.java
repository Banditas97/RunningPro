package GenericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplimentation implements ITestListener
	{
	ExtentReports report; // making it as global variable to use it multiple places
	ExtentTest test;     // making it as global variable to use it multiple places

	@Override
	public void onTestStart(ITestResult result) 
	{
		//For every @Test -> Test method
		String MethodName = result.getMethod().getMethodName();	
		System.out.println(MethodName+"--Test Execution started--");
		
		//@Test execution started.
		test = report.createTest(MethodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		//For @Test is passed
		String MethodName = result.getMethod().getMethodName();	
		System.out.println(MethodName+"--Test Passed--");
		
		test.log(Status.PASS, MethodName+"---Test Passed--");
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		//For @Test is failed
		String MethodName = result.getMethod().getMethodName();	
		System.out.println(MethodName+"--Test Failed--");
		System.out.println(result.getThrowable());
		
		test.log(Status.FAIL, MethodName+"---Test Failed--");
		test.log(Status.INFO,result.getThrowable());
		
		WebDriverUtility wUtil = new WebDriverUtility();
		JavaUtility jUtil = new JavaUtility();
		
		String screenshotName = MethodName+jUtil.currentDateAndTime();
		
		try {
			String path = wUtil.captureScreenshot(BaseClass.sdriver, screenshotName); // (extent report can't understand "." so we have to create a variable and use that)
			test.addScreenCaptureFromPath(path);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		//For @Test is Skipped
		String MethodName = result.getMethod().getMethodName();	
		System.out.println(MethodName+"--Test Skipped--");
		
		test.log(Status.SKIP, MethodName+"---Test Skipped--");
		test.log(Status.INFO,result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) 
	{

	}

	@Override
	public void onStart(ITestContext context) 
	{
		System.out.println("--Suite execution started--");
		
		// Extent report configuration.
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(".\\ExtentReports\\Report-" + new JavaUtility().currentDateAndTime()+".html");
		htmlReport.config().setDocumentTitle("Execution Report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("Mvn project Report");
		
		report = new ExtentReports();
		report.attachReporter(htmlReport); // mandatory step
		//Adding the info/System info(what has to be in your report)
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base Env", "TestNG");
		report.setSystemInfo("Base URL", "http://localhost:8888");
		report.setSystemInfo("Reporter Name", "Bandita");	
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		System.out.println("--Suite execution finished--");
		
		//Generate the report
		report.flush();
	}
	}
  
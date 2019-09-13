package jenkinTestpractise;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListners implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("TestCases Start and detatils are " +result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("TestCases Success and detatils are " +result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("TestCases Failed and detatils are " +result.getName());
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("TestCases Skipped and detatils are " +result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onStart(ITestContext result) {
		System.out.println("TestCases Start and detatils are " +result.getName());
		
	}

	public void onFinish(ITestContext result) {
		// 
		System.out.println("TestCases Faield and detatils are " +result.getName());
	}

}
	

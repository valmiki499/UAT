package jenkinTestpractise;


import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.nehacreation.helper.Excelcode;
import com.nehacreation.helper.commonfunction;
import com.nehacreation.pages.Brandpage;
import com.nehacreation.pages.OrderConfirmation;
import com.nehacreation.pages.loginpage;

//@Listeners(jenkinTestpractise.TestNGListners.class)
public class NewTest  extends commonfunction{
	
		
	
	@Parameters({ "browser", "Url" })
	@BeforeTest
	public void beforeTest(String browser, String Url) {

		// WebDriverManager.chromedriver().setup();
		
		logger=report.createTest("Browser Launch");
		System.out.println("this is" + logger);
		logger.info("Starting Application");
		browserexecution(browser,Url);
		
		
	}
	
	
	
	
	@Test
	public void f() throws Exception {

		// driver.get("http://demo.guru99.com/test/guru99home/");
		Excelcode.configexcel(Excelcode.excelpath, "Sheet1");
				
		loginpage objlogin=PageFactory.initElements(driver,loginpage.class );
		logger=report.createTest("Login to Neha creation");
		objlogin.loginprocess(Excelcode.Getexceldata(1, 0), Excelcode.Getexceldata(1, 1));
		
		Brandpage objbrandpage=PageFactory.initElements(driver,Brandpage.class );
		logger=report.createTest("Search for brand");
		objbrandpage.Searchproduct(driver);
		
		
		OrderConfirmation objOrderConfirmation=PageFactory.initElements(driver,OrderConfirmation.class );
		logger=report.createTest("Update Delivery Address");
		objOrderConfirmation.OrderConfirmationdetails();
		
		
				
		Thread.sleep(5000);
		
		
		
	}

	

	@AfterTest // we can also use @AfterMethod
	public void setupclosed() {
		driver.close();
	}

	@AfterMethod
	public void afterTest(ITestResult result) throws IOException {

		if (ITestResult.FAILURE == result.getStatus()) 
		{
			
			System.out.println("Inside takescreenshot method");
			commonfunction.failed(driver);
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(commonfunction.failed(driver)).build());
			
		}
		report.flush();

	}

}

package jenkinTestpractise;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


//@Listeners(jenkinTestpractise.TestNGListners.class)
public class NewTest {
	WebDriver driver;
	
@Parameters("Url")
  @Test
  public void f(String Url) throws Exception {
	  
	  
	  //driver.get("http://demo.guru99.com/test/guru99home/");
	  driver.get(Url);
//	  String title = driver.getTitle();
//	  Assert.assertTrue(title.contains("Google"));
//	  Excelcode.configexcel(Excelcode.excelpath, "Sheet1");
//	  String val= Excelcode.Getexceldata(1, 0);
//	  System.out.println(val);
//	  driver.findElement(By.xpath("//input[@name='q']")).sendKeys(val);
	  
	  
  }
  @BeforeTest
  public void beforeTest() {
	  
	  //WebDriverManager.chromedriver().setup();
	 System.setProperty("webdriver.chrome.driver", "D:\\valmiki\\chromedriver.exe");
	 ChromeOptions opt= new ChromeOptions();
	 opt.addArguments("--disable-notification");
	  driver= new ChromeDriver(opt);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
  }
  

  @AfterMethod
  public void afterTest(ITestResult result) throws IOException {
	  
	  if(ITestResult.FAILURE==result.getStatus())
	  {
		  TakesScreenshot ts=((TakesScreenshot)driver);
		  File source=ts.getScreenshotAs(OutputType.FILE);
		  File des= new File("D:\\valmiki\\Selenium program New\\jenkinTest\\screenshot\\test3.png");
		  FileUtils.copyFile(source, des);
	  }
	  driver.quit();	
  }

}

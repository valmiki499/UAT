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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//@Listeners(jenkinTestpractise.TestNGListners.class)
public class NewTest {
	WebDriver driver;

	@Test
	public void f() throws Exception {

		// driver.get("http://demo.guru99.com/test/guru99home/");
		Excelcode.configexcel(Excelcode.excelpath, "Sheet1");
		String Username = Excelcode.Getexceldata(1, 0);
		String password = Excelcode.Getexceldata(1, 1);
		driver.findElement(By.id("Email")).sendKeys(Username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("sub-mit")).click();
		Thread.sleep(5000);
		// String title = driver.getTitle();
		// Assert.assertTrue(title.contains("Google"));
		// Excelcode.configexcel(Excelcode.excelpath, "Sheet1");
		// String val= Excelcode.Getexceldata(1, 0);
		// System.out.println(val);
		// driver.findElement(By.xpath("//input[@name='q']")).sendKeys(val);

	}

	@Parameters({ "browser", "Url" })
	@BeforeTest
	public void beforeTest(String browser, String Url) {

		// WebDriverManager.chromedriver().setup();

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\valmiki\\chromedriver.exe");
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--disable-notification");
			driver = new ChromeDriver(opt);

		} else if (browser.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver", "D:\\valmiki\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Url);
	}

	@AfterTest // we can also use @AfterMethod
	public void setupclosed() {
		driver.quit();
	}

	@AfterMethod
	public void afterTest(ITestResult result) throws IOException {

		if (ITestResult.FAILURE == result.getStatus()) {
			System.out.println("Inside takescreenshot method");
			TakesScreenshot ts = ((TakesScreenshot) driver);
			File source = ts.getScreenshotAs(OutputType.FILE);
			File des = new File("D:\\valmiki\\Selenium program New\\jenkinTest\\screenshot\\test3.png");
			FileUtils.copyFile(source, des);
			driver.quit();
		}

	}

}

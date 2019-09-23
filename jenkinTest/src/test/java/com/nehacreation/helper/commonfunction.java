package com.nehacreation.helper;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class commonfunction {
	
	public static WebDriver driver;
	public ExtentReports report; 
	public ExtentTest logger;
	
	public commonfunction()
	{
		
		Reporter.log("Setting up reports and Test is getting ready",true);
		ExtentHtmlReporter extents= new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Report/+"+getCurrentdateandTime()+".html"));
		report= new ExtentReports();
		report.attachReporter(extents);
		Reporter.log("Setting done - Test can be start",true);
	}
	
	
	
	public static void browserexecution(String browser,String Url)
	{
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
	
	public static void Action(WebDriver driver,WebElement element)
	{
		Actions act= new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public static String failed(WebDriver driver)
	{
		TakesScreenshot ts=((TakesScreenshot)driver);
		String Screenshotpath=System.getProperty("user.dir") +"/TSFailErrorscreenshot/"+ getCurrentdateandTime() +".png";
		try {
			File source= ts.getScreenshotAs(OutputType.FILE);
			File des= new File(Screenshotpath);
			FileUtils.copyFile(source, des);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return Screenshotpath;
	}
	
	
	
	public static String getCurrentdateandTime()
	{
		DateFormat customformat= new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentdate= new Date();
		return  customformat.format(currentdate);
		
	}

}

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login {
	
	WebDriver driver;
  @Test
  public void f() throws Exception {
	  
	  driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/div[2]/div/div[2]/a/span")).click();
	  driver.findElement(By.id("email")).sendKeys("krishnavalmiki007@gmail.com");
	  driver.findElement(By.id("pass")).sendKeys("zzkeppeltd"); 
	  driver.findElement(By.name("login")).click();
	  
	  driver.findElement(By.xpath("/html/body/div[1]/nav/div[1]/ul/li[3]/a/span")).click();
	  driver.findElement(By.xpath("//div[contains(text(),'shirts')]")).click();
	  driver.findElement(By.id("button-cart")).click();
	  driver.findElement(By.xpath("//a[contains(text(),'View Cart Details')]")).click();
	  
	  String number=driver.findElement(By.xpath("//td[@data-title='Price']")).getText();
	  int price = Integer.parseInt(number);
	  System.out.println(price);
	  
	  driver.findElement(By.xpath("//a[@class='cart_quantity_up js_increase_cart_product']")).click();
	  System.out.println("cart quantity successfully increased");
	  
	  String Qty=driver.findElement(By.xpath("//*[@id='cp_quantity_editable_input_3676383']")).getAttribute("value");
	  int  Quentity= Integer.parseInt(Qty);
	  System.out.println(Quentity);
	  	 
	  
	  String Total=driver.findElement(By.xpath("//td[@class='price col_total text-left']")).getText();
	  int expectedtot = Integer.parseInt(Total);
	  System.out.println(expectedtot);
	  
	  int actualtotal = price *Quentity;
	  if (expectedtot == actualtotal){
		  System.out.println("Actual Value '"+actualtotal+"' And Expected Value '"+expectedtot+"'  is correct.");
	  }
	  else{
		  System.out.println("Actual Value '"+actualtotal+"' And Expected Value '"+expectedtot+"' is correct.");
	  }
		
	  driver.findElement(By.id("searchKeywordHeader")).sendKeys("shirts");
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  
	  System.setProperty("webdriver.gecko.driver","D:\\valmiki\\geckodriver.exe");
	  driver=new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("https://valmikisstore.zepo.in/login");
	 
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }
  
}

package com.nehacreation.pages;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.nehacreation.helper.commonfunction;

public class Brandpage {

	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Classic Swan Collection')]")
	public WebElement eleUsername;
	
	@FindBy(how=How.XPATH,using="//*[@id='grid_View']/div[1]/div[2]/div/div/div[1]")
	public WebElement elehover;
	
	@FindBy(how=How.XPATH,using="//a[@class='shoping-icon']//img[@class='img-responsive']")
	public WebElement elecarticon; 
	
	//*[@id="grid_View"]/div[1]/div[3]
	//*[@id="grid_View"]/div[1]/div[3]
	//*[@id="grid_View"]/div[1]/div[3]
	//*[@id="grid_View"]/div[1]/div[2]/div/div/div[1]
	//*[@id="grid_View"]/div[1]/div[2]/div/div/div[1]
	//*[@id="grid_View"]/div[1]/div[3]/div/div/div[1]
	//*[@id="grid_View"]/div[1]/div[4]/div/div/div[1]
	//*[@id="grid_View"]/div[1]/div[4]/div/div/div[1]
	
	
	public void Searchproduct(WebDriver driver)
	{
		String actualproductname="Swarovski Crystaldust Bangle, M 5250023-1";
		
		eleUsername.click();
		
		List<WebElement> objproductname=driver.findElements(By.xpath("//*[@id='grid_View']/div[1]/div[*]/div/div/h3"));
		int size=objproductname.size();
		System.out.println(size);
		
		for(int i=1;i<=size;i++)
		{
			int j=i+1;
			String productname=driver.findElement(By.xpath("//*[@id='grid_View']/div[1]/div["+j+"]/div/div/h3")).getText();
			System.out.println(productname);
			if(productname.contains(actualproductname))
			{
				commonfunction.Actionmovetoandclick(driver,driver.findElement(By.xpath("//*[@id='grid_View']/div[1]/div["+j+"]/div/div/h3")),driver.findElement(By.xpath("//h3[contains(text(),'Add to Cart')]")));
				break;
				//*[@id="grid_View"]/div[1]/div[10]/div/div/div[2]/div/a/h3
			}
			
		}
		String toastmesgtext=driver.findElement(By.className("toast-message")).getText();
		System.out.println(toastmesgtext);
		
		if(toastmesgtext.contains("already exists in your Cart"))
		{
			elecarticon.click();
			
			List<WebElement> productoncartlist=driver.findElements(By.xpath("//html[1]/body[1]/section[3]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[*]/td[2]/a[1]"));
			int productaddedcountoncart=productoncartlist.size();
			System.out.println(productoncartlist);
			ArrayList<String> list=new ArrayList<String>();
			for(int i=1;i<=productaddedcountoncart;i++)
			{
				String productname=driver.findElement(By.xpath("//html[1]/body[1]/section[3]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr["+i+"]/td[2]/a[1]")).getText();
				System.out.println(productname);
				list.add(productname);
				if(list.contains(actualproductname))
				{
					driver.findElement(By.xpath("/html/body/section[3]/div[2]/div/div[2]/div[7]/button[2]")).click();
				}
				
			}
			
			
			//html[1]/body[1]/section[3]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]
			//html[1]/body[1]/section[3]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/a[1]
			//html[1]/body[1]/section[3]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[3]/td[2]/a[1]
			//html[1]/body[1]/section[3]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/a[1]
					
			//*[@id="56"]/td[2]/a
			//*[@id="58"]/td[2]/a
			//*[@id="56"]/td[2]/a
			//*[@id="52"]/td[2]/a
			//*[@id="23"]/td[2]/a
		}
		//*[@id="grid_View"]/div[1]/div[2]/div/div/h3
		//*[@id="grid_View"]/div[1]/div[2]/div/div/h3
		//*[@id="grid_View"]/div[1]/div[3]/div/div/h3
		//*[@id="grid_View"]/div[1]/div[4]/div/div/h3
		//*[@id="grid_View"]/div[1]/div[5]/div/div/h3
		//*[@id="grid_View"]/div[1]/div[6]/div/div/h3
		//*[@id="grid_View"]/div[1]/div[7]/div/div/h3
		//*[@id="grid_View"]/div[1]/div[8]/div/div/h3
		//
		//*[@id="grid_View"]/div[1]/div[2]/div/div/h3`
		
	}
}

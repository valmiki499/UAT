package com.nehacreation.pages;


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
	
	@FindBy(how=How.ID,using="")
	public WebElement elesubmit; 
	
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

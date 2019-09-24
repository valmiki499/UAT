package com.nehacreation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.nehacreation.helper.Excelcode;

public class OrderConfirmation {
	
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Classic Swan Collection')]")
	public WebElement elebrandswancollection;
	
	@FindBy(how=How.ID,using="FullName")
	public WebElement elefullname;
	
	@FindBy(how=How.ID,using="Address1")
	public WebElement eleAddress1;
	
	@FindBy(how=How.ID,using="Address2")
	public WebElement eleAddress2;
	
	@FindBy(how=How.ID,using="Landmark")
	public WebElement eleLandmark;
	
	@FindBy(how=How.ID,using="City")
	public WebElement eleCity;
	
	@FindBy(how=How.ID,using="DrpStateName")
	public WebElement eleDrpStateName;
	
	@FindBy(how=How.ID,using="PinCode")
	public WebElement elePinCode;
	
	@FindBy(how=How.ID,using="MobileNumber")
	public WebElement eleMobileNumber;
	
	@FindBy(how=How.CLASS_NAME,using="sub-mit")
	public WebElement elesubmit;
	
	
	public void OrderConfirmationdetails()
	{
		//String name,String add1,String add2,String landmark,String city,String state,String pin,String mobileno) throws Exception
		try {
			Excelcode.configexcel(Excelcode.excelpath, "Sheet2");
			
			elefullname.sendKeys(Excelcode.Getexceldata(1, 0));
			eleAddress1.sendKeys(Excelcode.Getexceldata(1, 1));
			eleAddress2.sendKeys(Excelcode.Getexceldata(1, 2));
			eleLandmark.sendKeys(Excelcode.Getexceldata(1, 3));
			eleCity.sendKeys(Excelcode.Getexceldata(1, 4));
			eleDrpStateName.sendKeys(Excelcode.Getexceldata(1, 5));
			elePinCode.sendKeys(Excelcode.Getexceldata(1, 6));
			eleMobileNumber.sendKeys(Excelcode.Getexceldata(1, 7));
			elesubmit.click();
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		
		
	}
	
}

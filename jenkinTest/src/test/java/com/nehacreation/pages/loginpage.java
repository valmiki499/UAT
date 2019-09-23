package com.nehacreation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class loginpage {
	
	@FindBy(how=How.ID,using="Email")
	WebElement eleUsername;
	
	@FindBy(how=How.ID,using="password")
	WebElement elepassword;
	
	@FindBy(how=How.CLASS_NAME,using="sub-mit")
	WebElement elesubmit;
	
	public void loginprocess(String username,String password)
	{
		eleUsername.sendKeys(username);
		elepassword.sendKeys(password);
		elesubmit.click();
	}

}

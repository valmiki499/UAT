package com.nehacreation.pages;


import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Brandpage {

	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Classic Swan Collection')]")
	WebElement eleUsername;
	
	@FindBy(how=How.ID,using="")
	WebElement elepassword;
	
	@FindBy(how=How.ID,using="")
	WebElement elesubmit;
	
	
	public void Searchproduct()
	{
		
		eleUsername.click();
	}
}

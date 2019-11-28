package com.expleo.nt.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ConfirmPage {
	
WebDriver driver;
	
	public ConfirmPage(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.XPATH,using="//input[@value='Confirm']")
	private WebElement confirmbtn;


	public void confirmorder(){
		confirmbtn.click();
	}
	
	public void verifyorderdetail(){
		
	}
	
}

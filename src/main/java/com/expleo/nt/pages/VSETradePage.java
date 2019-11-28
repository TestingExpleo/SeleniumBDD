package com.expleo.nt.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class VSETradePage {
	
WebDriver driver;
	
	public VSETradePage(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(how= How.XPATH, using="//a[@href='/trading/equities']")
	private WebElement Tradebtn;
	
	
	public void clicktrade(){
		Tradebtn.click();
	}
	
	public String verifytradetitle(){
		return driver.getTitle();
	}
}

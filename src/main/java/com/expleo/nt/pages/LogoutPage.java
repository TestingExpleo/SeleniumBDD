package com.expleo.nt.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.expleo.nt.base.NTBase;
import com.expleo.nt.utility.TestUtil;

public class LogoutPage {
	
WebDriver driver;
	
	public LogoutPage(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.XPATH,using="//a[@class='btnLogReg btnRegister']")
	private WebElement Logoutbtn;

	
	public void logoutclick(){
		Logoutbtn.click();
	}

}

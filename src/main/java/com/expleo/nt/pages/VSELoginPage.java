package com.expleo.nt.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.expleo.nt.base.NTBase;
import com.expleo.nt.utility.ExcelRead;

public class VSELoginPage extends NTBase {
	
	WebDriver driver;
	
	public VSELoginPage(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(how= How.XPATH, using="//a[@href='/login']")
	private WebElement Signinbtn;
	
	@FindBy(how=How.XPATH, using="//input[@name='UserName']")
	private WebElement Loginbtn;
	
	@FindBy(how=How.XPATH, using="//input[@name='Password']")
	private WebElement password;
	
	@FindBy(how=How.XPATH, using="//input[@type='submit']")
	private WebElement submitbtn;
	
	
	public void Signin(){
	
	Signinbtn.click();
	}
	
	public String verifylandingpagetitle(){
		return driver.getTitle();	
	}
	
	public void Login(){
		//Loginbtn.sendKeys(Prop.getProperty("username"));
		try {
			Loginbtn.sendKeys(ExcelRead.getValue("Username"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void password(){
		//password.sendKeys(Prop.getProperty("password"));
		try {
			password.sendKeys(ExcelRead.getValue("Password"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void submit(){
		submitbtn.click();
	}
}

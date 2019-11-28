package com.expleo.nt.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class VSEdashboardPage {

WebDriver driver;
	
	public VSEdashboardPage(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	public String verifydashboardtitle(){
		return driver.getTitle();
		
	}

}

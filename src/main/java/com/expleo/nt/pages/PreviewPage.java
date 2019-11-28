package com.expleo.nt.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.expleo.nt.utility.TestUtil;

public class PreviewPage {
	
WebDriver driver;
	
	public PreviewPage(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.XPATH,using="//*[@id='btnPreviewOrder']")
	private WebElement previewbtn;
	
	public void previewclick(){
		
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("window.scrollBy(0,600)");
        //js.executeScript("arguments[0].click();",previewbtn );
		
		WebDriverWait waitpreview = new WebDriverWait(driver, 700);
		WebElement previewbtn1 = waitpreview.until(ExpectedConditions.elementToBeClickable(previewbtn));
		//driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		//previewbtn1.click();
	}
	
	public boolean verifyorderdetails(){
		return driver.getPageSource().contains("Market");
	}

}

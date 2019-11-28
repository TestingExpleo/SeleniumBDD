package com.expleo.nt.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.expleo.nt.base.NTBase;
import com.expleo.nt.utility.ExcelRead;
import com.expleo.nt.utility.TestUtil;

public class TradedetailPage  {
	
WebDriver driver;
	
	public TradedetailPage(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(how= How.ID, using="ddlRegion")
	private WebElement region;
	
	@FindBy(how= How.XPATH,using="//a[text()='Mumbai']")
	private WebElement location;
	
	@FindBy(how=How.ID, using="ddlOrderSide")
	private WebElement actionbtn;
	
	@FindBy(how=How.XPATH, using="//input[@id='tbSymbol']")
	private WebElement symbol;
	
	@FindBy(how=How.NAME,using="Quantity")
	private WebElement Qty;
	
	@FindBy(how=How.XPATH,using="//select[@id='ddlOrderType']")
	private WebElement ordertype;
	
	
	
	
	public void selectregion(){
		Select drop = new Select(region);
		drop.selectByValue("Asia");
	
	}
	
	public void selectlocation(){
		location.click();
	}
	
	public void selectaction(){
		Select dropaction = new Select(actionbtn);
		dropaction.selectByVisibleText("Buy");
	}
	
	public void symbolvalue(){
		//super.wait();
		//wait.until(ExpectedConditions.elementToBeClickable(symbol));
		//symbol.click();
		WebDriverWait wait = new WebDriverWait(driver, 600);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(symbol));
		
		//JavascriptExecutor jse = ((JavascriptExecutor)driver);
        //jse.executeScript("arguments[0].click();",symbol );
		element.click();
		try {
			element.sendKeys("500112",Keys.DOWN,Keys.ENTER);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//WebElement element1= wait.until(ExpectedConditions.elementToBeSelected(symbol));
		
	}
	
	public void qtyvalue(){
		WebDriverWait waitqty = new WebDriverWait(driver, 200);
		WebElement qtyelement = waitqty.until(ExpectedConditions.elementToBeClickable(Qty));
		qtyelement.click();
		qtyelement.sendKeys("100");
		
	}
	
	public void ordertypevalue(){
		
		WebDriverWait waitorder = new WebDriverWait(driver, 400);
		 
		WebElement orderelement = waitorder.until(ExpectedConditions.elementToBeClickable(ordertype));
		
		Select orderelement1 = new Select(ordertype);
		
		 //Select orderelement1 = new Select(ordertype);
		orderelement1.selectByVisibleText("Market");
	}
	
	
}

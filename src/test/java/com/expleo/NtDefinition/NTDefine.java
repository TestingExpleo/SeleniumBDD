package com.expleo.NtDefinition;

import java.util.concurrent.TimeUnit;

import com.expleo.nt.base.NTBase;
import com.expleo.nt.pages.ConfirmPage;
import com.expleo.nt.pages.LogoutPage;
import com.expleo.nt.pages.PreviewPage;
import com.expleo.nt.pages.TradedetailPage;
import com.expleo.nt.pages.VSELoginPage;
import com.expleo.nt.pages.VSETradePage;
import com.expleo.nt.pages.VSEdashboardPage;
import com.expleo.nt.utility.TestUtil;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class NTDefine extends NTBase {
	TestUtil testutil = new TestUtil();
	VSELoginPage vseloginpage;
	VSEdashboardPage dashboard;
	VSETradePage trade;
	TradedetailPage tradedetails;
	PreviewPage preview;
	ConfirmPage confirm;
	LogoutPage logout;
	
	
	@Given("^User Logs into the VSE website$")
	public void user_Logs_into_the_VSE_website() throws Throwable {
	    NTBase.initialization();
	    
	}

	@When("^User inputs the valid username and password$")
	public void user_inputs_the_valid_username_and_password() throws Throwable {
		vseloginpage = new VSELoginPage(driver);
		vseloginpage.Signin();
		String frontpagetitle =vseloginpage.verifylandingpagetitle();
		System.out.println("title of page:" +frontpagetitle);
	    vseloginpage.Login();
	    vseloginpage.password();
	    vseloginpage.submit();
	    
		
	}

	@Then("^User verifies the title DASHBOARD$")
	public void user_verifies_the_title_DASHBOARD() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		dashboard = new VSEdashboardPage(driver);
	   String dashboardtitle =dashboard.verifydashboardtitle();
	   System.out.println("Title of page:" +dashboardtitle);
	   Assert.assertEquals("Dashboard",dashboardtitle );
	   System.out.println("Title matched");
	  }

	@Given("^User selects TRADE STOCKS option in MAKE A TRADE dropdown$")
	public void user_selects_TRADE_STOCKS_option_in_MAKE_A_TRADE_dropdown() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		trade=new VSETradePage(driver);
		trade.clicktrade();
		String tradetitle =trade.verifytradetitle();
		   System.out.println("Title of page:" +tradetitle);
		   Assert.assertEquals("Trading - Equities",tradetitle);
		   System.out.println("Title matched");
		
		
	    	}

	@When("^User selects the Region, Location and keys in necessary values$")
	public void user_selects_the_Region_Location_and_keys_in_necessary_values() throws Throwable {
		tradedetails = new TradedetailPage(driver);
		tradedetails.selectregion();
		tradedetails.selectlocation();
		tradedetails.selectaction();
		tradedetails.symbolvalue();
		tradedetails.qtyvalue();
		tradedetails.ordertypevalue();
		System.out.println("Trade details filled");
	    
	}

	@When("^Clicks the Preview Button$")
	public void clicks_the_Preview_Button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		preview = new PreviewPage(driver);
		//driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		preview.previewclick();
		//Assert.assertTrue("valid order", preview.verifyorderdetails());
	}

	@Then("^Now User Clicks the Confirm Button$")
	public void now_User_Clicks_the_Confirm_Button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		confirm= new ConfirmPage(driver);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		confirm.confirmorder();
	}

	@Then("^Trade is successfully placed$")
	public void trade_is_successfully_placed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Order placed successfully");
	}

	@Given("^User is in the VSE website$")
	public void user_is_in_the_VSE_website() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("User is in the VSE website");
	}

	@When("^Click Logout$")
	public void click_Logout() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		logout = new LogoutPage(driver);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		logout.logoutclick();
		System.out.println("User logsout of the website");
	    
	}

	@Then("^User verifies the Virtual Stock Exchange title$")
	public void user_verifies_the_Virtual_Stock_Exchange_title() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    driver.quit();
	    System.out.println("User quits the browser");

	}


}

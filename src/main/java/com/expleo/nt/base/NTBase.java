package com.expleo.nt.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.expleo.nt.utility.TestUtil;



public class NTBase {

	public static WebDriver driver;
	public static Properties Prop;
	//public WebDriverWait wait;
		
		public NTBase(){
			try {
				Prop = new Properties();
				FileInputStream ip = new FileInputStream("C:\\Users\\ALM.TGS-DPC-2394\\workspace\\"
						+ "NTBDD\\src\\main\\java\\com\\expleo\\nt\\config\\config.properties");
				Prop.load(ip);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}}
		
		public static void initialization(){
			String browserName = Prop.getProperty("browser");
			
			if(browserName.equals("chrome")){
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\ALM.TGS-DPC-2394\\Desktop\\"
						+ "Northern trust\\Lib file\\chromedriver_win32\\chromedriver.exe");	
				driver = new ChromeDriver(); 
			}
			else if(browserName.equals("FF")){
				System.out.println("Driver not found");
			}
			
			//WebDriverWait wait = new WebDriverWait(driver, 1000);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			driver.get(Prop.getProperty("url"));
			
			/*try {
				driver.manage().timeouts().wait(TestUtil.WAIT);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Element not found");
			}*/
			
	}
	
	
	
}

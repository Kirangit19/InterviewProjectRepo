package com.ixigo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.WebPage.HomePage;
import com.WebPage.TripList;

import baseClass.Utilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class IxigoRoundTrip extends Utilities{
	WebDriver driver;
	
	@BeforeMethod
	public void Initialize() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.ixigo.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void RoundTrip() {
		HomePage hp=new HomePage(driver);
		TripList tl=new TripList(driver);
		hp.searchRoundTrip();
		tl.compareTrip();
		System.out.println("Quickest Trip Price :" +tl.QuickestPrice());
		System.out.println("Recommended Trip Price :" +tl.RecommnededPrice());
		Assert.assertEquals(tl.QuickestPrice(), tl.RecommnededPrice(), "Price not match");
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}
}

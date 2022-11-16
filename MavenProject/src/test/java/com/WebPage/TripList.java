package com.WebPage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import baseClass.Utilities;

public class TripList extends Utilities{

	WebDriver driver;
	public TripList(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='srt-cntnr rtrn']/div[1]//span[text()='QUICKEST']")
	WebElement Quickest;

	@FindBy(xpath="//body/div[@id='content']//div[@class='result-wrpr']/div[1]//div[@class='c-flight-listing-split-row selected hide-detail']//div[1]//div[5]//span[2]")
	WebElement quickestPrice;
	

	@FindBy(xpath="//div[@class='srt-cntnr rtrn']/div[2]//span[text()='RECOMMENDED']")
	WebElement Recommended;

	@FindBy(xpath="//body/div[@id='content']//div[@class='result-wrpr']/div[2]//div[@class='c-flight-listing-split-row selected hide-detail']//div[1]//div[5]//span[2]")
	WebElement recommnededPrice;
	
	
	
	public void compareTrip() {
		fluentWait(driver, Quickest, 30);
		Quickest.click();
		Recommended.click();
	}
	
	public String QuickestPrice() {
		String Qprice=quickestPrice.getText();
		return Qprice;
	}
	
	public String RecommnededPrice() {
		String Rprice=recommnededPrice.getText();
		return Rprice;		
	}
	
}

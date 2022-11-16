package com.WebPage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.Utilities;

public class HomePage extends Utilities{

	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Round Trip']")
	WebElement RoundTrip;

	@FindBy(xpath="//div[@class='orgn u-ib u-v-align-bottom u-text-left']//input[@autocomplete='new-password']")
	WebElement FromTrip;
	
	@FindBy(xpath="//div[@class='dstn u-ib u-v-align-bottom u-text-left']//input[@autocomplete='new-password']")
	WebElement ToTrip;
	
	@FindBy(xpath="//input[@placeholder='Depart']")
	WebElement departure;
	
	@FindBy(xpath="//button[@class='ixi-icon-arrow rd-next']")
	WebElement nextMonth;

	@FindBy(xpath="//div[@class='rd-date']/div[2]//div[text()='16']")
	WebElement deptdate;
	@FindBy(xpath="//div[@class='rd-container flight-ret-cal extra-bottom rd-container-attachment arrow-animation']//div[@class='rd-date']/div[2]//div[text()='16']")
	WebElement returndate;

	@FindBy(xpath="//div[@class='flight-home-page']/div[1]//div[@class='u-ripple']")
	WebElement search;
	
	
	
	
	public void searchRoundTrip() {
		RoundTrip.click();
		FromTrip.click();
		FromTrip.sendKeys("Mumbai");
		FromTrip.sendKeys(Keys.ENTER);
		ToTrip.click();
		ToTrip.sendKeys(Keys.ENTER);
		departure.click();
		nextMonth.click();
		deptdate.click();
		returndate.click();
		search.click();
		
		
	}
	
}

package org.Shopizer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageCheckout {

	WebDriver driver;
	
	
	//Title checkout Page
	@FindBy(xpath="//h1")
	WebElement titleCheckout;
	
	
	
	//constructor
	public PageCheckout(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);	
		}

	
}

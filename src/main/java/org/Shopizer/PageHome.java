package org.Shopizer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageHome {
	
	WebDriver driver;

	//Texte "test text" sur page accueil
	@FindBy(xpath="//p[contains(., 'test text')]")
	WebElement textAssertHome;
	
	//Btn add to cart 1st product
	@FindBy(xpath="//a[@productid='150']")
	WebElement btnAddToCart1stProduct;
	
	//Text "(1)" into cart
	@FindBy(xpath="	//strong[.='(1)']")
	WebElement textAssertCartNumber;
	
	
	//Over to roll-on menu
	@FindBy(xpath="//a[contains(., 'Panier ')]")
	WebElement menuPanierToOver;
		
		
	//Btn paiement on roll on menu
	@FindBy(xpath="//a[contains(., 'Paiement')]")
	WebElement btnPaiementOnRollOn;
	

	//constructor
	public PageHome(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);	
		}

}

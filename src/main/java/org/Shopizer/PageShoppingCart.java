/**
 * 
 */
package org.Shopizer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author formation
 *
 */
public class PageShoppingCart {
	WebDriver driver;
	
	// Title (H1) of cart page
	@FindBy(xpath="//h1")
	WebElement titleCartPage;
	
	
	//Image in product table into cart
	@FindBy(xpath="//table[@id='mainCartTable']//div//div[1]")
	WebElement imgTableProductInCart;
	
	//Name in product table into cart
	@FindBy(xpath="//table[@id='mainCartTable']//div[2]")
	WebElement nameTableProductInCart;

	//Quantity in product table into cart
	@FindBy(name="quantity")
	WebElement quantityTableProductInCart;

	//Unit Price in product table into cart
	@FindBy(xpath="//td[3]//strong[1]")
	WebElement unitPriceTableProductInCart;

	//Total Price in product table into cart
	@FindBy(xpath="//td[4]//strong[1]")
	WebElement totalPriceTableProductInCart;
	
	
	//Btn "Reclaculer"
	@FindBy(xpath="//a[contains(text(),'Recalculer')]")
	WebElement btnRecalculerTableProductInCart;

	
	//Sous total
	@FindBy(xpath="//div[@class='cart-totals-table']//tr[1]//span")
	WebElement subTotalValueInCart;
	
	//Total
	@FindBy(xpath="//div[@class='cart-totals-table']//tr[2]//span")
	WebElement totalValueInCart;
	
	//Btn "effectuer le paiement"
	@FindBy(xpath="//a[contains(text(),'Effectuer le paiement')]")
	WebElement btnProceedCheckout;

	
	
	//constructor
	public PageShoppingCart(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);	
		}

}

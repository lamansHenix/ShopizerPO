/**
 * 
 */
package org.Shopizer;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import org.Shopizer.Connexion;

/**
 * UseShoppingCartTest is the class to test the use of the shopping cart
 * @author formation
 *
 */
public class UseShoppingCartTest {
	
	static Logger log = LoggerFactory.getLogger(UseShoppingCartTest.class);
	WebDriver driver;
	WebDriverWait wait;
	String quantityModified = "2";
	String URL="http://176.160.193.39:25890/shopizer";
	PageHome homepage;
	PageShoppingCart shoppingCart;
	PageCheckout checkout;
	
	
	
	
	/**
	 * setUp() is the method to choose the Browser
	 * @author formation
	 *
	 */
	@Before
	public void setUp() throws Exception {
		driver = ToolBox.chooseBrowser(log, EBrowser.f);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	/**
	 * tearDown() is the method to quite the browser
	 * @author formation
	 *
	 */
	@After
	public void tearDown() throws Exception {
		driver.quit();
		//log.info("QUIT DRIVER");
		System.out.println("QUIT DRIVER");
	}
	
	/**
	 * shoppingCartTest() is the method to automate Squash testing 
	 * @author formation
	 * @throws InterruptedException 
	 *
	 */
	@Test
	public void shoppingcartTest() throws InterruptedException {
	// PT1 : Open application on the Browser
		ToolBox.navToUrl(driver,URL);
		homepage = new PageHome(driver);

		assertTrue(homepage.textAssertHome.isDisplayed());
		
		//log.info("INFO : SHOPIZER IS OPEN");
		System.out.println("SHOPIZER IS OPEN");

	// PT2 : Added object on Shopping cart
		homepage.btnAddToCart1stProduct.click();
		assertEquals(homepage.textAssertCartNumber.getText(), "(1)");
		
		//log.info("INFO : SHOPIZER IS OPEN");
		System.out.println("INFO : OBJECT IS ADDED ON SHOPING CART");
		
	// PT3 : Open the shopping cart overview
		ToolBox.moveToElement(driver, homepage.menuPanierToOver);
		Thread.sleep(5000);
		homepage.btnPaiementOnRollOn.click();
		
		shoppingCart = new PageShoppingCart(driver);
		
		assertEquals(shoppingCart.titleCartPage.getText(), "Revoir votre commande");
		//log.info("INFO : SHOPING CART IS OPEN");
		System.out.println("INFO : SHOPING CART IS OPEN");
		
	// PT4 : Verify if object is displayed
		
		// Image verification
		assertTrue(shoppingCart.imgTableProductInCart.isDisplayed());
		// Name verification
		assertTrue(shoppingCart.nameTableProductInCart.isDisplayed());
		// Quantity verification
		assertTrue(shoppingCart.quantityTableProductInCart.isDisplayed());
		// Price verification
		assertTrue(shoppingCart.unitPriceTableProductInCart.isDisplayed());
		// Total verification
		assertTrue(shoppingCart.totalPriceTableProductInCart.isDisplayed());
		
		//log.info("INFO : ELEMENTS ARE DISPLAYED ON SHOPPING CART");
		System.out.println("ELEMENTS ARE DISPLAYED ON SHOPPING CART");
		
	// PT5 : Update quantity on shopping cart
		//doubler la quantité du produit
		ToolBox.fillInField(shoppingCart.quantityTableProductInCart, quantityModified);
		shoppingCart.btnRecalculerTableProductInCart.click();
		Thread.sleep(700);
		assertEquals(shoppingCart.quantityTableProductInCart.getAttribute("value"),quantityModified);
		
		//log.info("INFO : QUANTITY IS UPDATED");
		System.out.println("QUANTITY IS UPDATED");
		
	// PT6 : Verify total updated
		String unitPrice = shoppingCart.unitPriceTableProductInCart.getText().substring(3);
		String subtotal = shoppingCart.subTotalValueInCart.getText().substring(3);
		String total = shoppingCart.totalPriceTableProductInCart.getText().substring(3);
		
		double unit = Double.parseDouble(unitPrice);
		double dSubtotal = Double.parseDouble(subtotal);
		double dTotal = Double.parseDouble(total);
		
		assertTrue(dSubtotal == unit*2);
		assertTrue(dTotal == dSubtotal);
		
		//log.info("INFO : SUBTOTAL AND TOTAL PRICE AR UPDATED");
		System.out.println("SUBTOTAL AND TOTAL PRICE AR UPDATED");
		
	// PT7 : Verify checkout page is open
		shoppingCart.btnProceedCheckout.click();
		checkout = new PageCheckout(driver);
		Thread.sleep(200);
		
		assertEquals(checkout.titleCheckout.getText(), "Paiement");
		
		//log.info("INFO : CHECKOUT PAGE IS OPEN");
		System.out.println("CHECKOUT PAGE IS OPEN");
	}
	
}

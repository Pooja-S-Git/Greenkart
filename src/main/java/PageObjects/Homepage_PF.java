package PageObjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.GenericMethods;

public class Homepage_PF extends GenericMethods {

	WebDriver driver;

	// WebElement for Selecting list of products
	@FindBy(xpath = "//button[text()='ADD TO CART']")
	private List<WebElement> clickproducts;
	
	// WebElement for increment product
	@FindBy(xpath = "//a[contains(text(),'+')]")
	private WebElement increment_product;

	// WebElement for validate cart item
	@FindBy(xpath = "//*[text()='Brocolli - 1 Kg'][1]")
	private WebElement check_cartproduct;
	@FindBy(xpath = "//*[text()='Mushroom - 1 Kg'][1]")
	private WebElement check_product;
	@FindBy(xpath = "(//button[text()='ADD TO CART'])[10]")
	private WebElement nthCartitem;
	@FindBy(xpath = "//button[text()='ADD TO CART']")
	private WebElement AddtoCart;

	// WebElement for Action performed in cart
	@FindBy(css = "img[src='https://rahulshettyacademy.com/seleniumPractise/images/bag.png']")
	private WebElement clickcart;
	@FindBy(xpath = "(//a[@class='product-remove'])[3]")
	private WebElement remove_3rd_item;
	@FindBy(xpath = "(//a[@class='product-remove'])[5]")
	private WebElement remove_5th_item;
	@FindBy(xpath = "//button[text()='PROCEED TO CHECKOUT']")
	private WebElement checkout;

	// WebElement for verification
	@FindBy(xpath = "//p[@class='product-name']")
	private WebElement verify_cartproduct;
	@FindBy(xpath = "//header/div[1]/div[3]/div[2]/div[1]/div[1]/ul[1]/li[1]/div[2]/p[2]")
	private WebElement verify_cartamount;

	// Creating Constructor for homepage and initializing object to all the WebElements
	public Homepage_PF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Method for clicking 10th element
	public void Click_addtocart() {
		ScrollByUsingJsExecuter(driver,nthCartitem);
		Click_element(nthCartitem);
	}
	
	// Method for clicking single add to cart element
	public void click_addtocart() {
		Click_element(AddtoCart);
	}

	// Method for clicking list of  add to cart element
	public void click_List_addtocart() {
		click_add_to_cart(clickproducts,7);
	}

	// Method for clicking cart icon
	public void click_carticon() {
		Click_element(clickcart);
	}

	// Method for removing 3rd cart item
	public void Remove_cartitem() {
		Click_element(remove_3rd_item);
		Fluent_wait(driver, remove_5th_item);
		Click_element(remove_5th_item);
	}
	
	// Method for clicking proceed to checkout
	public void Proceed_to_checkout() {
		Click_element(checkout);
	}
	
	// Method for validating cart item products
	public void Check_cartitem_product() {
		validation_IsDisplayed(driver,verify_cartproduct);

	}

	// Method for validating cart item price
	public void Check_cartitem_price() {
		validation_IsDisplayed(driver,verify_cartamount);
	}
	
	// Method for searching through search bar
	public void Enter_productname() {
		 Actions act=new Actions(driver);
			act.sendKeys(Keys.TAB).sendKeys("Mushroom").build().perform();
	}
	
	// Method for increment the product
	public void Increment_Quantity() throws InterruptedException {
		for(int i=0;i<3;i++) {
			Explicit_wait(driver, increment_product);
			Click_element(increment_product);
			Thread.sleep(1000);
			
		}
	}
		
	// Method for soft assert validation
	public void Price_product_validation() {
		soft_assert_validation(verify_cartproduct, "Mushroom - 1 Kg");
		soft_assert_validation(verify_cartamount, "225");
		System.out.println("Displayed Correct product and total price successfully");
	}

}

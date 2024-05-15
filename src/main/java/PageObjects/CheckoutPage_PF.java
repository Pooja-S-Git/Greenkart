package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.GenericMethods;

public class CheckoutPage_PF extends GenericMethods {

	WebDriver driver;
	
	// WebElement for selecting country
	@FindBy(xpath = "//select[@style='width: 200px;']")
	private WebElement countrylist;
	@FindBy(xpath = "//option[@value='India']")
	private WebElement click_countryname;

	// WebElement for clicking radio button terms and condition
	@FindBy(css = "input.chkAgree")
	private WebElement clickcheckbox;
	@FindBy(xpath = "//button[text()='Proceed']")
	private WebElement proceedbutton;

	// WebElement for verify text after placing order and home page link
	@FindBy(xpath = "//span[text()='Thank you, your order has been placed successfully ']")
	private WebElement verify_textThankyou;
	@FindBy(xpath = "//a[text()='Home']")
	private WebElement link_to_homepage;

	// Creating Constructor for Checkout page and initializing object to all the
	// WebElements
	public CheckoutPage_PF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Method for Clicking the Countrylist
	public void Choose_country() {
		Click_element(countrylist);
		Click_element(click_countryname);
	}

	// Method for Clicking the check box
	public void Click_checkbox() {
		Click_element(clickcheckbox);
		Click_element(proceedbutton);
	}

	// Method for verify the thank you page and
	public void Verify_ThankingPage() {
		validation_IsDisplayed(driver, verify_textThankyou);
	}

	// Method for verify user navigate to home page
	public void Navigate_homepage() {
		Click_element(link_to_homepage);
	}
}


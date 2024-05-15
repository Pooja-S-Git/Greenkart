package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.GenericMethods;

public class Cartlistingpage_PF extends GenericMethods{

	WebDriver driver;

	// WebElement for getting alert message
	@FindBy(xpath = "//span[text()='Empty code ..!']")
	private WebElement getText_emptycode;
	@FindBy(xpath = "//span[text()='Invalid code ..!']")
	private WebElement getText_invalidcode;

	// WebElement for entering promo code
	@FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	private WebElement click_searchbar;
	@FindBy(xpath = "//button[contains(text(),'Apply')]")
	private WebElement apply_promocode;

	// WebElement to click place order button
	@FindBy(xpath = "//button[text()='Place Order']")
	private WebElement place_order_button;

	// Creating Constructor for cart listing and initializing object to all the WebElements
	public Cartlistingpage_PF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Method for clicking apply code
	public void Click_Applycode() {
		ScrollByUsingJsExecuter(driver,apply_promocode);
		Explicit_wait(driver, apply_promocode);
		Click_element(apply_promocode);
	}

	// Method for clicking place order
	public void Click_placeorder() {
		Click_element(place_order_button);
	}

	// Method for clicking apply code
	public void Enter_promocode() {
		Click_element(click_searchbar);
		EnterValue(click_searchbar, "promocode");
	}

	// Method for checking empty promocode alert
	public void promocode_Empty_alert() {
		validation_IsDisplayed(driver, getText_emptycode);

	}

	// Method for checking invalid promocode alert
	public void promocode_invalid_alert() {
		Fluent_wait(driver, getText_invalidcode);
		validation_IsDisplayed(driver, getText_invalidcode);

	}
}

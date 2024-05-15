package Step_Definition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.Cartlistingpage_PF;
import PageObjects.Homepage_PF;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.GenericMethods;

public class SD_Promocode extends GenericMethods {

	// Creating object for respective java class
	WebDriver driver = new ChromeDriver();
	Homepage_PF Homepage = new Homepage_PF(driver);
	Cartlistingpage_PF cartlist = new Cartlistingpage_PF(driver);

	// Methods for executing Scenario 3
	@Given("User able to open URL and view homepage")
	public void user_able_to_open_url_and_view_homepage() throws Exception {
		driver.manage().window().maximize();
		driver.get(URL());
		implicitwait(driver,20);
	}

	@When("User can select the multiple item and add to cart")
	public void user_can_select_the_multiple_item_and_add_to_cart() {
		Homepage.click_List_addtocart();
	}

	@And("User able to view cart of selected item")
	public void user_able_to_view_cart_of_selected_item() throws IOException, Exception {
		Homepage.click_carticon();
		CaptureScreenshot(driver, "Cart before removing 3rd item");
		Thread.sleep(1000);
	}

	@And("User able to remove 3rd  item in cart")
	public void user_able_to_remove_3rd_item_in_cart() throws Exception {
		Homepage.Remove_cartitem();
		CaptureScreenshot(driver, "Cart after removing 3rd item");
		Thread.sleep(1000);
		Homepage.Check_cartitem_product();
		Homepage.Check_cartitem_price();
	}

	@And("Click Proceed to checkout button in cart")
	public void click_proceed_to_checkout_button_in_cart() {
		Homepage.Proceed_to_checkout();
	}

	@And("Click apply button and alerted as empty code")
	public void click_apply_button_and_alerted_as_empty_code() throws Exception {
		cartlist.Click_Applycode();
		cartlist.promocode_Empty_alert();
		CaptureScreenshot(driver, "empty code alert");
		Thread.sleep(1000);
	}

	@And("User able to enter promo code")
	public void user_able_to_enter_promo_code() {
		cartlist.Enter_promocode();
		cartlist.Click_Applycode();
		
	}

	@Then("User able to view invalid promo code is applied")
	public void user_able_to_view_invalid_promo_code_is_applied()  throws Exception {
		cartlist.promocode_invalid_alert();
		CaptureScreenshot(driver, "invalid code alert");
		Thread.sleep(1000);
		Quit_browser(driver);
	}

}

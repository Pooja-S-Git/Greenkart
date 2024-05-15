package Step_Definition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.Cartlistingpage_PF;
import PageObjects.CheckoutPage_PF;
import PageObjects.Homepage_PF;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.GenericMethods;

public class SD_Navigate_home extends GenericMethods{

	// Creating object for respective java class
	WebDriver driver = new ChromeDriver();
	Homepage_PF Homepage = new Homepage_PF(driver);
	Cartlistingpage_PF cartlist = new Cartlistingpage_PF(driver);
	CheckoutPage_PF checkoutpage = new CheckoutPage_PF(driver);

	// Methods for executing Scenario 4
	@Given("User able to open URL and view the home page")
	public void user_able_to_open_url_and_view_the_home_page() throws Exception{
		driver.manage().window().maximize();
		driver.get(URL());
		implicitwait(driver,20);
	}

	@When("User able to select multiple products and add to the cart")
	public void user_able_to_select_multiple_products_and_add_to_the_cart() {
		Homepage.click_List_addtocart();
	}

	@And("Click cart icon in homepage application")
	public void click_cart_icon_in_homepage_application() {
		Homepage.click_carticon();
	}

	@And("User able to remove 3rd and 6th item of cart")
	public void user_able_to_remove_3rd_and_6th_item_of_cart() {
		Homepage.Remove_cartitem();
		Homepage.Check_cartitem_product();
		Homepage.Check_cartitem_price();
	}

	@And("Click proceed to checkout button")
	public void click_proceed_to_checkout_button() {
		Homepage.Proceed_to_checkout();
	}

	@And("Click the place order button")
	public void click_the_place_order_button() {
		cartlist.Click_placeorder();
	}

	@And("User able to choose country,accept check box and click on proceed")
	public void user_able_to_choose_country_accept_check_box_and_click_on_proceed() {
		checkoutpage.Choose_country();
		checkoutpage.Click_checkbox();

	}

	@And("User able to view thankyou page after clicking placing order")
	public void user_able_to_view_thankyou_page_after_clicking_placing_order() {
		checkoutpage.Verify_ThankingPage();
	}

	@Then("Click on homepage link")
	public void click_on_homepage_link() {
		checkoutpage.Navigate_homepage();
		Quit_browser(driver);
	}

}

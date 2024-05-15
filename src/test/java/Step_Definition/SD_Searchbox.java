package Step_Definition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.Homepage_PF;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.GenericMethods;

public class SD_Searchbox extends GenericMethods {

	// Creating object for respective java class
	WebDriver driver = new ChromeDriver();
	Homepage_PF Homepage = new Homepage_PF(driver);

	// Method for executing Scenario 2
	@Given("User able to the open url")
	public void user_able_to_the_open_url() throws Exception{
		driver.manage().window().maximize();
		driver.get(URL());
		implicitwait(driver,20);
	}

	@When("User on the homepage and search for product")
	public void user_on_the_homepage_and_search_for_product() {
		Homepage.Enter_productname();
	}

	@And("Click increment icon of product")
	public void click_increment_icon_of_product() throws Exception {
		Homepage.Increment_Quantity();
	}

	@And("Click add to cart button")
	public void click_add_to_cart_button() {
		Homepage.click_addtocart();
	}

	@And("User able to click the cart icon")
	public void user_able_to_click_the_cart_icon() throws Exception {
		Homepage.click_carticon();
		CaptureScreenshot(driver, "Cart after increment");
		Thread.sleep(1000);
	}

	@Then("User able to view calculated price and quantity of selected item")
	public void user_able_to_view_calculated_price_and_quantity_of_selected_item() {
		Homepage.Price_product_validation();
		Quit_browser(driver);
	}

}

package Step_Definition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.Homepage_PF;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.GenericMethods;

public class SD_Homepage extends GenericMethods {

	// Creating object for respective java class
	WebDriver driver = new ChromeDriver();
	Homepage_PF Homepage = new Homepage_PF(driver);

	// Methods for executing Scenario 1
	@Given("User able to open URL")
	public void user_able_to_open_url() throws Exception {
		driver.manage().window().maximize();
		driver.get(URL());
		implicitwait(driver, 20);
	}

	@When("User on homepage and able to add 10th item to cart")
	public void user_on_homepage_and_able_to_add_10th_item_to_cart() {
		Homepage.Click_addtocart();
	}

	@And("Click cart icon in homepage")
	public void click_cart_icon_in_homepage() {
		Homepage.click_carticon();
	}

	@And("User able to view selected item in cart")
	public void user_able_to_view_selected_item_in_cart() throws Exception {
		CaptureScreenshot(driver, "Cart item");
		Thread.sleep(1000);
	}

	@Then("User able to view price in the cart and check same as in home page")
	public void user_able_to_view_price_in_the_cart_and_check_same_as_in_home_page() {
		Homepage.Check_cartitem_product();
		Homepage.Check_cartitem_price();
		Quit_browser(driver);
	}

}

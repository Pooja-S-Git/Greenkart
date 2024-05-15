package Step_Definition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.FlightBookingpage_PF;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.GenericMethods;

public class SD_FlightBooking extends GenericMethods {

	// Creating object for respective java class
	WebDriver driver = new ChromeDriver();
	FlightBookingpage_PF flightbooking = new FlightBookingpage_PF(driver);

	// Methods for executing Scenario 5
	@Given("User is able to open URL in the browser and view the home page")
	public void user_is_able_to_open_url_in_the_browser_and_view_the_home_page() throws Exception{
		driver.manage().window().maximize();
		driver.get(URL());
		implicitwait(driver,20);
	}

	@When("Click Flight booking link")
	public void click_flight_booking_link() {
		driver.navigate().to("https://rahulshettyacademy.com/dropdownsPractise/");
	}

	@And("User able to enter country name and pick from the list")
	public void user_able_to_enter_country_name_and_pick_from_the_list() throws Exception {
		flightbooking.Select_country();
	}

	@And("Click flight title")
	public void click_flight_title() {

	}

	@And("Click round trip radio button")
	public void click_round_trip_radio_button() {
		flightbooking.Trip_mode();
	}

	@And("User choose FROM location and TO location")
	public void user_choose_from_location_and_to_location() {
		flightbooking.FromLocation();
		flightbooking.ToLocation();
	}

	@And("User able to click the depart and return date")
	public void user_able_to_click_the_depart_and_return_date() {
		flightbooking.Select_date();
	}

	@And("Click number of passenger according to the catagory")
	public void click_number_of_passenger_according_to_the_catagory() {
		flightbooking.Count_person_catagory();
	}

	@And("Click currency option from dropdown")
	public void click_currency_option_from_dropdown() {
		flightbooking.Select_Currency();
	}

	@And("Click Friends and family radio button")
	public void click_friends_and_family_radio_button() {

	}

	@And("User able to click search option")
	public void user_able_to_click_search_option() throws Exception {
		flightbooking.Search_button();

	}

	@Then("Click accept alert and search")
	public void click_accept_alert_and_search() throws InterruptedException {

		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		flightbooking.Search_button();
		Quit_browser(driver);
	}
}

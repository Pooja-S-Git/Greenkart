package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.GenericMethods;
import utils.ReadExcel;

public class FlightBookingpage_PF extends GenericMethods{

	// Creating object
	WebDriver driver;
	ReadExcel DataExcel = new ReadExcel();

	// WebElement for selecting country,trip type and mode
	@FindBy(css = "input[id=autosuggest]")
	private WebElement click_searchbox;
	@FindBy(id = "ui-id-4")
	private WebElement selecting_dropdown;
	@FindBy(xpath = "//span[text()='Flights']")
	private WebElement flightoption;
	@FindBy(id = "ctl00_mainContent_rbtnl_Trip_1")
	private WebElement radio_button_triptype;

	// WebElement for clicking from and to location
	@FindBy(name = "ctl00_mainContent_ddl_originStation1_CTXT")
	private WebElement fromlocation_arrow;
	@FindBy(xpath = "//a[text()=' Chennai (MAA)']")
	private WebElement fromlocation_click;
	@FindBy(id = "ctl00_mainContent_ddl_destinationStation1_CTXT")
	private WebElement Tolocation_arrow;
	@FindBy(xpath = "(//a[@value='GOI'])[2]")
	private WebElement Tolocation_click;

	// WebElement for selecting depart and return date
	@FindBy(xpath = "(//a[text()='31'])[1]")
	private WebElement click_departdate;
	@FindBy(xpath = "//input[@id='ctl00_mainContent_view_date2']")
	private WebElement returndate_select;
	@FindBy(xpath = "(//a[text()='29'])[1]")
	private WebElement returndate_click;

	// WebElement for selecting number of person
	@FindBy(xpath = "//*[@id='divpaxinfo']")
	private WebElement adult_button;
	@FindBy(id = "hrefIncAdt")
	private WebElement infant_button;
	@FindBy(xpath = "//span[@id='hrefIncInf']")
	private WebElement child_button;
	@FindBy(xpath = "//input[@id='btnclosepaxoption']")
	private WebElement done_button;

	// WebElement for selecting currency list and search
	@FindBy(xpath = "//select[@id='ctl00_mainContent_DropDownListCurrency']")
	private WebElement arrow_currencyList;
	@FindBy(xpath = "//option[text()='INR']")
	private WebElement click_currency;
	@FindBy(css = "input[id='ctl00_mainContent_chk_friendsandfamily']")
	private WebElement radiobutton_family_friends;
	@FindBy(xpath = "//*[@id='ctl00_mainContent_btn_FindFlights']")
	private WebElement SearchButton;

	// Creating Constructor for flightbooking page and initializing object to all
	// the WebElements
	public FlightBookingpage_PF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Method for Selecting country
	public void Select_country() throws Exception {
		Click_element(click_searchbox);
		EnterValue(click_searchbox, DataExcel.Country());
		Click_element(selecting_dropdown);
	}

	// Method for click flight option and trip mode
	public void Trip_mode() {
		Click_element(flightoption);
		Explicit_wait(driver, radio_button_triptype);
		Click_element(radio_button_triptype);
	}

	// Method for selecting from location
	public void FromLocation() {
		Click_element(fromlocation_arrow);
		Click_element(fromlocation_click);
	}

	// Method for selecting To location
	public void ToLocation() {
		Click_element(Tolocation_arrow);
		Click_element(Tolocation_click);
	}

	// Method for selecting depart and return date
	public void Select_date() {
		Click_element(click_departdate);
		Click_element(returndate_select);
		Click_element(returndate_click);
	}

	// Method for selecting number of person
	public void Count_person_catagory() {
		Click_element(adult_button);
		Click_element(infant_button);
		Click_element(child_button);
		Click_element(done_button);
	}

	// Method for selecting currency list
	public void Select_Currency() {
		Click_element(arrow_currencyList);
		Click_element(click_currency);
		Click_element(radiobutton_family_friends);

	}

	// Method for clicking search button
	public void Search_button() {
		Click_element(SearchButton);
	}
}

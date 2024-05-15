package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class GenericMethods {

	public WebDriver driver;
	public Properties propertiesfile = new Properties();
	
	// Method to click a element
	public void Click_element(WebElement element) {
		element.click();
	}

	// Method to enter value in text box
	public void EnterValue(WebElement element, String text) {
		element.sendKeys(text);
	}
	
	// Method for implicit wait
	public void implicitwait(WebDriver driver,int time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}

	// Method for explicit wait(visibility of element)
	public void Explicit_wait(WebDriver driver, WebElement element) {
		element = new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(element));
	}

	// Method for Fluent Wait
	public void Fluent_wait(WebDriver driver, WebElement element) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(50))
				.pollingEvery(Duration.ofMillis(500)).ignoring(Exception.class);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// Method for taking Screenshot
	public void CaptureScreenshot(WebDriver driver, String filename) throws IOException {
		TakesScreenshot takescreenshot = (TakesScreenshot) driver;
		File file = takescreenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("./Screenshots/" + filename + ".png"));
	}

	// Method for Javascript_executor for scrolling
	public void ScrollByUsingJsExecuter(WebDriver driver, WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy(0,400)",element);
	}

	// Method for hard assert for validating the products
	public void validation_IsDisplayed(WebDriver driver, WebElement element) {
		boolean elementname = element.isDisplayed();
		Assert.assertTrue(elementname);
		System.out.println(element.getText());
		System.out.println(" Displayed successfully");
	}

	// Method for soft assert for validating the products
	public void soft_assert_validation(WebElement element, String Expected) {
		String actual = element.getText();
		System.out.println(actual);
		String expected = Expected;
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actual, expected, "Mismatched");
		softAssert.assertAll();
	}

	//Method for entering URL
		public String URL() throws Exception {
			String projectpath = System.getProperty("user.dir");
			FileInputStream file_input = new FileInputStream(projectpath + "/src/test/resources/keyvalue_data.properties");
			propertiesfile.load(file_input);
			String URL_to_chrome = propertiesfile.getProperty("url");
		    return URL_to_chrome;
		    }
		
	// Method for looping
	public void click_add_to_cart(List<WebElement> element, int a) {
		for (int j = 1; j < element.size(); j++) {
			if (j < a) {
				element.get(j).click();
			}
		}
	}

	// Method for close the browser
	public void Quit_browser(WebDriver driver) {
		driver.quit();
	}
	
}

















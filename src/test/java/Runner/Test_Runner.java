package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src\\test\\java\\Feature",
		glue={"Step_Definition"},
		plugin= {"pretty",
				"html:target/Reports.html",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}

		)

public class Test_Runner {

}







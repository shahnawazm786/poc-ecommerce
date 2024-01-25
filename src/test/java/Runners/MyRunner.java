package Runners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/features",
		glue = "steps",
		tags="@signin",
		monochrome = true,
		dryRun = false,
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:target/rerun.txt"}

		)
public class MyRunner extends AbstractTestNGCucumberTests {

	@DataProvider(parallel=true)
	public Object[][] scenarios(){
		return super.scenarios();
	}
	{
		
	}
}

package steps;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.manager.SeleniumManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Constant;

public class MyHooks {
	//https://peter.sh/experiments/chromium-command-line-switches/
	public static WebDriver driver;
	ChromeOptions options;
	@Before
	public void setup() {
		WebDriverManager.chromedriver().setup();
		options=new ChromeOptions();
		//System.setProperty("webdriver.chrome.driver", Constant.CHROME_LOCTION);
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--start-maximized");
		options.setBrowserVersion("120.0.6099.217");
		driver=new ChromeDriver(options);
		//driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(Constant.URL);
		//driver.manage().window().maximize();
	}
	@After
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			// capture screen
			//final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            //scenario.attach(screenshot, "image/png", scenario.getName());
			File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
		}
		driver.quit();
	}
	

}

package pages;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	// Locator 
	@FindBy(using = "//a[@class='toolbar-account']",how=How.XPATH)
	private WebElement account_toolbar;
	/*@FindBy(xpath="//a[@class='toolbar-account']")
	private WebElement account_toolbar_xpath;*/
	@FindBy(using="img[itemprop='logo']",how=How.CSS)
	private WebElement site_logo;
	
	// Function
	public void clickOnAccount() {
		// Explicit wait
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(account_toolbar));
		account_toolbar.click();
	}
	public void verifyHomePage() {
		boolean isLogoPresent=site_logo.isDisplayed();
		assertTrue(isLogoPresent);
	}
	
}

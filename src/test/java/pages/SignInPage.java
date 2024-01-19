package pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Base64EncodeAndDecode;
import utils.PropertiesRead;
import utils.SeleniumCommonFunction;

public class SignInPage {
	WebDriver driver;
	public SignInPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	// Locator
	
	@FindBy(using = "div#login>h2",how=How.CSS)
	private WebElement login_label;
	
	@FindBy(using="a[href$='register']",how=How.CSS)
	private WebElement register_link;
	
	
	//input#customer_email
	@FindBy(using="input#customer_email",how=How.CSS)
	private WebElement textbox_customer_email;
	
	//input#customer_password
	@FindBy(using="input#customer_password",how=How.CSS)
	private WebElement textbox_customer_password;
	
	//input[type='submit'][value='Sign In']
	@FindBy(using="input[type='submit'][value='Sign In']",how=How.CSS)
	private WebElement button_sign_in;
	
	//div#customer_sidebar>h2
	@FindBy(using="div#customer_sidebar>h2",how=How.CSS)
	private WebElement label_login_name_display;
	
	
	public void verifySignInPage() {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(login_label));
		boolean isLogoPresent=login_label.isDisplayed();
		assertTrue(isLogoPresent);
	}
	public void clickOnRegisterLink() {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(register_link));
		register_link.click();
	}
	
	public void feedLoginData() {
		SeleniumCommonFunction.waitElement(driver,textbox_customer_email );
		SeleniumCommonFunction.clearText(textbox_customer_email);
		SeleniumCommonFunction.send_keys(driver, textbox_customer_email, PropertiesRead.getData("username"));
		SeleniumCommonFunction.waitElement(driver,textbox_customer_password );
		SeleniumCommonFunction.clearText(textbox_customer_password);
		SeleniumCommonFunction.send_keys(driver, textbox_customer_password, PropertiesRead.getData("password"));
	}
	
	public void cllckOnSignButton() {
		SeleniumCommonFunction.click(driver, button_sign_in);
	}
	public void verifyUserLoginSuccessfully() {
		String expected=Base64EncodeAndDecode.encodeString(PropertiesRead.getData("userdisplayname"));
		String actual=SeleniumCommonFunction.getText(driver, label_login_name_display);
		System.out.println(expected);
		System.out.println(actual);
		assertEquals(actual,expected);
	}

}

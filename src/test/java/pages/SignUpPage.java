package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utils.PropertiesRead;
import utils.SeleniumCommonFunction;

public class SignUpPage {
	WebDriver driver;
	public SignUpPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	// Locator of the SingUp Page
	//@FindBy(using="first_name",how=How.ID)
	@FindBy(using="input#first_name",how=How.CSS)
	private WebElement textbox_first_name;
	
	//@FindBy(using="last_name",how=How.ID)
	@FindBy(using="input#last_name",how=How.CSS)
	private WebElement textbox_last_name;
	//email
	//@FindBy(using="email",how=How.ID)
	@FindBy(using="input#email",how=How.CSS)
	private WebElement textbox_email;
	
	//@FindBy(using="password",how=How.ID)
	@FindBy(using="input#password",how=How.CSS)
	private WebElement textbox_password;
	
	@FindBy(using="input[type='submit'][value='Create']",how=How.CSS)
	private WebElement button_create;
	
	public void feedDataForRegistrationForm() {
		
		SeleniumCommonFunction.waitElement(driver, textbox_first_name);
		SeleniumCommonFunction.clearText(textbox_first_name);
		textbox_first_name.sendKeys("Mohammad");
		SeleniumCommonFunction.waitElement(driver, textbox_last_name);
		SeleniumCommonFunction.clearText(textbox_last_name);
		textbox_last_name.sendKeys("Shahnawaz");
		SeleniumCommonFunction.waitElement(driver, textbox_email);
		SeleniumCommonFunction.clearText(textbox_email);
		//textbox_email.sendKeys("moon082022@gmail.com");
		textbox_email.sendKeys(PropertiesRead.getData("username"));
		SeleniumCommonFunction.waitElement(driver, textbox_password);
		SeleniumCommonFunction.clearText(textbox_password);
		textbox_password.sendKeys(PropertiesRead.getData("password"));
		
	}
	public void clickOnCreateAccount() {
		SeleniumCommonFunction.waitElement(driver, button_create);
		button_create.click();
	}
}

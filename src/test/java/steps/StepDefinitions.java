package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SignInPage;
import pages.SignUpPage;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class StepDefinitions {
	static final Logger logger = Logger.getLogger(StepDefinitions.class);
	
	HomePage homePage=new HomePage(MyHooks.driver);
	SignInPage signinPage=new SignInPage(MyHooks.driver);
	SignUpPage signupPage=new SignUpPage(MyHooks.driver);
	@Given("^open the application")
	public void open_The_Application() {

		PropertyConfigurator.configure("log4j.properties");

		logger.info("-- Open home page");
		homePage.verifyHomePage();
		logger.info("-- Page opened");
	}
	@When("^click on account icon")
	public void click_on_account_icon() {
		logger.info("click on account page");
		homePage.clickOnAccount();
		logger.info("clicked on account page");
	}
	@And("^verify Sign In page")
	public void verify_Sign_In_page() {
		logger.info("verify sign in page");
		signinPage.verifySignInPage();
		logger.info("verified sign in page");
	}
	@When("^click on register link")
	public void click_on_register_link() {
		signinPage.clickOnRegisterLink();
	}
	@And("^feed the value")
	public void feed_the_value() {
		signupPage.feedDataForRegistrationForm();
	}
	@When("^i click on register button")
	public void i_click_on_register_button()
	{
		signupPage.clickOnCreateAccount();
	}
	@Then("^verify user is registered")
	public void verify_user_is_registered() {
		homePage.verifyHomePage();
	}
	
	@When("^I enter data in login and password text box")
	public void iEnterDataInLoginAndPasswordTextBox() {
		signinPage.feedLoginData();
	}
	@Then("^I click on singin button")
	public void iClickOnSinginButton() {
		signinPage.cllckOnSignButton();
	}
	@And("^I verify the user is login successfully")
	public void iVerifyTheUserIsLoginSuccessfully() {
		signinPage.verifyUserLoginSuccessfully();
	}
	

}

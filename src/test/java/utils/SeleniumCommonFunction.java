package utils;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumCommonFunction {

	public static void clearText(WebElement element) {
		element.clear();
	}
	public static void waitElement(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(
				ExpectedConditions.or(ExpectedConditions.visibilityOf(element),ExpectedConditions.elementToBeClickable(element)
						));

	}
	public static void send_keys(WebDriver driver,WebElement element,String keys) {
		waitElement(driver,element);
		element.sendKeys(keys);	
	}
	public static void click(WebDriver driver,WebElement element) {
		waitElement(driver,element);
		element.click();
	}
	public static String getText(WebDriver driver,WebElement element) {
		waitElement(driver,element);
		return element.getText();
	}
}

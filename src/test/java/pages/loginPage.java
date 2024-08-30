package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage {

	WebDriver driver;
	By userName = By.id("firstname");
	By userSurname = By.id("lastname");
	By userEmail = By.id("email_address");
	By password = By.id("password");
	By cnfPassword = By.id("password-confirmation");
	By submitButton = By.className("submit");
	By contactInformation = By.xpath("//*[contains(text(),'Contact Information')]");
	
	public loginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public void enterNameAndSurname(String Name, String Surname) {
		driver.findElement(userName).sendKeys(Name);
		driver.findElement(userSurname).sendKeys(Name);
	}
	
	public void enterEmailAndPassword(String email, String newPassword) {
		driver.findElement(userEmail).sendKeys(email);
		driver.findElement(password).sendKeys(newPassword);
		driver.findElement(cnfPassword).sendKeys(newPassword);
	}
	
	public void clickSubmitButton() {
		driver.findElement(submitButton).click();
	}
	
	public void checkAccountCreated()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		try
		{
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(contactInformation));
		    boolean a = element.isDisplayed();
			if (!a) {
                throw new AssertionError("test failed");
			}
		}
		catch(AssertionError e)
		{
			System.err.println("Assertion failed: " + e.getMessage());
			 throw e;
		}
	}
	
}

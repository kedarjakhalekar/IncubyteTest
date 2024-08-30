package StepDefinitions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.loginPage;

public class LoginSteps {
	
	WebDriver driver = null; 
	loginPage login = new loginPage(driver);
	
	@Given("Browser is open")
	public void browser_is_open() {
		System.out.println("Browser is open");
		System.getProperty("webdriver.chrome.driver", "C:/Users/kedar/eclipse-workspace/CucumberJava/src/test/resources/drivers/chromedriver.exe");
		
		driver = new ChromeDriver();
	}
	
	@And("user is on Create Account page")
	public void user_is_on_create_account_page() {
		driver.navigate().to("https://magento.softwaretestingboard.com/customer/account/create/");
		System.out.println("Inside Step - user is on login page");
	}

	@When("user enteres username and password")
	public void user_enteres_username_and_password() {
		
		login.enterNameAndSurname("Name", "Surname");
		login.enterEmailAndPassword("lumatest1"+"@mailinator.com","KJselenium@12345");
	}

	@And("clicks on Submit button")
	public void clicks_on_Submit_button() {
		loginPage login = new loginPage(driver);
		login.clickSubmitButton();
	}

	@Then("Account is created")
	public void account_is_created() {
		loginPage login = new loginPage(driver);
		login.checkAccountCreated();
	    driver.quit();
	}
}

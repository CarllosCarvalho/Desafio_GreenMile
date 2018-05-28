package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class LoginGreenMileStepDefinitions {
	
WebDriver driver;
	
	@Given("^User is already on Login Page GreenMile$")
	public void user_already_on_login_page(){
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demo.greenmile.com/#/login");
		
	}
	@When("^title of login page is GreenMile Live$")
	public void title_login_page_GreenMile_Live(){
		String title = driver.getTitle();
		System.out.println(title.trim());
		Assert.assertEquals("GreenMile Live 6.12.5", title.trim());
	}
	
	@Then("^user enters username and password GreenMile$")
	public void user_enters_username_and_password_GreenMile(){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("j_username")));
		
		driver.findElement(By.id("j_username")).sendKeys("GM-Carlos");
		driver.findElement(By.id("j_password")).sendKeys("greenmile");
	}

	@Then("^user clicks on login button GreenMile$")
	public void user_clicks_on_login_button_GreenMile(){
		WebElement loginBtn = driver.findElement(By.xpath(".//*[@id='Login']/div[2]/div/button"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", loginBtn);
	}
	
	@Then("^user is on home page GreenMile$")
	public void user_is_on_home_page_Green_Mile() {
		String title = driver.getTitle();
		System.out.println("Home Page Title ::"+title.trim());
		Assert.assertEquals("GreenMile Live 6.12.5", title.trim());
	}
	

}

package StepDefinitions;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Helper.GreenMileHelper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterQuestionHappyDayStepDefinitions extends GreenMileHelper{

	WebDriver driver;
	
	Random gerador = new Random();
	String nameItem = "Question"+gerador.nextInt(30);
	
	
	@Given("^User access to SmartSurvey functionality$")
	public void user_access_to_SmartSurvey_functionality(){
		startApplicationGreenMile();
		loginGreenMile();
		navigateToSmartSurvivy();
	}
	@When("^Button to register question and visible$")
	public void button_to_register_question_and_visible(){
		waitButtonNEW();
	}
	@Then("^user click in NEW for Register Question$")
	public void user_click_in_NEW_for_Register_Question() {
		clickButtonNEW();
	}
	@Then("^user fill in the fields Description and Organization$")
	public void user_fill_in_the_fields_Description_and_Organization() throws InterruptedException{
		fillFildsDescriptionAndOrganization(nameItem);
	}
	@Then("^user click in ADD APPLICATION RULES$")
	public void user_click_in_ADD_APPLICATION_RULES(){
		clickButtonApplicationRules();
	}
	@Then("^user click in SAVE$")
	public void user_click_in_SAVE() {
		clickButtonSAVE();
	}
	@Then("^user fill in the field Title$")
	public void user_fill_in_the_field_Title()  {
		fillFildTitle();
	}
	@Then("^user click in ADD QUESTION$")
	public void user_click_in_ADD_QUESTION() {
		clickButtonAddQuestion();
	}
	@Then("^user click in any question section$")
	public void user_click_in_any_question_section(){
		clickInAnyQuestion();
	}
	@Then("^user fill in the required fields$")
	public void user_fill_in_the_required_fields() throws Throwable {
		fillRequiredFildsQuestions();
	}
	@Then("^user click in SAVE Questions$")
	public void user_click_in_SAVE_Questions() {
		clickButtonSaveQuestion();
	}
	@Then("^user verify register Question$")
	public void user_verify_register_Question() {
		verifyRegisterQuestion(nameItem);
	}
	
}

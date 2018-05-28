package StepDefinitions;

import Helper.GreenMileHelper;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MandatoryFildErrorRegisterQuestion extends GreenMileHelper{

	@Given("^User access to SmartSurvey to Simulate Error in Register$")
	public void user_access_to_SmartSurvey_to_Simulate_Error_in_Register(){
		startApplicationGreenMile();
		loginGreenMile();
		navigateToSmartSurvivy();
	}
	
	@When("^Button to register question and visible for Register$")
	public void button_to_register_question_and_visible_for_Register(){
		waitButtonNEW();
	}

	@Then("^user click in NEW to Simulate Error in Register$")
	public void user_click_in_NEW_to_Simulate_Error_in_Register(){
		clickButtonNEW();
	}
	
	@Then("^user click in SAVE to Simule Error in Register$")
	public void user_click_in_SAVE_to_Simulate_Error_in_Register(){
		clickButtonSaveQuestion();
	}
	

	@Then("^user verify Error Mesage in register Question$")
	public void user_verify_Error_Mesage_in_register_Question(){
		verifyMessageErroMandatoryFild();
	}
	
}

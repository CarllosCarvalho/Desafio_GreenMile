package StepDefinitions;

import Helper.GreenMileHelper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class findQuestionInSmartSurvey extends GreenMileHelper{

	String nameItemRegisted = "Teste";
	
	@Given("^User access to SmartSurvey to Find Question Register$")
	public void user_access_to_SmartSurvey_to_Find_Question_Register(){
		startApplicationGreenMile();
		loginGreenMile();
		navigateToSmartSurvivy();
	}

	@When("^Button to Find question is visible$")
	public void button_to_Find_question_is_visible(){
		waitButtonNEW();
	}

	@Then("^user Fill in the field to search and click in Filter$")
	public void user_Fill_in_the_field_to_search_click_in_filter(){
		findForRegisteredItem(nameItemRegisted);
	}

	@Then("^user verify Question is visible in Grid$")
	public void user_verify_Question_is_visible_in_Grid(){
		verifyRegisterQuestion(nameItemRegisted);
	}
	
}

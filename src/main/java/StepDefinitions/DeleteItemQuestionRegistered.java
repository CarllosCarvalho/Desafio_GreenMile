package StepDefinitions;

import Helper.GreenMileHelper;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DeleteItemQuestionRegistered extends GreenMileHelper{

	String nameItemRegisted = "Question for Delete TESTE";
	
	@Given("^User Acess Smart Survey to delete an item$")
	public void user_acess_smart_survey_to_delete_an_item(){
		startApplicationGreenMile();
		loginGreenMile();
		navigateToSmartSurvivy();
	}

	@When("^Need to register an item to delete$")
	public void need_to_register_an_item_to_delete(){
		waitButtonNEW();
	}

	@Then("^user click in NEW and Register Any Question$")
	public void user_click_in_NEW_and_Register_Any_Question() throws InterruptedException{
		registerItemQuestion(nameItemRegisted);
	}

	@Then("^user find search for the registered item and Select$")
	public void user_find_search_for_the_registered_item_and_Select(){
		findForRegisteredItem(nameItemRegisted);
	}

	@Then("^user click in DELETE SELECTED$")
	public void user_click_in_DELETE_SELECTED(){
		clickButtonDeleteSelected();
	}

	@Then("^user verify Delete Item Question$")
	public void user_verify_Delete_Item_Question(){
		verifyRegisterQuestionDeleted();
	}
}

package MyRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
			features = "C:/Users/CarlosHenrique/Desktop/Carlos/WorkSpace Curso Java/Desafio_GreenMile/automationFramework/src/main/java/Features/"
			,glue={"StepDefinitions"},monochrome = true,
			format={"pretty","html:test-outout"}
		)
public class TestRunner {
	
	
	
}

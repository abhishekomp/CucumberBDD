package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestFeatureFile_steps {
	

	@Given("I have numbers")
	public void i_have_numbers() {
	    System.out.println("Inside I have numbers");
	}

	@When("I add them")
	public void i_add_them() {
		System.out.println("Inside I add them");
	}

	@Then("I get the sum")
	public void i_get_the_sum() {
		System.out.println("Inside I get the sum");
	}
	
}

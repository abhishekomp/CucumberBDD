package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Step definition class – each method here is bound to a Gherkin step via
 * the @Given / @When / @Then annotations.
 *
 * Environment variables are injected by the GitHub Actions workflow so the
 * same test binary can be used across different CI runs without code changes.
 */
public class TestFeatureFile_steps {

    /**
     * "Given I have numbers"
     *
     * Reads several environment variables that GitHub Actions may inject
     * (via the 'env:' block on a workflow step) and prints them for visibility.
     * Also demonstrates parsing a JSON client_payload sent via repository_dispatch.
     */
    @Given("I have numbers")
    public void i_have_numbers() {
        // TEST_ORDERNUM – order number passed via workflow_dispatch input
        System.out.println("Test OrderNumber = " + System.getenv("TEST_ORDERNUM"));

        // JOB_ID_TRS – the GitHub Actions run ID, set explicitly in the workflow
        System.out.println("Job id = " + System.getenv("JOB_ID_TRS"));

        // TEST_ORDER_NUM – alternative order-number key used in some Postman requests
        System.out.println("Example Key from Postman = " + System.getenv("TEST_ORDER_NUM"));

        // TEST_CLIENT_PAYLOAD – full JSON payload from a repository_dispatch event
        String clientPayload = System.getenv("TEST_CLIENT_PAYLOAD");
        System.out.println("clientPayload = " + clientPayload);

        // TEST_CLIENT_ICCID – ICC ID extracted directly by the workflow expression
        System.out.println("ICC from postman = " + System.getenv("TEST_CLIENT_ICCID"));

        // GITHUB_RUN_URL – constructed in the workflow so we can print a direct link
        System.out.println("GITHUB_RUN_URL = " + System.getenv("GITHUB_RUN_URL"));

        // Parse the JSON payload only when it is actually present.
        // Use isEmpty() instead of != "" – string equality must use .equals() in Java;
        // != "" compares object references, not content, which is a common bug.
        if (clientPayload != null && !clientPayload.isEmpty()) {
            System.out.println("icc values are:");
            JSONObject payload = new JSONObject(clientPayload);
            JSONArray icc = payload.getJSONArray("icc");
            icc.forEach(System.out::println);
        }
    }

    /**
     * "When I add them"
     * Represents the action / system-under-test interaction.
     */
    @When("I add them")
    public void i_add_them() {
        System.out.println("Inside I add them");
    }

    /**
     * "Then I get the sum"
     * Asserts / verifies the expected outcome.
     */
    @Then("I get the sum")
    public void i_get_the_sum() {
        System.out.println("Inside I get the sum");
    }
}

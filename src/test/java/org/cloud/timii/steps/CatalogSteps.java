package org.cloud.timii.steps;

import javax.ws.rs.core.Response;

import junit.framework.Assert;

import org.cloud.timii.CatalogEndpoint;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class CatalogSteps {

	private CatalogEndpoint catalog;
	private Response response;

	@Given("a catalog endpoint")
	public void givenACatalog() {
		catalog = new CatalogEndpoint();
	}

	@When("I call get catalog")
	public void whenICallGetCatalog() {
		response = catalog.getCatalog();
	}

	@Then("the outcome should be $result")
	public void thenTheOutComeShouldBe(String result) {
		String entity = response.getEntity().toString();
		Assert.assertEquals(result, entity);
	}
}

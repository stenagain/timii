package org.cloud.timii.steps;

import org.cloud.timii.Res;
import org.cloud.timii.product.DefaultProductService;
import org.cloud.timii.product.Product;
import org.cloud.timii.product.ProductFactory;
import org.cloud.timii.product.ProductService;
import org.cloud.timii.product.Products;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

public class CatalogSteps {

	private ProductService catalog;
	private Res<Products> response;

	@Given("a catalog endpoint")
	public void givenACatalog() {
		catalog = new DefaultProductService();
	}

	@When("I call get catalog")
	public void whenICallGetCatalog() {
		//add product
		Product p = ProductFactory.create("Product1", "Teaching someone something very useful", 100);
		catalog.createProduct(p);
		response = catalog.getProducts();
	}

	@Then("the outcome should be $result")
	public void thenTheOutComeShouldBe(String result) {
		Products prods = response.getObject(); 
		String desc = prods.getProducts().get(0).getDescription();
		Assert.assertEquals(result, desc);
	}
}

package com.example.product_aggregator_project.cucumber.stepdefinitions;

import com.example.product_aggregator_project.model.Product;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductStepDefinitions {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private ResponseEntity<List<Product>> productListResponseEntity;
    private ResponseEntity<Product> productResponseEntity;

    @Given("the application is running")
    public void theApplicationIsRunning() {

    }

    @When("the client calls endpoint for all products {string}")
    public void theClientCallsEndpointForAllProducts(String endpoint) {
        String url = "http://localhost:" + port + endpoint;

        productListResponseEntity = restTemplate.exchange(url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                });

    }

    @When("the client calls endpoint for a single product {string}")
    public void theClientCallsEndpointForASingleProduct(String endpoint) {
        String url = "http://localhost:" + port + endpoint;
        int productId = 2;
        url = url.replace("{id}", String.valueOf(productId));
        productResponseEntity = restTemplate.getForEntity(url, Product.class);
    }

    @When("the client calls endpoint {string} with the following query parameters:")
    public void theClientCallsEndpointWithTheFollowingQueryParameters(String endpoint, Map<String, String> queryParams) {
        String url = "http://localhost:" + port + endpoint;

        StringBuilder queryString = new StringBuilder("?");
        for (Map.Entry<String, String> entry : queryParams.entrySet()) {
            queryString.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        url += queryString.toString();

        productListResponseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                });
    }

    @Then("the response status code for all products should be {int}")
    public void theResponseStatusCodeForAllProductsShouldBe(Integer expectedStatusCode) {
        assertThat(productListResponseEntity.getStatusCodeValue()).isEqualTo(expectedStatusCode);
    }

    @Then("the response status code for a single product should be {int}")
    public void theResponseStatusCodeForASingleProductShouldBe(Integer expectedStatusCode) {
        assertThat(productResponseEntity.getStatusCodeValue()).isEqualTo(expectedStatusCode);
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(Integer expectedStatusCode) {
        assertThat(productListResponseEntity.getStatusCodeValue()).isEqualTo(expectedStatusCode);
    }

    @Then("the response should contain a list of products")
    public void theResponseShouldContainAListOfProducts() {
        assertThat(productListResponseEntity.getBody()).isNotNull();
        assertThat(productListResponseEntity.getBody()).isNotEmpty();
    }

    @Then("the response should contain a single product")
    public void theResponseShouldContainASingleProduct() {
        assertThat(productResponseEntity.getBody()).isNotNull();
    }

    @Then("the response should contain a list of filtered products")
    public void theResponseShouldContainAListOfFilteredProducts() {
        assertThat(productListResponseEntity.getBody()).isNotNull();
    }
}

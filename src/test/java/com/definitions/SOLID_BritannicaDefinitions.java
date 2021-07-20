package com.definitions;

import com.PropertiesReader;
import com.aventstack.extentreports.Status;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pom.HomePage;
import pom.components.*;

import static com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter.getCurrentStep;

public class SOLID_BritannicaDefinitions extends SOLID_TestBase {

    private static String baseURL;
    private HomePage homePage;
    private Header header;
    private LoginComponent loginComponent;
    private Results results;
    private ResultsFilters resultsFilters;
    private Cart cart;
    private double calculatedTotalPrice = 0;

    @Before
    public static void setup() {
        baseURL = PropertiesReader.getInstance().getProperty("base.url");
    }

    @Given("I open shufersal home page")
    public void i_open_shufersal_home_page() {
        homePage = new HomePage(chromeDriver);
        getCurrentStep().log(Status.INFO, "Opening home page...");
        Assert.assertTrue(homePage.openShufersalHomePage(), "Page is not open!");
        getCurrentStep().log(Status.INFO, "Home page is open!");
        Assert.assertTrue(homePage.isPageDisplayed());
    }

    @Given("I login to shufersal website with username {string} and password {string}")
    public void i_login_to_shufersal_website_with_username_and_password(String userName, String password) {
        header = new Header(chromeDriver);
        header.clickLogin();
        loginComponent = new LoginComponent(chromeDriver);
        loginComponent.doLogin(userName, password);
        Assert.assertTrue(loginComponent.isLoggedIn());
    }

    @Given("I search product name {string}")
    public void i_search_product_name(String productName) {
        header = new Header(chromeDriver);
        header.search(productName);
        results = new Results(chromeDriver);
        Assert.assertTrue(results.isPageDisplayed());
    }

    @Given("I filter the results by price from low to high")
    public void i_filter_the_results_by_price_from_low_to_high() {
        resultsFilters = new ResultsFilters(chromeDriver);
        resultsFilters.selectFilterOrder(1);
    }

    @When("I add product to cart with keyword {string}")
    public void i_add_product_to_cart_with_keyword(String key) {
        results.clickAddProductToCart(key);
    }

    @When("I calculate the total price in cart with delivery fee")
    public void i_calculate_the_total_price_in_cart_with_delivery_fee() {
        cart = new Cart(chromeDriver);
        calculatedTotalPrice = cart.getCalculatedPriceInCart();
    }

    @Then("I check total price in cart if equals calculated price")
    public void i_check_total_price_in_cart_if_equals_calculated_price() {
        Assert.assertEquals(cart.getTotalPriceInCart(), calculatedTotalPrice);
    }

    @After
    public void afterAll() {
        getCurrentStep().log(Status.INFO, "Closing chrome driver...");
        closeDriver();
        getCurrentStep().log(Status.INFO, "Chrome driver is closed!");
    }
}

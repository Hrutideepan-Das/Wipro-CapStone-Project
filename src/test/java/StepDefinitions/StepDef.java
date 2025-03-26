package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Demowebshop.Base.DriverManager;
import Demowebshop.Pages.CartPage;
import Demowebshop.Pages.CheckoutPage;
import Demowebshop.Pages.LoginPage;
import Demowebshop.Pages.LogoutPage;
import Demowebshop.Pages.RegistrationPage;
import Demowebshop.Pages.SearchPage;
import Demowebshop.Pages.SearchPage2;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef{
	private WebDriver driver;
	private RegistrationPage registrationPage;
	private LoginPage loginPage;
	private LogoutPage logoutPage;
	private SearchPage searchPage;
	private SearchPage2 searchPage2;
	private CartPage cartPage;
	private CheckoutPage checkoutPage;
	
	

    @Before
    public void setup() {
        this.driver = DriverManager.getDriver();  // Ensure driver is initialized
    }
	
	
	@Given("User is on the website")
	public void user_is_on_the_website() {
		driver.get("https://demowebshop.tricentis.com/");
	}
	
	@When("User navigates to the registration page")
	public void user_navigates_to_the_registration_page() {
	    driver.get("https://demowebshop.tricentis.com/register");
	    registrationPage = new RegistrationPage(driver);
	}
	
	@When("User enters valid registration details")
	public void user_enters_valid_registration_details() {
	    registrationPage.selectGender("Male");
	    registrationPage.enterFirstName("User11");
	    registrationPage.enterLastName("2");
	    registrationPage.enterEmail("user177@email.com");
//	    registrationPage.enterEmail("user128@email.com");
	    registrationPage.enterPassword("123456");
	    registrationPage.confirmPassword("123456");
	}
	
	@When("Clicks on the register button")
	public void clicks_on_register_button() {
	    registrationPage.clickRegister();
	}

	@Then("Registration should be successful")
	public void registration_should_be_successfull() {
	    Assert.assertTrue(registrationPage.isRegistrationSuccessful());
	}

	@Then("User should be able to log in with the registered credentials")
	public void user_should_be_able_to_log_in_with_the_registered_credentials() {
		loginPage = new LoginPage(driver);
        driver.get("https://demowebshop.tricentis.com/login");
 	    loginPage.enterEmail("user175@email.com");
 	    loginPage.enterPassword("123456");
 	    loginPage.clickLoginButton();
 	    Assert.assertTrue(loginPage.isLogoutButtonDisplayed());
	}
	
	@When("User enters an already registered email")
    public void theUserEntersAnAlreadyRegisteredEmail() {
        registrationPage.selectGender("Male");
	    registrationPage.enterFirstName("Alex");
	    registrationPage.enterLastName("Tron");
	    registrationPage.enterEmail("yegerem798@dmener.com");
	    registrationPage.enterPassword("@lextron");
	    registrationPage.confirmPassword("@lextron");
    }

    @Then("An error message should be displayed indicating email already exists")
    public void anErrorMessageShouldBeDisplayedIndicatingEmailAlreadyExists() {
        Assert.assertTrue(registrationPage.getEmailErrorMessage().contains("The specified email already exists"));
    }
    
    @Then("User should log in with the required credentials for confirming")
    public void user_should_log_in_with_the_required_credentials_for_confirming() {
        loginPage = new LoginPage(driver);
        driver.get("https://demowebshop.tricentis.com/login");
 	    loginPage.enterEmail("yegerem798@dmener.com");
 	    loginPage.enterPassword("@lextron");
 	    loginPage.clickLoginButton();
 	    Assert.assertTrue(loginPage.isLogoutButtonDisplayed());
    }
    
    
    
    //LoginSteps
    @When("User navigates to the login page")
    public void user_navigates_to_login_page() {
        driver.get("https://demowebshop.tricentis.com/login");
        loginPage = new LoginPage(driver);
    }
    
	@When("User enters valid credentials")
	public void user_enters_valid_credentials() {
	    loginPage.enterEmail("yegerem798@dmener.com");
	    loginPage.enterPassword("@lextron");
	}

	@When("Clicks on the login button")
	public void clicks_on_the_login_button() {
	    loginPage.clickLoginButton();
	}

	@Then("User should be logged in successfully")
	public void user_should_be_logged_in_successfully() {
	    Assert.assertTrue(loginPage.isLogoutButtonDisplayed());
	}

	@Then("Logout button should be visible")
	public void logout_button_should_be_visible() {
		Assert.assertTrue(loginPage.isLogoutButtonDisplayed());
	}

	@When("User enters invalid credentials")
	public void user_enters_invalid_credentials() {
	    loginPage.enterEmail("invalid@email.com");
	    loginPage.enterPassword("pass@123");
	}

	@Then("An error message should be displayed indicating invalid login")
	public void an_error_message_should_be_displayed_indicating_invalid_login() {
		Assert.assertTrue(loginPage.getErrorMessage().contains("Login was unsuccessful"));
	}
	
	

	// Search and add-to-cart steps
	@Given("User is on the homepage")
	public void user_is_on_the_homepage() {
		driver.get("https://demowebshop.tricentis.com/");
		searchPage = new SearchPage(driver);
	}

	@When("User searches for {string}")
	public void user_searches_for(String productName) {
	    searchPage.enterInput(productName); 
	    searchPage.clickSearchButton(); 
	}

//	@When("Clicks on the product from the search results")
//	public void clicks_on_product_from_search_results() {
//		searchPage.clickSearchElement();
//	} 
	
	@When("Clicks on the product from the search results")
	public void clicks_on_product_from_search_results() {
	    searchPage.clickSearchElement();  // Click the product dynamically
	}
	

	@When("Clicks on the Add to Cart button")
	public void clicks_on_the_add_to_cart_button() {
	    searchPage.clickAddToCartButton();
	}

	@Then("The product should be added to the cart successfully")
	public void the_product_should_be_added_to_the_cart_successfully() {
	    Assert.assertTrue(searchPage.isAddedSuccessfully());
	}
    
		
	
	// Adding Multiple Products to Cart & Validating Cart Summary
	@Given("User is on the WebHomepage")
	public void user_is_on_the_web_homepage() {
		driver.get("https://demowebshop.tricentis.com/");
		searchPage2 = new SearchPage2(driver);
	}
	
	@When("User search for {string}")
	public void user_search_for(String productName) {
	    searchPage2.enterInput(productName); 
	    searchPage2.clickSearchButton(); 
	}
	
	@When("Clicks on the product from the search result")
	public void clicks_on_product_from_search_result() {
	    searchPage2.clickSearchElement();  // Click the product dynamically
	}
	
	@When("Clicks on the Add to Cart button for first result")
	public void clicks_on_the_add_to_cart_button_for_first_result() {
	    searchPage2.clickAddToCartButton1();
	}
	
	@When("Clicks on the Add to Cart button for second result")
	public void clicks_on_the_add_to_cart_button_for_second_result() {
	    searchPage2.clickAddToCartButton2();
	}
	
	@When("User navigates to the cart page")
	public void user_navigates_to_the_cart_page() {
	    cartPage = new CartPage(driver);
	    cartPage.openCart();
	}
	

	@Then("The cart should display both products")
	public void the_cart_should_display_both_products() {
	    Assert.assertTrue(cartPage.isProductInCart("Computing and Internet"));
	    Assert.assertTrue(cartPage.isProductInCart("Smartphone"));
	}

	@Then("The total price should be displayed")
	public void the_total_price_should_be_displayed() {
	    Assert.assertTrue(cartPage.isTotalPriceDisplayed());
	}
	
	
	// Applying Coupon code 
	@Given("User has added a product to the cart")
    public void user_has_added_a_product_to_the_cart() {
        searchPage = new SearchPage(driver);
        searchPage.enterInput("14.1-inch Laptop"); 
        searchPage.clickSearchButton(); 
        searchPage.clickSearchElement();
        searchPage.clickAddToCartButton();
        Assert.assertTrue(searchPage.isAddedSuccessfully());
    }

    @When("User navigates to the checkout page")
    public void user_navigates_to_the_checkout_page() {
        cartPage = new CartPage(driver);
        cartPage.openCart();
    }

    @When("User enters a coupon code")
    public void user_enters_a_coupon_code() {
        cartPage.enterCouponCode("DISCOUNT10");
        cartPage.clickApplyCouponCodeButton();
    }

    @Then("The coupon code should be validated correctly")
    public void the_coupon_code_should_be_validated_correctly() {
        Assert.assertTrue(cartPage.isValidationMessageDisplayed());
    }
	
	
    // Checkout Process 
    @Given("User open the shopping cart")
    public void user_open_the_shopping_cart() {
        cartPage = new CartPage(driver);
        cartPage.openCart();
    }

    @When("User clicks on checkout button")
    public void user_clicks_on_checkout_button() {
    	checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickCheckoutButton();
    }

    @When("User enters invalid shipping details")
    public void user_enters_invalid_shipping_details() {
    	checkoutPage.selectNewBillingAddress();
        checkoutPage.enterInvalidShippingDetails("Alex", "Tron", "yegerem798@dmener.com", "India", "Bangalore", "560076", "9938222898"); // Empty fields
    }

    @Then("An error message should be displayed")
    public void an_error_message_should_be_displayed() {
        Assert.assertTrue(checkoutPage.isErrorDisplayed());
    }

    @When("User enters valid shipping details")
    public void user_enters_valid_shipping_details() {
    	checkoutPage.selectNewBillingAddress();
        checkoutPage.enterValidShippingDetails("Alex", "Tron", "yegerem798@dmener.com", "India", "BTM", "Bangalore", "560076", "9938222898");
    }

    @When("Completes the checkout process")
    public void completes_the_checkout_process() {
        checkoutPage.clickContinueShippingAddress();
        checkoutPage.clickContinueShippingMethod();
        checkoutPage.clickContinuePaymentMethod();
        checkoutPage.clickContinuePaymentInfo();
        checkoutPage.clickConfirmOrderButton();
    }

    @Then("An order confirmation message should be displayed")
    public void an_order_confirmation_message_should_be_displayed() {
        Assert.assertTrue(checkoutPage.isOrderConfirmed());
    }
    
    
	//logoutSteps
    @Given("User is logged in")
    public void user_is_logged_in() {
        user_navigates_to_login_page();
        user_enters_valid_credentials();
        clicks_on_the_login_button();
        Assert.assertTrue(loginPage.isLogoutButtonDisplayed());
    }
    
	@When("User clicks on the logout button")
	public void user_clicks_on_the_logout_button() {
		logoutPage = new LogoutPage(driver);
		logoutPage.clickLogoutButton();
	}
	
	@Then("Login button should be visible")
	public void login_button_should_be_visible() {
	    Assert.assertTrue(logoutPage.isLoginButtonDisplayed());
	}
}

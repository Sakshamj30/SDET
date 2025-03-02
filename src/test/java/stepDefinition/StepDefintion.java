package stepDefinition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import SeleniumPrep.FullSeleniumFramework.pom.AddProduct;
import SeleniumPrep.FullSeleniumFramework.pom.CheckOut;
import SeleniumPrep.FullSeleniumFramework.pom.ClickOnCart;
import SeleniumPrep.FullSeleniumFramework.pom.ConfirmPage;
import SeleniumPrep.FullSeleniumFramework.pom.Done;
import SeleniumPrep.FullSeleniumFramework.pom.LoginPage;
import UtilityTest.Based;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefintion extends Based {

	public LoginPage loginPage;
	public AddProduct addProduct;
	public ClickOnCart Cart;
	public Done done;

	@Given("User is on ecommerce site")
	public void User_is_on_ecommerce_site() throws IOException {

		loginPage = launchApp();
	}

	@Given("User logged in ecommerce site with username")
	public void user_logged_in_ecommerce_site_with_username() throws IOException {

		LoginPage login = launchApp();

		// add products to cart
		addProduct = login.login("sakshamjauhari23@gmail.com", "Saksham7571@");

	}

	@When("User is on product page and User click on add to cart button for products")
	public void user_is_on_product_page_and_user_click_on_add_to_cart_button_for_products() {
		List<String> orders = new ArrayList();
		orders.add("ADIDAS ORIGINAL");
		orders.add("ZARA COAT 3");

		Cart = addProduct.addProducts(orders);
		Cart.clickCart();

	}

	@Then("products are added in cart")
	public void products_are_added_in_cart() throws InterruptedException {
		
		List<String> orders = new ArrayList();
		orders.add("ADIDAS ORIGINAL");
		orders.add("ZARA COAT 3");

		CheckOut checkOut = Cart.checkCart(orders);

		// shopping done
		done = checkOut.check();
		done.doneShopping();

	}

}

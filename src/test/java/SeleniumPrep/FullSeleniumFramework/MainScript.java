package SeleniumPrep.FullSeleniumFramework;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SeleniumPrep.FullSeleniumFramework.pom.AddProduct;
import SeleniumPrep.FullSeleniumFramework.pom.CheckOut;
import SeleniumPrep.FullSeleniumFramework.pom.ClickOnCart;
import SeleniumPrep.FullSeleniumFramework.pom.ConfirmPage;
import SeleniumPrep.FullSeleniumFramework.pom.Done;
import SeleniumPrep.FullSeleniumFramework.pom.LoginPage;
import UtilityTest.Based;

public class MainScript extends Based {

	@Test(dataProvider = "getData")
	public void main(HashMap<String, String> input) throws InterruptedException, IOException {

		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<String> orders = new ArrayList();
		orders.add("ADIDAS ORIGINAL");
		orders.add("ZARA COAT 3");

		// login

		LoginPage login = launchApp();

		// add products to cart
		AddProduct addProduct = login.login(input.get("email"), input.get("password"));

		// click on cart
		ClickOnCart Cart = addProduct.addProducts(orders);
		Cart.clickCart();
		// check products are added as per user

		// checkout
		CheckOut checkOut = Cart.checkCart(orders);

		// shopping done
		Done done = checkOut.check();
		done.doneShopping();

	}

	@Test(dependsOnMethods = { "main" }, dataProvider = "getData")
	public void verifyShopping(HashMap<String, String> input) throws IOException, InterruptedException {

		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<String> orders = new ArrayList();
		orders.add("IPHONE 13 PRO");
		orders.add("ZARA COAT 3");

		LoginPage login = launchApp();

		AddProduct addProduct = login.login(input.get("email"), input.get("password"));
		ClickOnCart Cart = addProduct.addProducts(orders);
		Cart.clickCart();
		CheckOut checkOut = Cart.checkCart(orders);
		Done done = checkOut.check();
		done.doneShopping();

		ConfirmPage confirm = new ConfirmPage(driver);
		confirm.verifyShopping(orders);

	}

	@DataProvider
	public Object[][] getData() {

		// return new Object[][] { {"sakshamjauhari23@gmail.com","Saksham7571@"}};

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("email", "sakshamjauhari23@gmail.com");
		map.put("password", "Saksham7571@");

		return new Object[][] { { map } };

	}

}

package SeleniumPrep.FullSeleniumFramework.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import SeleniumPrep.FullSeleniumFramework.AbstractComponents.Utility;

public class ClickOnCart extends Utility {

	WebDriver driver;

	public ClickOnCart(WebDriver driver) {
		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "(//button[@class=\"btn btn-custom\"])[3]")
	WebElement cart;

	public void clickCart() {
		cart.click();
	}

	@FindBy(css = ".cartSection h3")
	List<WebElement> cartProducts;

	public CheckOut checkCart(@SuppressWarnings("rawtypes") List orders) {

		for (WebElement e : cartProducts) {

			Assert.assertTrue(orders.contains(e.getText()), "product added successfully");

		}

		CheckOut checkOut = new CheckOut(driver);
		return checkOut;
	}

}

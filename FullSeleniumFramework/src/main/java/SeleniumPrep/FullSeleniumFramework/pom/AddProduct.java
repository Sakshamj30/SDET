package SeleniumPrep.FullSeleniumFramework.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumPrep.FullSeleniumFramework.AbstractComponents.Utility;

public class AddProduct extends Utility {

	WebDriver driver; // class variable for driver

	public AddProduct(WebDriver driver) { // constructor to first set driver/.

		super(driver); // sending driver to parent class that is utility from child.
		this.driver = driver;

		// page factory initialization

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='card-body']/h5")
	List<WebElement> products;

	public ClickOnCart addProducts(@SuppressWarnings("rawtypes") List orders) { // action method

		for (int i = 0; i < products.size(); i++) {

			WebElement e = products.get(i);

			int a = i + 1;

			if (orders.contains(e.getText())) {

				System.out.println(e.getText());

				driver.findElement(By.xpath("(//button[@class='btn w-10 rounded'])" + "[" + a + "]")).click();

				// wait for animation and toast and get text

				waits();

			}

		}

		ClickOnCart Cart = new ClickOnCart(driver);
		return Cart;

	}

}

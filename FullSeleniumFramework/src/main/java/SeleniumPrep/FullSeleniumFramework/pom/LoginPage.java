package SeleniumPrep.FullSeleniumFramework.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumPrep.FullSeleniumFramework.AbstractComponents.Utility;

public class LoginPage extends Utility {

	WebDriver driver; // class variable for driver

	public LoginPage(WebDriver driver) { // constructor to first set driver

		super(driver); // sending driver to parent class that is utility from child.

		this.driver = driver;

		// page factory initialization

		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "[type='email']")
	WebElement email;

	@FindBy(id = "userPassword")
	WebElement password;

	@FindBy(xpath = "//input[@id='login']")
	WebElement login;


	public AddProduct login(String username, String pass) { // action method

		driver.get("https://rahulshettyacademy.com/client");
		email.sendKeys(username);
		password.sendKeys(pass);
		login.click();
		AddProduct addProduct = new AddProduct(driver);
		return addProduct;
	}

}

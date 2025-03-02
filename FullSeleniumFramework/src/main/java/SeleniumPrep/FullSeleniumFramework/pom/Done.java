package SeleniumPrep.FullSeleniumFramework.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import SeleniumPrep.FullSeleniumFramework.AbstractComponents.Utility;

public class Done extends Utility {

	WebDriver driver;

	public Done(WebDriver driver) {
		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".hero-primary")
	WebElement text;

	public void doneShopping() {

		Assert.assertEquals(text.getText(), "THANKYOU FOR THE ORDER.");

	}

}

package SeleniumPrep.FullSeleniumFramework.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumPrep.FullSeleniumFramework.AbstractComponents.Utility;

public class CheckOut extends Utility {

	WebDriver driver;

	public CheckOut(WebDriver driver) {
		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "(//button[@class='btn btn-primary'])[4]")
	WebElement checkout;

	@FindBy(css = ".text-validated:nth-child(1)")
	WebElement country;

	@FindBy(css = ".action__submit")
	WebElement placeOrder;

	public Done check() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("scroll(0, 250)"); // if the element is on bottom.
		
		Thread.sleep(2000);

		checkout.click();

		country.sendKeys("ind");

		waits2();

		placeOrder.click();
		
		Done done = new Done(driver);
		
		return done;

	}

}

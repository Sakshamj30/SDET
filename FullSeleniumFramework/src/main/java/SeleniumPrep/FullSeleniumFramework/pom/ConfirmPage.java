package SeleniumPrep.FullSeleniumFramework.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import SeleniumPrep.FullSeleniumFramework.AbstractComponents.Utility;

public class ConfirmPage extends Utility {

	WebDriver driver;

	public ConfirmPage(WebDriver driver) {
		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "(//button[@class=\"btn btn-custom\"])[2]")
	WebElement orderhistory;

	public void verifyShopping(List Orders) {
		
		orderhistory.click();
		
		System.out.println("hi");

		List<WebElement> prod = driver.findElements(By.xpath("//tr[@class='ng-star-inserted']/td[2]"));

		for (int i = 0; i < prod.size(); i++) {

			WebElement e = prod.get(i);

			System.out.println(e.getText());

		}

	}

}

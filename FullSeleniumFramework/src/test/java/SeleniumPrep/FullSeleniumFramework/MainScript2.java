package SeleniumPrep.FullSeleniumFramework;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import SeleniumPrep.FullSeleniumFramework.pom.LoginPage;
import UtilityTest.Based;

public class MainScript2 extends Based{
	
	@Test
	public void main() throws InterruptedException {

		//WebDriver driver = new ChromeDriver();

		//driver.manage().window().maximize();

		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		// login

		LoginPage login = new LoginPage(driver);

		driver.get("https://rahulshettyacademy.com/client");

		driver.findElement(By.cssSelector("[type='email']")).sendKeys("sakshamjauhari23@gmail.com");

		driver.findElement(By.id("userPassword")).sendKeys("Saksham7571@");

		driver.findElement(By.xpath("//input[@id='login']")).click();

		// add products to cart

		List<String> orders = new ArrayList();

		orders.add("ADIDAS ORIGINAL");

		orders.add("ZARA COAT 3");

		List<WebElement> products = driver.findElements(By.xpath("//div[@class='card-body']/h5"));

		for (int i = 0; i < products.size(); i++) {

			WebElement e = products.get(i);

			int a = i + 1;

			if (orders.contains(e.getText())) {

				System.out.println(e.getText());

				driver.findElement(By.xpath("(//button[@class='btn w-10 rounded'])" + "[" + a + "]")).click();

				// wait for animation and toast and get text

				wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

				System.out.println(wait
						.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#toast-container"))))
						.getText());

			}

		}

		// click on cart

		driver.findElement(By.xpath("(//button[@class=\"btn btn-custom\"])[3]")).click();

		// check products are added as per user

		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));

		for (WebElement e : cartProducts) {

			Assert.assertTrue(orders.contains(e.getText()), "product added successfully");

		}

		// checkout

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("scroll(0, 250)"); // if the element is on bottom.

		Thread.sleep(2000);

		driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[4]")).click();

		driver.findElement(By.cssSelector(".text-validated:nth-child(1)")).sendKeys("ind");

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".ta-item:nth-child(3)"))))
				.click();

		driver.findElement(By.cssSelector(".action__submit")).click();

		Assert.assertEquals(driver.findElement(By.cssSelector(".hero-primary")).getText(), "THANKYOU FOR THE ORDER.");

		
		
		

	}
}

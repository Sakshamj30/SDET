package SeleniumPrep.FullSeleniumFramework.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Utility {

	WebDriver driver;

	public Utility(WebDriver driver) {

		this.driver = driver;

	}

	public void waits() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

		System.out.println(
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#toast-container"))))
						.getText());

	}

	public void waits2() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".ta-item:nth-child(3)"))))
				.click();
	}

	public void getReportObject() {

		ExtentSparkReporter reporter = new ExtentSparkReporter(
				"/Users/sakshamjauhari/Documents/workspace/ExtendReports/target/index.html");

		reporter.config().setReportName("Automation Results");
		reporter.config().setDocumentTitle("Report");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Saksham Jauhari");
	}

}

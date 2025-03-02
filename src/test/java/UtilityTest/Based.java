package UtilityTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import SeleniumPrep.FullSeleniumFramework.pom.LoginPage;

public class Based {

	public WebDriver driver;

	public WebDriver invokeBrowser() throws IOException {

		// prop class

		Properties prop = new Properties();

		FileInputStream fis = new FileInputStream(
				"/Users/sakshamjauhari/Documents/workspace/FullSeleniumFramework/src/main/java/globalProperties/GlobalProperties.properties");

		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;

	}

	@BeforeMethod
	public LoginPage launchApp() throws IOException {

		driver = invokeBrowser();
		LoginPage login = new LoginPage(driver);
		return login;
	}

	@AfterMethod
	public void tearDown() {

		driver.close();
	}
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot shot =  (TakesScreenshot)driver;
		File src = shot.getScreenshotAs(OutputType.FILE);
		File des = new File("/Users/sakshamjauhari/Documents/workspace/FullSeleniumFramework/reports/ss.png");
		FileUtils.copyFile(src, des);
		return "/Users/sakshamjauhari/Documents/workspace/FullSeleniumFramework/reports/ss.png";
		
	}

}

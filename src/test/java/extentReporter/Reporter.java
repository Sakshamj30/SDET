package extentReporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reporter {
	
	public static ExtentReports getReportObject() {

		ExtentSparkReporter reporter = new ExtentSparkReporter(
				"/Users/sakshamjauhari/Documents/workspace/FullSeleniumFramework/reports/index.html");

		reporter.config().setReportName("Automation Results");
		reporter.config().setDocumentTitle("Report");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Saksham Jauhari");
		return extent;
	}

}

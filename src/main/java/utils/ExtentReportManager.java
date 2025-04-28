package utils;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class ExtentReportManager {
	private static ExtentReports extent;
	private static ExtentTest test;

	public static ExtentReports getReportsInstance() {
		if (extent == null) {
			String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
			String reportPath = "reports/ExtentReport_" + timestamp + ".html";
			ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);

			reporter.config().setDocumentTitle("Automation Test Report");
			reporter.config().setDocumentTitle("Test Excecution Report");

			extent = new ExtentReports();
			extent.attachReporter(reporter);
		}

		return extent;
	}

	public static ExtentTest createTest(String testname) {

		test = getReportsInstance().createTest(testname);
		return test;

	}
	public static String captureScreenshot(WebDriver driver, String screenshotname){
		try {
			File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String path=System.getProperty("user.dir") +   "/screenshots/"+screenshotname+" .png";
			System.out.println("Path for screenshot is"+path);
			FileUtils.copyFile(src, new File(path));
			return path;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	}

package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager {
    private static ExtentReports extent;
    private static ExtentTest test;
    
    public static ExtentReports getReportsInstance() {
        if (extent == null) {
            String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
            String reportPath="reports/ExtentReport_"+timestamp+".html";
            ExtentSparkReporter reporter=new ExtentSparkReporter(reportPath);
       
            reporter.config().setDocumentTitle("Automation Test Report");
            reporter.config().setDocumentTitle("Test Excecution Report");
             
            extent = new ExtentReports();
            extent.attachReporter(reporter);
        }
        
        return extent;
    }
}

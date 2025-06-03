package pageObjects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
	public static ExtentReports getReportObject()
	
	{
		
		ExtentReports extent;
		ExtentSparkReporter sp;
		
		String path=System.getProperty("user.dir")+ "//Reports//report.html";
		sp=new ExtentSparkReporter(path);
		sp.config().setDocumentTitle("Automation Result");
		sp.config().setReportName("Automation Report");
		extent=new ExtentReports();
		extent.attachReporter(sp);
		return extent;
	}

}

package reports;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class ExtentManager {
	private static ExtentReports extent; //Creates one report object
   public static ExtentReports getReport() {
        if(extent == null) {

            ExtentSparkReporter spark =
                    new ExtentSparkReporter("target/ExtentReport.html"); //Create a Report

            spark.config().setReportName("OrangeHRM Automation Report"); //Heading
            spark.config().setDocumentTitle("Automation Execution Report"); //Broeser tab title

            extent = new ExtentReports();

            extent.attachReporter(spark); //connects the report with the HTML file.

            extent.setSystemInfo("Tester", "Dinoop");
            extent.setSystemInfo("Framework", "Selenium Java");
            extent.setSystemInfo("Browser", "Chrome");
        }
return extent;  //an class can use 
    }}

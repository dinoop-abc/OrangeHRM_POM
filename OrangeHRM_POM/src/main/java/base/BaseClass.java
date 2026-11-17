package base;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utilties.ConfigReader;
import utilties.ExcelReaderAdvance;
public class BaseClass {

	protected WebDriver driver; //LoginTest extends BaseClass,can directly use driver.No need to create another driver.
	protected ExcelReaderAdvance er;
	           // Open Excel once per test class
    @BeforeClass
    public void openExcel() throws Exception {
        er = new ExcelReaderAdvance();
        System.out.println("Excel workbook opened");
    }

	@BeforeMethod   // Launches a fresh browser before every test method
	public void setup()
	{
	driver = new ChromeDriver();
	
	      /*driver.manage().window().maximize();  //Load from config file
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");*/
	
	if(ConfigReader.getProperty("maximize").equals("true"))
	{
	    driver.manage().window().maximize();
	}
	int implicitWait = Integer.parseInt(
            ConfigReader.getProperty("implicitWait"));

    driver.manage().timeouts()
          .implicitlyWait(Duration.ofSeconds(implicitWait));
	driver.get(ConfigReader.getProperty("url"));
	}
	@AfterMethod(alwaysRun = true) //This tells TestNG to attempt browser cleanup even when a test or configuration method fails.
	public void tearDown()
	{
		if (driver != null) {
		      // Application logout
              //driver.findElement(By.id("logout")).click();  if we need to Log out application
	    driver.quit();
	    driver = null;
	}}
	 // Close Excel once per test class
    @AfterClass
    public void closeExcel() throws Exception {

        if (er != null) {
            er.closeWorkbook();
            System.out.println("Excel workbook closed");
        }
    }
              // Returns the WebDriver instance when required by other classes
	public WebDriver getDriver()
	{
	    return driver;
	}
	}

package base;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utilties.ConfigReader;  //for Reading data from config file
public class BaseClass {

	protected WebDriver driver;  //LoginTest extends BaseClass,can directly use driver.No need to create another driver.
	@BeforeMethod   //if we user before class then it execute before every test
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
	driver.manage().timeouts()
	      .implicitlyWait(Duration.ofSeconds(
	          Integer.parseInt(
	              ConfigReader.getProperty("implicitWait")
	          )));
	driver.get(ConfigReader.getProperty("url"));
	}
	@AfterMethod
	public void tearDown()
	{
		if (driver != null) {
		// Application logout
        //driver.findElement(By.id("logout")).click();  if we need to Log out application
	    driver.quit();
	}}
	public WebDriver getDriver()
	{
	    return driver;
	}
	}

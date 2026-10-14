package testcases;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import base.BaseClass;
import pages.LoginPage;
import pages.DashboardPage;
import listeners.TestListener;
import utilties.ExcelReader;
import utilties.ExcelReaderAdvance;
import org.apache.logging.log4j.Logger;
import utilties.LogUtil;


   @Listeners(TestListener.class)
  //@Listeners(listeners.TestListener.class)
public class LoginTest extends BaseClass {  //Because LoginTest needs driver,setip,teardown
	   private static final Logger log =
		        LogUtil.getLogger(LoginTest.class);
	   ExcelReaderAdvance er; //Create Ref Variable to call 3 method-Excel
	
	@BeforeClass       //Runs only ONCE before all test methods.it is for advance excel
    public void openExcel() throws Exception
    {
        // Constructor automatically opens Excel
        er = new ExcelReaderAdvance();  //constructor opens the workbook and selects the sheet
    }


	@Test(priority = 1)
	public void verifyBlankLogin() throws Exception
	{
		  log.info("Starting blank login test"); //Log4j checking
                //USING HARD CODE VALUE 
        /* LoginPage lp = new LoginPage(driver);
           lp.login("","");
        Assert.assertEquals(lp.getRequiredMessage(),"Required");*/
		                 //USING EXCEL-Basic(every time excel open and close)
		/* ExcelReader er = new ExcelReader(); // Create ExcelReader object
	     String[] data = er.getLoginData(1);   // Read Row 1 from Excel.// data[0] = Username, // data[1] = Password
	     LoginPage lp = new LoginPage(driver);
	     lp.login(data[0], data[1]); // Login using Excel data
	     Assert.assertEquals(lp.getRequiredMessage(),"Required");*/
		            //Using Excel-Advance(Only one time open and execute all method and close
		    String data[] = er.getLoginData(1);  // Read Row 1
            LoginPage lp = new LoginPage(driver);
            lp.login(data[0], data[1]); // Login using Excel values
            Assert.assertEquals(lp.getRequiredMessage(),"Required");
            log.info("Valid login test passed");

	}
	@Test(priority = 2)
	public void verifyWithoutPassword() throws Exception
	{
	    /*LoginPage lp = new LoginPage(driver);
         lp.login("Admin","");
         Assert.assertEquals(lp.getRequiredMessage(),"Required");*/
		          
		                       //USING EXCEL-Basic
	      /*ExcelReader er = new ExcelReader();
	     String[] data = er.getLoginData(2);// Read Row 2
	       LoginPage lp = new LoginPage(driver);
	       lp.login(data[0], data[1]);
	     Assert.assertEquals(lp.getRequiredMessage(),"Required");*/
		          
		                     //Using Excel advanced
                 String data[] = er.getLoginData(2); // Read Row 2
                 LoginPage lp = new LoginPage(driver);
                 lp.login(data[0], data[1]);
                 Assert.assertEquals(lp.getRequiredMessage(),"Required");
	     }
	@Test(priority = 3)
	public void verifyValidLogin() throws Exception
	{
	    /*LoginPage lp = new LoginPage(driver); //When @BeforeMethod opens a new browser, we create a new LoginPage object for that browser. This avoids sharing stale page objects between tests and keeps each test isolated.
         lp.login("Admin","admin123");
        //Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
	    DashboardPage dashboard=new DashboardPage(driver);
        Assert.assertTrue(dashboard.isDashboardDisplayed()); //Header displayed check*/
               //USING DATA FROM EXCEL-Basic(every time excel open and close)
                  /*ExcelReader er = new ExcelReader();
                  String[] data = er.getLoginData(3);// Read Row 3
                  LoginPage lp = new LoginPage(driver);
                  lp.login(data[0], data[1]);
                  DashboardPage dashboard = new DashboardPage(driver);
                  Assert.assertTrue(dashboard.isDashboardDisplayed());*/
	     
	                            //Using Excel-advance
	                       String data[] = er.getLoginData(3);
                           LoginPage lp = new LoginPage(driver);
                           lp.login(data[0], data[1]);
                           DashboardPage dashboard = new DashboardPage(driver);
                           Assert.assertTrue(dashboard.isDashboardDisplayed());
	}
	@AfterClass(alwaysRun = true)  //Runs once after all test methods

    public void closeExcel() throws Exception
    {
		if (er != null) {            //avoids a NullPointerException if Excel initialization did not complete.
	        er.closeWorkbook();      // Close workbook only once
    }}}

package testcases;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
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
import pages.SkillsPage;
import utilties.TestData;
import pages.NavigationPage;

import utilties.CommonMethods;
@Listeners(TestListener.class)
public class SkillsTest extends BaseClass {
	private static final Logger log =LogUtil.getLogger(SkillsTest.class);
	 NavigationPage navigation;
	 SkillsPage skills;
	  @BeforeMethod
	 public void loginAndNavigateToSkills() throws Exception {
            //String[] data = er.getLoginData(3);    // Login using Excel data
           //CommonMethods.validLogin(driver, data[0], data[1]);
		   // Common login method
		    CommonMethods.login(driver,er);

		           // Navigate to Skills page
	        navigation = new NavigationPage(driver);
	        navigation.navigateToSkills();

	        // Create Skills page object
	        skills = new SkillsPage(driver);

		    log.info("Successfully navigated to Skills page");
		}
	                // Scenario 1: Mandatory Required validation
	 @Test(priority = 1)
	 public void verifyRequiredValidation() throws Exception {

	     String[] data = er.getSkillData(1); //reads data from the SkillData sheet.stores the returned values in a String array.
         skills.clickAddButton();
	     log.info("Clicked Add button");
	     skills.clickSaveButton();
                             /*
                              data[0] = "Mandatory validation";
                               data[1] = "";
                               data[2] = "";
                                data[3] = "Required";*/
  
	     Assert.assertEquals(
	         skills.getRequiredMessage(),
	         data[3]
	     );
	     log.info("Mandatory Validation OK");
	 }
	          // Scenario 2: Duplicate skill Validation
	 @Test(priority = 2)
	 public void verifyDuplicateSkill() throws Exception {
		 
		 String[] data = er.getSkillData(2); //the third Excel row, because Java array/row indexing starts from 0 in our code.

	     log.info("Skill Name: " + data[1]);
	     log.info("Description: " + data[2]);
	     skills.clickAddButton();

	    skills.addSkill(data[1], data[2]);
	     log.info("Skill details entered");

	     Assert.assertEquals(
	         skills.getAlreadyExistMessage(),
	         data[3]
	     );
	     log.info("Duplication validation OK");
	 }
	                              // Scenario 3: Add New Skill
	 @Test(priority = 3)
	 public void verifyAddNewSkill() throws Exception {
		
	     String[] data = er.getSkillData(3);
          skills.clickAddButton();
        //skills.addSkill(data[1], data[2]);  IT is OK if no need Random Name issue
	     // Excel name + Random number
String skillName = TestData.uniqueSkillName(data[1]); //Calls the method and passes Excel data

	     skills.addSkill(skillName, data[2]);  //addSkill is a method

	     log.info("New skill created: " + skillName);

	     Assert.assertTrue(skills.verifySkillsUrl(),"Skills URL validation failed");
	     log.info("New Entry OK");
	 }
	
}

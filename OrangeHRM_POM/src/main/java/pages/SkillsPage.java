package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilties.WaitUtil;

public class SkillsPage {
	 private WebDriver driver;
	    WaitUtil wait;

	    // Constructor
	    public SkillsPage(WebDriver driver) {

	        this.driver = driver;

	        PageFactory.initElements(driver, this);

	        wait = new WaitUtil(driver);
	    }

	    

	    

	    

	    // Add button
	    @FindBy(xpath = "//button[normalize-space()='Add']")
	    private WebElement addButton;

	    // Name field
	    @FindBy(xpath = "//label[normalize-space()='Name']/ancestor::div[contains(@class,'oxd-input-group')]//input")
	    private WebElement name;

	    // Description field
	    @FindBy(xpath = "//textarea[@placeholder='Type description here']")
	    private WebElement description;

	    // Save button
	    @FindBy(xpath = "//button[@type='submit' and normalize-space()='Save']")
	    private WebElement submit;

	    // Toaster message
	    @FindBy(xpath = "//p[contains(@class,'oxd-text--toast-message')]")
	    private WebElement toastermessage;

	    // Required message against Name
	    @FindBy(xpath = "//label[normalize-space()='Name']/ancestor::div[contains(@class,'oxd-input-group')]//span[normalize-space()='Required']")
	    private WebElement requiredMsg;

	    // Already exists message against Name
	    @FindBy(xpath = "//label[normalize-space()='Name']/ancestor::div[contains(@class,'oxd-input-group')]//span[normalize-space()='Already exists']")
	    private WebElement alreadyExistMsg;

           // Click Add Button
	    public void clickAddButton() {

	        wait.waitForClick(addButton).click();
	    }

	    // Enter Name
	    public void enterName(String skillName) {

	        wait.waitForVisibility(name).clear();

	        name.sendKeys(skillName);
	    }

	    // Enter Description
	    public void enterDescription(String skillDescription) {

	        wait.waitForVisibility(description).clear();

	        description.sendKeys(skillDescription);
	    }

	    // Click Save
	    public void clickSaveButton() {

	        wait.waitForClick(submit).click();
	    }

	    // Get Required message
	    public String getRequiredMessage() {

	        return wait.waitForVisibility(requiredMsg).getText();
	    }

	    // Get Already exists message
	    public String getAlreadyExistMessage() {

	        return wait.waitForVisibility(alreadyExistMsg).getText();
	    }

	    // Get Toaster message
	    public String getToasterMessage() {

	        return wait.waitForVisibility(toastermessage).getText();
	    }

	    // Wait until URL contains viewSkills
	    public boolean verifySkillsUrl() {

	        return wait.waitForUrlContains("viewSkills");
	    }
	 // Combined method to add skill
	    public void addSkill(String skillName, String skillDescription) {

	       enterName(skillName);

	        enterDescription(skillDescription);

	        clickSaveButton();
	    }

	}

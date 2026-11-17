package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilties.WaitUtil;
public class NavigationPage {

	private WebDriver driver;
    private WaitUtil wait;
    // Constructor
    public NavigationPage(WebDriver driver) {
     this.driver = driver;
     PageFactory.initElements(driver, this);
     wait = new WaitUtil(driver);
    }

    // Admin menu Locator
    @FindBy(xpath = "//*[@role='link' or self::a][normalize-space()='Admin']")
    private WebElement adminLink;

    // Qualifications menu Locator
    @FindBy(xpath = "//*[normalize-space(.)='Qualifications']")
    private WebElement qualificationLink;

    // Skills menu Locator
    @FindBy(xpath = "//*[@role='menuitem' or self::*][normalize-space()='Skills']")
    private WebElement skillLink;


          // Click Admin Menu
    public void clickAdminMenu() {

        wait.waitForClick(adminLink).click();
    }

       // Click Qualifications subMenu
    public void clickQualificationLink() {

        wait.waitForClick(qualificationLink).click();
    }

        // Click Skills submenu
    public void clickSkillsLink() {

        wait.waitForClick(skillLink).click();
    }


    // Combined method to navigate to Skills page
    public void navigateToSkills() {

        clickAdminMenu();

        clickQualificationLink();

        clickSkillsLink();
    }
}

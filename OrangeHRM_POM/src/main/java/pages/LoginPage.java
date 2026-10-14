package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilties.WaitUtil;
public class LoginPage {
	private WebDriver driver;    //Every page needs the browser.
	WaitUtil wait; //for explicit wait

    public LoginPage(WebDriver driver) //constructor
    {
 this.driver = driver;//Suppose BaseClass has driver = new ChromeDriver();That browser is passed to LoginPage.stores that browser inside LoginPage
 PageFactory.initElements(driver, this); //This scans every @FindBy in the class & Find element
 wait = new WaitUtil(driver);       //for explicit wait
    }

    @FindBy(name="username")    //@FindBy tells PageFactory where the elements are.
    private WebElement txtUsername;

    @FindBy(name="password")
    private WebElement txtPassword;

    @FindBy(css="button[type='submit']")
    private WebElement btnLogin;

    @FindBy(xpath="//span[text()='Required']")
    private WebElement requiredMessage;
    @FindBy(xpath="//p[contains(text(),'Invalid')]")
    private WebElement invalidCredentialMessage;

    public void enterUsername(String username)
    {
    	 wait.waitForVisibility(txtUsername).clear();
        txtUsername.sendKeys(username);
       
    }
     public void enterPassword(String password)
    {
        wait.waitForVisibility(txtPassword).clear();
        txtPassword.sendKeys(password);
    }
    public void clickLogin()
    {
    	wait.waitForClick(btnLogin).click();
    }

    public void login(String username, String password)
    {
    	enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
 
    public String getRequiredMessage()
    {
        return requiredMessage.getText();
        //return wait.waitForVisibility(requiredMessage).getText();  //With Wait element
    }

    public String getInvalidCredentialMessage()
    {
        return invalidCredentialMessage.getText();
        //aded a New Line. fdfdfdf
        //g
    }

}

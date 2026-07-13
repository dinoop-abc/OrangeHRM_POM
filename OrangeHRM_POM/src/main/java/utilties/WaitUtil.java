package utilties;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class WaitUtil {
	private WebDriverWait wait;

    public WaitUtil(WebDriver driver)
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(
                Integer.parseInt(
                        ConfigReader.getProperty("explicitWait") //Take from conig file(10 second)
                )));
    }

    public WebElement waitForVisibility(WebElement element)
    {
        return wait.until(
                ExpectedConditions.visibilityOf(element));
    }
    public WebElement waitForClick(WebElement element)
    {
        return wait.until(
                ExpectedConditions.elementToBeClickable(element));
    }}

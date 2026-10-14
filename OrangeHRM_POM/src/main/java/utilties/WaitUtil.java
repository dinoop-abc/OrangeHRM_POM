package utilties;
import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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
      //  1. Wait until element is visible
    public WebElement waitForVisibility(WebElement element)
    {
        return wait.until(
                ExpectedConditions.visibilityOf(element));
    }
    // 2. Wait until element is clickable
    public WebElement waitForClick(WebElement element)
    {
        return wait.until(
                ExpectedConditions.elementToBeClickable(element));
    }
 // 3. Wait until element exists in the DOM
    public WebElement waitForPresence(By locator) {
        return wait.until(
            ExpectedConditions.presenceOfElementLocated(locator));
    }
 // 4. Wait until element becomes invisible
    public boolean waitForInvisibility(WebElement element) {
        return wait.until(
            ExpectedConditions.invisibilityOf(element));
    }
    // 5. Wait until expected text appears
    public boolean waitForText(WebElement element, String text) {
        return wait.until(
            ExpectedConditions.textToBePresentInElement(
                element, text));
    }
 // 7. Wait until alert appears
    public Alert waitForAlert() {
        return wait.until(
            ExpectedConditions.alertIsPresent());
    }
    // 10. Wait until page title contains expected text
    public boolean waitForTitle(String title) {
        return wait.until(
            ExpectedConditions.titleContains(title));
    }

    }

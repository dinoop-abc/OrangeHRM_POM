package utilties;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.google.common.io.Files;
public class ScreenshotUtil {
	public static void capture(WebDriver driver, String testName) {

		String timeStamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

        File src = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        File dest = new File("Screenshots/" +
                testName + "_" + timeStamp + ".png");

        try {
            Files.copy(src, dest);
            System.out.println("Screenshot saved: " + dest.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

package utilties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;
import pages.DashboardPage;
import utilties.ExcelReaderAdvance;
import org.openqa.selenium.WebDriver;
public class CommonMethods {
public static void validLogin(WebDriver driver, String username, String password) { //it is static, you can call it directly using the class name.

        LoginPage lp = new LoginPage(driver);  //Create Login page Object.passing the existing browser instance to LoginPage
        lp.login(username, password);    //This calls the login() method inside your LoginPage class.

        DashboardPage dashboard = new DashboardPage(driver);

        Assert.assertTrue(
            dashboard.isDashboardDisplayed(),
            "Login failed - Dashboard not displayed"
        );
    }

public static void login(WebDriver driver ,ExcelReaderAdvance er) throws Exception {
// Read valid login details from Excel
        String[] data = er.getLoginData(3);             //Reads login details from row 3
         // Perform login
        validLogin(driver, data[0], data[1]);
}}


/*
 * 1)രണ്ട് reusable methods ആണ് ഉള്ളത്.validLogin() – Login ചെയ്യാനും Dashboard verify ചെയ്യാനും login() – Excel-ൽ നിന്ന് username/password വായിച്ച് validLogin() വിളിക്കാനും
2)Valid login മൂന്ന് parameters സ്വീകരിക്കുന്നു. WebDriver driver നിലവിലുള്ള browser instance,uname,pwd
3)static ആയതിനാൽ object create ചെയ്യാതെ class name ഉപയോഗിച്ച് വിളിക്കാം
4)LoginPage object create ചെയ്യുന്നു->നിലവിലുള്ള Chrome browser instance LoginPage-ലേക്ക് pass ചെയ്യുന്നു.
5)ഇത് LoginPage class-ലെ login() method execute ചെയ്യുന്നു
6)Login കഴിഞ്ഞ് Dashboard page-ന്റെ methods ഉപയോഗിക്കാനായി object create ചെയ്യുന്നു.
7)second method 2 parametere pass.driver – നിലവിലുള്ള browser,er – BaseClass-ൽ നിന്ന് ലഭിക്കുന്ന ExcelReader object.
8)Excel-ൽ നിന്ന് data വായിക്കുന്നു->Excel-ലെ മൂന്നാമത്തെ data row-ൽ നിന്ന് login details വായിക്കുന്നു.
9)ഇവിടെ Excel-ൽ നിന്ന് കിട്ടിയ username, password എന്നിവ validLogin() method-ലേക്ക് pass ചെയ്യുന്നു.
10)skill test pagil->Call CommonMethods.login(driver, er);
ഓർക്കാൻ ഒരു എളുപ്പവഴി:
- login() = Excel-ൽ നിന്ന് data എടുക്കുന്നു.
- validLogin() = ആ data ഉപയോഗിച്ച് login ചെയ്യുന്നു.
- LoginPage = Login action ചെയ്യുന്നു.
- DashboardPage = Login success verify ചെയ്യുന്നു.
- BaseClass = Excel open/close ചെയ്യുന്നു.
 */

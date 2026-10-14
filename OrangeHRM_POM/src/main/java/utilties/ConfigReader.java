package utilties;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class ConfigReader {
	static Properties prop;   //Creates one Properties object.

    static
    {
        try
        {
            FileInputStream fis =
                    new FileInputStream("src/test/resources/config.properties");

            prop = new Properties();

            prop.load(fis);   //Read everything from file and Store inside Properties object

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key)  //Get a value from another class
    {
        return prop.getProperty(key); //sends that value back to the calling code.
    }

}

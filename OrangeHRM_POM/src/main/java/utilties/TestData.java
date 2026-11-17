package utilties;
import java.util.UUID;

public class TestData {

	 public static String uniqueFirstName() {
	        return "Dinoop" + System.currentTimeMillis();
	    }

	    public static String uniqueUsername() {
	        return "user" + System.currentTimeMillis();
	    }

	    public static String uniqueEmail() {
	        return "user" + System.currentTimeMillis()
	                + "@gmail.com";
	    }

	    public static String uniqueEmployeeId() {
	        return UUID.randomUUID()
	                .toString()
	                .substring(0, 8);
	    }

	    // Generate unique skill name
	    public static String uniqueSkillName() {
	        return "Skill" + System.currentTimeMillis();
	    }
	    public static String uniqueSkillName(String skillName) {

	        return skillName + System.currentTimeMillis();
	    }
	
}

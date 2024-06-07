package Common_Utilities;

import java.util.Random;

public class JavaUtility {
	public int generateRandomNo() {
		Random rsn = new Random();
		int random = rsn.nextInt();
		return random;
	}

}

package Common_Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {
	
	/**
	 * this method will resd data from properties file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String toReadDataFromPropeetyFile(String key) throws IOException{
		FileInputStream fis= new FileInputStream(Iconstant_Utility.propertyFile);
		Properties prop= new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;
	}

}

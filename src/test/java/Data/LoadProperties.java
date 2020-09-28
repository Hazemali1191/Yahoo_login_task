package Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties 
{

	public static final String PROFILEPATH = "./userdata.properties";
	public static String getValue(String key) throws Exception
	{
		File file = new File(PROFILEPATH);
		FileInputStream fis = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fis);

		return prop.getProperty(key);
	}


}

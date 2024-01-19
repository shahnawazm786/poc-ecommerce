package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesRead {
	static String value=null;
	static Properties prop;
	public static String getData(String key) {
		try {
		prop=new Properties();
		prop.load(new FileInputStream("src/test/resources/"+Constant.PROPERTIES_FILE_NAME));
		value = prop.getProperty(key);
		return value;
		}catch(Exception ex) {
			prop.clear();
			prop=null;
			ex.printStackTrace();
		}
		finally {
			prop.clear();
			prop=null;
		}
		return value;
	}
}

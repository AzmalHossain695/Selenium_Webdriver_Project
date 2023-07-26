package utilities;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;
import java.io.IOException;

public class ConfigDataUtills {
	private static String browserName;
	private static String arg1;
	private static String arg2;
	private static String arg3;
	private static String url;
	private static int wait1;
	static {
		try {
			FileReader reader = new FileReader(".\\src\\test\\resources\\configfiles\\configdata.json");
			JsonObject config = JsonParser.parseReader(reader).getAsJsonObject();
			browserName = config.get("browser").getAsString();
			arg1 = config.get("arg1").getAsString();
			arg2 = config.get("arg2").getAsString();
			arg3 = config.get("arg3").getAsString();
			url = config.get("url").getAsString();
			wait1 = config.get("wait1").getAsInt();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String getBrowsername() {
		return browserName;
	}
	public static String getArg1() {
		return arg1;
	}
	public static String getArg2() {
		return arg2;
	}
	public static String getArg3() {
		return arg3;
	}
	public static String getUrl() {
		return url;
	}
	public static int getWait1() {
		return wait1;
	}
}

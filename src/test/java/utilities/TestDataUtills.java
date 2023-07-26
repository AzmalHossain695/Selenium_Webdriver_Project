package utilities;

import java.io.FileReader;
import java.io.IOException;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.List;
import java.util.ArrayList;

public class TestDataUtills {	
	private static String year;
	private static String gameName;
	private static String expected1;
	private static List<String> languagesList;
	
	static {
		try {
			FileReader reader = new FileReader(".\\src\\test\\resources\\testdatafiles\\testdata.json");
			JsonObject testdata = JsonParser.parseReader(reader).getAsJsonObject();
			JsonArray languagesArray = testdata.getAsJsonArray("languages");
			languagesList = new ArrayList<String>();
			for (JsonElement language : languagesArray) {
			    languagesList.add(language.getAsString());
			}
			year = testdata.get("year").getAsString();
			gameName = testdata.get("gamename").getAsString();
			expected1 = testdata.get("expected1").getAsString();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String getYear() {
		return year;
	}
	public static String getGameName() {
		return gameName;
	}
	public static String getExpected1() {
		return expected1;
	}
	public static List<String> getLanguagesList() {
		return languagesList;
	}
}

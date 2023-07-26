package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ConfigDataUtills;

public class BrowserFactory {
	private static ChromeOptions options1;
	private static FirefoxOptions options2;
	private static String browserName;
	private static String arg1;
	private static String arg2;
	private static String arg3;

	static {
		options1 = new ChromeOptions();
		options2 = new FirefoxOptions();
		browserName = ConfigDataUtills.getBrowsername();
		arg1 = ConfigDataUtills.getArg1();
		arg2 = ConfigDataUtills.getArg2();
		arg3 = ConfigDataUtills.getArg3();

		switch (browserName) {
		case "chrome":
			options1.addArguments(arg1);
			options1.addArguments(arg2);
			break;
		case "firefox":
			options2.addArguments(arg3);
		default:
			System.out.println("Invalid Browser Name");				
		} 
	}
	public static ChromeOptions getOptions1() {
		return options1;
	}
	public static FirefoxOptions getOptions2() {
		return options2;
	}
	public static WebDriver getDriver() {
		switch (browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			return new ChromeDriver(options1);
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			return new FirefoxDriver(options2);
		
		default:
			System.err.println("Invalid browser name");
			return null;
		}
	}
}

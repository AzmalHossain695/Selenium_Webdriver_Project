package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import base.DriverFactory;

public class JavascriptsMethods {	
	WebDriver driver;
	
	public void scrolling() {		
		driver = DriverFactory.getInstance();
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
}

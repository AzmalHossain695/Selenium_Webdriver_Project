package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

import base.DriverFactory;

public class BrowserWindowHandler {
	private WebDriver driver;
	public BrowserWindowHandler() throws IOException {
		driver = DriverFactory.getInstance();
	}
	public void windowCheck() {
		String currentWindowHandler = driver.getWindowHandle();		
		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(currentWindowHandler)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(null));
	}	
}

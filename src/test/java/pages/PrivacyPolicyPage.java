package pages;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.DriverFactory;
import utilities.ConfigDataUtills;
import utilities.TestDataUtills;
import java.util.ArrayList;
import java.util.List;

public class PrivacyPolicyPage {
	WebDriver driver;
	WebElement privacyPolicyLink;
	private static int wait1;
	private static String year;
	private static List<String> flagUrls;
	private static List<String> languagesList;	
	private By languageLinksLocator = By.xpath("//div[@id='languages']//a");
	private By flagimgLocator = By.tagName("img");
	private By languageIdLocator = By.id("languages");
	private By privacyPolicyLinkLocator = By.linkText("Privacy Policy");
	private By RevisionDateLocator = By.cssSelector("#newsColumn > i:nth-child(198)");
	
	public PrivacyPolicyPage() throws IOException {
		driver = DriverFactory.getInstance();
	}
	public void openPrivacyPolicy() {
		WebElement privacyPolicyLink = driver.findElement(privacyPolicyLinkLocator);
		privacyPolicyLink.click();
	}
	public boolean IsPrivacyPolicyPresent() {
		wait1 = ConfigDataUtills.getWait1();		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(wait1));
		WebElement privacyPolicyLink = wait.until(ExpectedConditions.elementToBeClickable(privacyPolicyLinkLocator));
		return privacyPolicyLink.isDisplayed();
	}
	public boolean RevisionSignedRecently() {		
		year = TestDataUtills.getYear();
		WebElement revisionDate = driver.findElement(RevisionDateLocator);
		String Revisiondate = revisionDate.getText();
		return Revisiondate.contains(year);		
	}
	public boolean LanguageElementsDisplayed() {
		WebElement switchLanguage = driver.findElement(languageIdLocator);
		return switchLanguage.isDisplayed();
	}
	public boolean checkAllLanguages() {
		flagUrls = new ArrayList<String>();
		languagesList = TestDataUtills.getLanguagesList();
		List<WebElement> languageLinks = driver.findElements(languageLinksLocator);
		for (WebElement languageLink : languageLinks) {
		    WebElement flagImg = languageLink.findElement(flagimgLocator);
		    String flagUrl = flagImg.getAttribute("src");		    
		    String[] parts = flagUrl.split("/");
		    flagUrls.add(parts[parts.length - 1]);
		}
		boolean loopCompleted = true;
		for (String language : languagesList) {
		    if (!flagUrls.contains(language + ".gif")) {
		    	loopCompleted = false;
		        break;
		    }
		}
		return loopCompleted;
	}	
}

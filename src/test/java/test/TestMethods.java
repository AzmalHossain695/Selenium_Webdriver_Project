package test;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.BrowserWindowHandler;
import pages.PrivacyPolicyPage;
import utilities.ConfigDataUtills;
import base.DriverFactory;
import utilities.JavascriptsMethods;
import utilities.TestDataUtills;
public class TestMethods {
	WebDriver driver;
	private static String url =  ConfigDataUtills.getUrl();
	private static String gameName = TestDataUtills.getGameName();
	private static String expected1 = TestDataUtills.getExpected1();
	
	@BeforeMethod
	public void startUp() throws IOException {
		driver = DriverFactory.getInstance();
		driver.manage().window().maximize();
		driver.get(url);
	}
	@Test
	public void PrivacyPolicyTest() throws IOException {
		MainPage MainPage = new MainPage();
		PrivacyPolicyPage privacyPolicy = new PrivacyPolicyPage();
		BrowserWindowHandler browser = new BrowserWindowHandler();
		JavascriptsMethods javascript = new JavascriptsMethods();

		Assert.assertTrue(MainPage.MainPageisDisplayed(), "Main page not found");
		javascript.scrolling();
		privacyPolicy.openPrivacyPolicy();
		browser.windowCheck();		
		
		Assert.assertTrue(privacyPolicy.IsPrivacyPolicyPresent(), "Privacy Policy not found");
		Assert.assertTrue(privacyPolicy.LanguageElementsDisplayed(), "Switch Language elements List not Displayed");
		Assert.assertTrue(privacyPolicy.RevisionSignedRecently(), "Revision not signed in recent years");
		Assert.assertTrue(privacyPolicy.checkAllLanguages(), "All languages are not included in the languages");
	}
	@Test
	public void GameSearch() throws IOException  {
		MainPage theMainPage = new MainPage();
		theMainPage.search(gameName);
		String actualTitle = theMainPage.searchBoxText();
		Assert.assertEquals(expected1, actualTitle, "Search Box on result page does not contain Dota 2");
		
		theMainPage.searchResults1();
		String firstName = theMainPage.getFirstNameOfList();
		Assert.assertEquals(expected1, firstName, "The first name is not equal to searched name");
		
		String secondName = theMainPage.getSecondNameOfList();
		theMainPage.search(secondName);
		String searchboxTitle = theMainPage.searchBoxText();
		Assert.assertEquals(secondName, searchboxTitle, "Search Box on result page does not contain the second name");
		
		theMainPage.searchResults2();
		Assert.assertTrue(theMainPage.compareSearchResults(), "Result list does not contain 2 stored items from the previous search");
	}

	@AfterMethod
	public void quitBrowser() {		
		driver.quit();
	}

}

package pages;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import base.DriverFactory;

public class MainPage {
	WebDriver driver;
	private static List<String> titleValues1;
	private static List<String> titleValues2;
	private By loginButtonLocator = By.xpath("//a[@class='global_action_link']");
	private By searchBarLocator = By.id("store_nav_search_term");
	private By searchButtonLocator = By.cssSelector("#store_search_link > img");
	private By searchBoxTextLocator = By.id("term");
	private By searchResultsContainerLocator = By.id("search_result_container");
	private By searchResultsTitlesLocator = By.className("title");
	
	public MainPage() throws IOException {
		driver = DriverFactory.getInstance();
	}
	public boolean MainPageisDisplayed() throws NoSuchElementException {
		WebElement loginbutton = driver.findElement(loginButtonLocator);
		return loginbutton.isDisplayed();
	}
	public void search(String keys) {
		driver.findElement(searchBarLocator).sendKeys(keys);
		driver.findElement(searchButtonLocator).click();
	}
	public String searchBoxText() {
		return driver.findElement(searchBoxTextLocator).getAttribute("value");
	}	
	public void searchResults1() {
		WebElement resultsContainer1 = driver.findElement(searchResultsContainerLocator);
		List <WebElement> titles1 = resultsContainer1.findElements(searchResultsTitlesLocator);
		titleValues1 = new ArrayList<>();
		for (WebElement titleElement : titles1) {
		    titleValues1.add(titleElement.getText());
		}		
	}	
	public String getFirstNameOfList() {
		return titleValues1.get(0);
	}
	public String getSecondNameOfList() {
		return titleValues1.get(1);
	}	
	public void searchResults2() {
		WebElement resultsContainer2 = driver.findElement(searchResultsContainerLocator);
		List <WebElement> titles2 = resultsContainer2.findElements(searchResultsTitlesLocator);
		titleValues2 = new ArrayList<>();
		for (WebElement titleElement : titles2) {
		    titleValues2.add(titleElement.getText());
		}		
	}
	public boolean compareSearchResults() {
		if (titleValues1.contains(titleValues2.get(0)) && titleValues1.contains(titleValues2.get(1)) ) {
			return true;
		}
		else {
		return false;
		}
	}
}

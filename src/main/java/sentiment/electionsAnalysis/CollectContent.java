package sentiment.electionsAnalysis;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CollectContent {

	public enum State {
		California, Virginia, Texas, Georgia
	}
	
	public static void main(String[] args) {

		/*System.setProperty("webdriver.chrome.driver", "/Users/amy/Downloads/chromedriver_mac_arm64/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.get("https://google.com");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		String cssOfInputField = "input[name='q']";

		WebElement inputFieldQ = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssOfInputField)));

		inputFieldQ.sendKeys("before:2023 after: 2020 \"texas\" democrat candidate midterm news" + Keys.ENTER);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<WebElement> resultEntries = driver.findElements(By.className("yuRUbf").tagName("a"));
		
		TextRetrieveProcess process = new TextRetrieveProcess();
		List<String> filteredData = process.filterDataset(resultEntries);
		System.out.println(filteredData.size());
		//process.writeToFile(filteredData);


		System.out.println("wait here");

		//driver.close();
		//driver.quit();*/
		
	 	TextRetrieveProcess process = new TextRetrieveProcess();
		
		String[][] data = new String[272][2];
		
		process.readFile("VirginiaRepublicanArticleLinks.txt", data);
		process.assignScore(data);
		
	}

}
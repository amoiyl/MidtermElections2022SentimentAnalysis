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

		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "/Users/amy/Downloads/chromedriver_mac_arm64/chromedriver"); WebDriver driver
		 * = new ChromeDriver();
		 * 
		 * driver.get("https://google.com");
		 * 
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 * 
		 * String cssOfInputField = "input[name='q']";
		 * 
		 * WebElement inputFieldQ =
		 * wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
		 * cssOfInputField)));
		 * 
		 * inputFieldQ.
		 * sendKeys("before:2023 after: 2020 \"texas\" democrat candidate midterm news"
		 * + Keys.ENTER);
		 * 
		 * try { Thread.sleep(1000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * 
		 * List<WebElement> resultEntries =
		 * driver.findElements(By.className("yuRUbf").tagName("a"));
		 * 
		 * TextRetrieveProcess process = new TextRetrieveProcess(); List<String>
		 * filteredData = process.filterDataset(resultEntries);
		 * System.out.println(filteredData.size()); //process.writeToFile(filteredData);
		 * 
		 * 
		 * System.out.println("wait here");
		 * 
		 * //driver.close(); //driver.quit();
		 */

		TextRetrieveProcess process = new TextRetrieveProcess();

		// String[][] data = new String[272][2];

		/*
		 * process.readFile("VirginiaRepublicanArticleLinks.txt", data);
		 * process.assignScore(data);
		 */
		double[] data = { 0.86, 0.903, 0.866, 0.884, 0.858, 0.92, 0.832, 0.861, 0.94, 0.94, 0.852, 0.821, 0.819, 0.851,
				0.851, 0.918, 0.83, 0.849, 0.945, 0.793, 0.845, 0.767, 0.926, 0.872, 0.817, 1.0, 0.884, 0.85, 0.829,
				0.887, 0.849, 0.904, 0.845, 0.846, 0.843, 0.917, 0.937, 0.937, 0.828, 0.85, 0.849, 0.837, 0.848, 0.849,
				0.839, 0.827, 0.835, 0.803, 0.909, 0.909, 0.806, 0.845, 0.901, 0.846, 0.867, 0.827, 0.843, 1.0, 0.887,
				0.891, 0.734, 0.858, 0.866, 0.891, 0.928, 0.907, 0.807, 0.86, 0.908, 0.846, 0.906, 0.849, 0.9, 0.899,
				0.845, 0.93, 0.925, 0.862, 0.847, 0.831, 0.86, 0.836, 0.867, 0.914, 0.852, 0.83, 0.802, 0.91, 0.896,
				0.87, 0.887, 0.861, 0.861, 0.856, 0.849, 0.847, 0.826, 0.799, 0.821, 0.868, 0.814, 0.903, 0.863, 0.896,
				0.861, 0.89, 0.848, 0.861, 0.9, 0.874, 0.859, 0.898, 0.848, 0.915, 0.904, 0.831, 0.826, 0.833, 0.867,
				0.849, 0.825, 0.85, 0.796, 0.821, 0.885, 0.862, 0.839, 0.866, 0.811, 0.791, 0.936, 0.904, 0.883,
				0.843 };
		double[] processed = process.calculateAverage(data);
		System.out.println(processed[0] + ", " + processed[1] + ", " + processed[2]);

	}

}
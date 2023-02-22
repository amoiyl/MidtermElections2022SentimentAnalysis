package sentiment.electionsAnalysis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.WebElement;

import com.vader.sentiment.analyzer.SentimentAnalyzer;
import com.vader.sentiment.analyzer.SentimentPolarities;

public class TextRetrieveProcess {
	public TextRetrieveProcess() {

	}

	public static void assignScore(String[][] data) {
		try {
			FileWriter writerPos = new FileWriter("RepublicanDemocratPosScores.txt");
			FileWriter writerNeg = new FileWriter("RepublicanDemocratNegScores.txt");
			FileWriter writerNeu = new FileWriter("RepublicanDemocratNeuScores.txt");

			for (int i = 0; i < data.length; i++) {
				if (data[i][1] != null) {
					final SentimentPolarities sentimentPolarities = SentimentAnalyzer.getScoresFor(data[i][1]);
					writerPos.write(
							sentimentPolarities.getPositivePolarity() + ",");
					writerPos.write(System.getProperty("line.separator"));
					
					writerNeg.write(
							sentimentPolarities.getNegativePolarity() + ",");
					writerNeg.write(System.getProperty("line.separator"));
					
					writerNeu.write(
							sentimentPolarities.getNeutralPolarity() + ",");
					writerNeu.write(System.getProperty("line.separator"));
				}
			}

			writerPos.close();
			writerNeg.close();
			writerNeu.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		System.out.println("done");

	}

	public static void readFile(String file, String[][] data) {
		int counter = 0;
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));

			for (int i = 0; i < data.length; i++) {
				String rawurl = in.readLine();
				String url = rawurl.replace(",", "");

				try {
					Document doc = Jsoup.connect(url).get();
					data[i][0] = doc.title();
					data[i][1] = doc.text();
					System.out.println("done " + i);
				} catch (Exception ex) {
					continue;
				}
			}
			in.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public static void writeToFile(List<String> urls) {
		try {
			FileWriter writer = new FileWriter("TexasDemocratArticleLinks.txt");

			for (String url : urls) {
				writer.write(url + ", ");
				writer.write(System.getProperty("line.separator"));
			}

			writer.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

	public static List<String> filterDataset(List<WebElement> rawData) {

		List<WebElement> filteredData = new ArrayList<WebElement>();
		List<String> filteredStringData = new ArrayList<String>();

		for (int index = 0; index < rawData.size(); index++) {
			if (rawData.get(index) == null) {
				continue;
			}

			try {
				if (rawData.get(index).getAttribute("href") == null) {
					continue;
				}

				if (rawData.get(index).getAttribute("href").contains("google.com")) {
					continue;
				}
			} catch (Exception e) {
				continue;
			}
			filteredData.add(rawData.get(index));
		}

		for (WebElement element : filteredData) {
			String url = element.getAttribute("href");
			String parsedURL = url.substring(url.indexOf("https://"));
			if (parsedURL.contains(" › ")) {
				parsedURL = parsedURL.replace(" › ", "/");
			}

			// System.out.println(parsedURL);
			filteredStringData.add(parsedURL);
		}

		return filteredStringData;
	}
}

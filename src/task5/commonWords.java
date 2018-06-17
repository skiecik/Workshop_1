package task5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class commonWords {

	static void searchAndSave() {
		
		Connection conn = Jsoup.connect("http://www.onet.pl/");
		
		try {
			FileWriter fw = new FileWriter("popular_words.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			
			Document document = conn.get();
			Elements links = document.select("span.title");
			
			for (Element elem : links) {
				StringTokenizer st = new StringTokenizer(elem.text(), " ,.");
				while (st.hasMoreTokens()) {
					String word = st.nextToken();
					if (word.length() > 3) {
						bw.write(word + "\n");
					}
				}
			}
			System.out.println("Done");
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void readAndFilter () {
		try {
			BufferedReader br = new BufferedReader(new FileReader("popular_words.txt"));
			String line = "";
			FileWriter fw = new FileWriter("filtered_popular_words.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			
			while ((line = br.readLine()) != null) {
				if (!Arrays.asList(filteredWords).contains(line)) {
					bw.write(line + "\n");
				}
			}
			System.out.println("Done");
			br.close();
			bw.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		searchAndSave();
		readAndFilter();
	}
	
	public static final String[] filteredWords = {
			"bardzo",
			"oraz",
			"takze",
			"wspaniałe",
			"dużo",
			"duży",
			"śmieje", 
			"walizki",
			"obrazków",
			"suchej",
			"królik",
			"dalej",
			"chory",
			"zastanawia",
			"owoce",
			"mogą",
			"Teraz",
			"mają",
			"mogą",
			"wokół",
			"Nowe",
			"jaki",
			"Jaki",
			"nazwę",
			"ostro",
			"szansa",
			"dnia",
			"czuje",
			"Nowy",
			"przyszłości",
			"pomysł",
			"skarbów",
			"plakacie",
			"wiedzy",
			"były",
			"nielegalne",
			"odpady",
			"nazwę",
			"zmienia",
			"król",
			"naprawdę",
			"zakazu",
			"handlu",
			"dramat",
			"Warto",
			"kiedy",
			"Kiedy",
			"zobaczyli",
			"robi",
			"niania",
			"dziećḿi",
			"mogli",
			"powstrzymać",
			"sprawę",
			"mamy",
			"największą",
			"spadają",
			"Duży",
			"kilka",
			"ruszył",
			"tytułów",
			"kanał",
			"niskie",
			"sposoby"};
}

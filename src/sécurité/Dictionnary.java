package sécurité;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Dictionnary {

	ArrayList<String> wordsOfDictionnary;

	public void createDictionnary() {
		wordsOfDictionnary = new ArrayList<String>();
		try {
			InputStream flux = new FileInputStream("dictionnaire.txt");
			InputStreamReader lecture = new InputStreamReader(flux);
			BufferedReader buff = new BufferedReader(lecture);
			String ligne;
			while ((ligne = buff.readLine()) != null) {
				wordsOfDictionnary.add(ligne);
			}
			buff.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}

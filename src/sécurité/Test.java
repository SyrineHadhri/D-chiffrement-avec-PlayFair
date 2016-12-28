package sécurité;

import java.util.Scanner;

public class Test {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		String keyword;
		PlayfairCipherDecryption x = new PlayfairCipherDecryption();
		Dictionnary myDictionnary = new Dictionnary();
		myDictionnary.createDictionnary();

		// word to decrypt: (Make sure length of message is even)
		System.out.println("Entrer le message chiffré:");
		String key_input = sc.nextLine();
		key_input = x.removeSpace(key_input);
		if (key_input.length() % 2 == 0) {
			for (int i = 1; i <= 10; i++) {
				BruteForce bruteForce = new BruteForce(33, 256, i);
				while (BruteForce.chars[0] == 0) {

					keyword = bruteForce.run();
					System.out.println("la clé: " + keyword);
					keyword = x.removeSpace(keyword);
					x.setKey(keyword);
					x.KeyGen();

					String clearMessage = x.decryptMessage(key_input);
					System.out.println("\n" + "message obtenu: " + clearMessage);
					System.out.println("----------------------------------");
					if (myDictionnary.wordsOfDictionnary.contains(clearMessage)) {
						System.out.println("---> message clair: " + clearMessage + " & la clé: " + keyword);
						return;
					}

				}

			}
		} else {
			System.out.println("Message length should be even");
		}
	}
}

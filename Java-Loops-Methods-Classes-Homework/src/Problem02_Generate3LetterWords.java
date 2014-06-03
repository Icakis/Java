import java.util.Arrays;
import java.util.Scanner;

import com.sun.org.apache.regexp.internal.recompile;

public class Problem02_Generate3LetterWords {

	public static char[] newWord = new char[3];
	public static char[] theAlphabet;
	public static int numberOfIterations;// (int) Math.pow(theAlphabet.length,
											// theAlphabet.length);
	public static int numberOfLoops = 3;

	public static void printWord() {
		for (int i = 0; i < newWord.length; i++) {
			System.out.printf("%s", newWord[i]);
		}
		System.out.printf("%s", " ");
		return;
	}

	public static void allWords(int currentIndex, int currentLetter) {
		if (currentIndex >= newWord.length) {
			printWord();
			return;
		}
		for (int counter = currentLetter; counter < theAlphabet.length; counter++) {
			newWord[currentIndex] = theAlphabet[counter];
			allWords(currentIndex + 1, currentLetter);
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Input string:");
		String threeChars = input.next();
		while (threeChars.length() > 3) {
			System.out.println("Wrong string length");
			threeChars = input.next();
		}
		theAlphabet = threeChars.toCharArray();
		Arrays.sort(theAlphabet);
		// start to write in newWord[0] and from letter theAlphabet[0]
		allWords(0, 0);
	}

}

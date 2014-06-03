import java.util.Scanner;
import java.util.TreeSet;


public class Problem10_ExtractAllUniqueWords {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String inputString = input.nextLine();
		String[] arrayStrings = inputString.split("[^a-zA-Z]+");
		TreeSet<String>allWords = new TreeSet<String>();
		for (String word : arrayStrings) {
			if (!allWords.contains(word.toLowerCase())) {
				allWords.add(word.toLowerCase());
			}
		}
		for (String string : allWords) {
			System.out.printf("%s ",string);
		}
	}

}

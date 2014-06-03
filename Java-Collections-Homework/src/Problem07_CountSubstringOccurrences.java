import java.util.Scanner;


public class Problem07_CountSubstringOccurrences {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String inputString = input.nextLine();
		String wordToFind = input.nextLine();
		int count=0;
		if (inputString.length()>=wordToFind.length()) {
			for (int i = 0; i < inputString.length()-wordToFind.length()+1; i++) {
				if (inputString.substring(i, wordToFind.length()+i).compareToIgnoreCase(wordToFind)==0) {
					count++;
				}
			}	
		}
		System.out.println(count);
	}

}

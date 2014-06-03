import java.util.Scanner;

public class Problem05_CountAllWords {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String inputString = input.nextLine();
		String[] arrayStrings = inputString.split("[^a-zA-Z]+");
		//String[] arrayStrings = inputString.split("[ ,\'.?!-():;/_@+={}\\\"#$%^&*]+");
		System.out.println(arrayStrings.length);
	}

}

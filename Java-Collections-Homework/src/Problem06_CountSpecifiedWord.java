import java.util.Scanner;


public class Problem06_CountSpecifiedWord {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String inputString = input.nextLine();
		String wordToFind = input.nextLine();
		String[] arrayStrings = inputString.split("[ ,\'.?!-():;/_@+={}\\\"#$%^&*]+");
		int count =0;
		for (String string : arrayStrings) {
			if(wordToFind.compareToIgnoreCase(string)==0){
				count++;
			}
		}
		System.out.println(count);
	}

}

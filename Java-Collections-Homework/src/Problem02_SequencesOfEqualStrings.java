import java.util.Scanner;


public class Problem02_SequencesOfEqualStrings {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String inputString = input.nextLine();
		String[] arrayStrings = inputString.split(" ");
		String compareString = arrayStrings[0];
		System.out.printf("%s",compareString);
		for (int i = 1; i < arrayStrings.length; i++) {
			if (arrayStrings[i].equals(compareString)) {
				System.out.printf(" %s",compareString);
			}else{
				System.out.printf("\n%s",arrayStrings[i]);
				compareString=arrayStrings[i];
			}
		}
	}

}

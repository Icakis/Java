import java.util.Scanner;

public class Problem03_LargestSequenceOfEqualStrings {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String inputString = input.nextLine();
		String[] arrayStrings = inputString.split(" ");
		String found = arrayStrings[0];
		String foundMax = arrayStrings[0];
		int count = 1;
		int max = 1;
		for (int i = 1; i < arrayStrings.length; i++) {
			if (arrayStrings[i].compareTo(found) == 0) {
				count++;
				if (max < count) {
					foundMax = arrayStrings[i];
					max = count;
				}
			} else {
				found = arrayStrings[i];
				count = 1;
			}
		}
		System.out.printf("%s", foundMax);
		for (int i = 1; i < max; i++) {
			System.out.printf(" %s", foundMax);
		}
	}

}

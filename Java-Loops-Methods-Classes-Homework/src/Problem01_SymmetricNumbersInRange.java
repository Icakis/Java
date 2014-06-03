import java.util.Scanner;

public class Problem01_SymmetricNumbersInRange {
	public static int[] inputInts() {
		boolean Pass = false;
		Scanner input = new Scanner(System.in);
		int[] twoInts = new int[2];
		while (!Pass) {
			try {
				System.out.printf("Input 2 integers:");
				String inputStr = input.nextLine();
				String inputNums[] = inputStr.split(" ");
				twoInts[0] = Integer.parseInt(inputNums[0]);
				twoInts[1] = Integer.parseInt(inputNums[1]);
				if (twoInts[0] < 0 || twoInts[1] < 0) {
					System.out.println("Number cannot be negative");
				} else if (twoInts[1] - twoInts[0] < 0) {
					System.out
							.println("First number cannot be smaller then second one!");
				} else {
					Pass = true;
					return twoInts;
				}
			} catch (Exception e) {
				System.out.println("Wrong input!");
				input = new Scanner(System.in);
			}
		}
		return twoInts;
	}

	public static void main(String[] args) {
		int[] inputInts = inputInts();
		for (int i = inputInts[0]; i <= inputInts[1]; i++) {
			if (Integer.toString(i).length() == 1) {
				System.out.printf("%d ", i);
				continue;
			}
			boolean isSymetricInt = true;
			for (int j = 0; j <= (Integer.toString(i).length() - 1) / 2; j++) {
				if (Integer.toString(i).charAt(j) != Integer.toString(i)
						.charAt(Integer.toString(i).length() - 1 - j)) {
					isSymetricInt = false;
					break;
				}
			}
			if (isSymetricInt) {
				System.out.printf("%d ", i);
			}
		}
	}

}

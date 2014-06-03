import java.util.Arrays;
import java.util.Scanner;


public class Problem01_SortArrayOfNumbers {
	public static int[] inputInts(Scanner input,int lenght) {
		boolean Pass = false;
		int[] allInts = new int[lenght];
		while (!Pass) {
			try {
				String inputStr = input.nextLine();
				String inputNums[] = inputStr.split(" ");
				for (int i = 0; i < lenght; i++) {
					allInts[i] = Integer.parseInt(inputNums[i]);
				}
				Pass = true;
			} catch (Exception e) {
				System.out.println("Wrong input3!");
				input = new Scanner(System.in);
			}
		}
		return allInts;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int arrayLength = inputInts(input,1)[0];
		while (arrayLength<1) {
			System.out.println("Wrong input. Number>0");
			arrayLength = inputInts(input,1)[0];
		}
		int[] numbersToSort = inputInts(input,arrayLength);
		Arrays.sort(numbersToSort);
		for (int i : numbersToSort) {
			System.out.printf("%d ",i);
		}
	}

}

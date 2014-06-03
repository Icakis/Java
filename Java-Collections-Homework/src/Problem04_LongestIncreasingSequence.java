import java.util.Scanner;


public class Problem04_LongestIncreasingSequence {
	public static int[] inputInts(Scanner input) {
		boolean Pass = false;
		int[] allInts = null;
		while (!Pass) {
			try {
				String inputStr = input.nextLine();
				String inputNums[] = inputStr.split(" ");
				allInts = new int[inputNums.length];
				for (int i = 0; i < inputNums.length; i++) {
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
		int[]nums = inputInts(input);
		int lastNumber = nums[0];
		int maxCountedNumberIndex=0;
		int lastIndex =0;
		System.out.printf("%d",lastNumber);
		int count =1;
		int max =1 ;
		for (int i = 1; i < nums.length; i++) {
			if (lastNumber<nums[i]) {
				count++;
				if (count>max) {
					max=count;
					maxCountedNumberIndex=lastIndex;
				}
				lastNumber=nums[i];
				System.out.printf(" %d",lastNumber);
			}else {
				lastNumber=nums[i];
				count=1;
				lastIndex=i;
				System.out.printf("\n%d",lastNumber);
			}
		}
		System.out.print("\nLongest:");
		for (int i = maxCountedNumberIndex; i < maxCountedNumberIndex+max; i++) {
			System.out.printf(" %d",nums[i]);
		}
	}

}

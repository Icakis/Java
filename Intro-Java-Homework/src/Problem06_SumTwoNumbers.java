import java.util.Scanner;


public class Problem06_SumTwoNumbers {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Input first integer:");
		int num1 = input.nextInt();
		System.out.print("Input second integer:");
		int num2 = input.nextInt();
		System.out.printf("%d+%d=%d%n", num1,num2,num1+num2);
	}

}

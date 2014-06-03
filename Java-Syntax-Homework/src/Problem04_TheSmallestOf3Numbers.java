import java.util.Locale;
import java.util.Scanner;


public class Problem04_TheSmallestOf3Numbers {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		boolean Pass = false;
		double num1 = Double.MIN_VALUE;
		double num2= Double.MIN_VALUE;
		double num3= Double.MIN_VALUE;
		while(!Pass){
			try {
				System.out.print("Input 3 numbers:");
				Scanner input = new Scanner(System.in);
				num1 = input.nextDouble();
				num2 = input.nextDouble();
				num3 = input.nextDouble();
				Pass = true;
			} catch (Exception e) {
				System.out.println("Wrong input!");
			}
		}
		int pr = 3;
		System.out.printf("Smallest of %f ,%f,%f numbers is: %f ",num1,num2,num3,Math.min(Math.min(num1, num2),num3));

	}

}

import java.util.Locale;
import java.util.Scanner;

public class Problem01_RectangleArea {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		boolean Pass = false;
		while(!Pass){
			try {
				System.out.print("Input sides of a rectangle :");
				Scanner input = new Scanner(System.in);
				double a = input.nextDouble();
				double b = input.nextDouble();
				System.out.printf("Rectangle area is: %.2f", a*b);
				Pass = true;
			} catch (Exception e) {
				System.out.println("Wrong input!");
			}
		}
	}

}

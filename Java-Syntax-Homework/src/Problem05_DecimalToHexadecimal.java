import java.util.Locale;
import java.util.Scanner;


public class Problem05_DecimalToHexadecimal {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		boolean Pass = false;
		int num = Integer.MIN_VALUE;
		while(!Pass){
			try {
				System.out.print("Input integer number:");
				Scanner input = new Scanner(System.in);
				num = input.nextInt();
				Pass = true;
			} catch (Exception e) {
				System.out.println("Wrong input!");
			}
		}
		System.out.printf("%X",num);
	}

}

import java.util.Locale;
import java.util.Scanner;


public class Problem06_FormattingNumbers {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		boolean Pass = false;
		int a = Integer.MIN_VALUE;
		double b= Double.MIN_VALUE;
		double c= Double.MIN_VALUE;
		while(!Pass){
			try {
				System.out.print("Input 3 numbers:");
				Scanner input = new Scanner(System.in);
				a = input.nextInt();
				if(a>500 || a<0){
					System.out.println("Wrong input!0<=a<=500");
					continue;
				}
				b = input.nextDouble();
				c = input.nextDouble();
				Pass = true;
			} catch (Exception e) {
				System.out.println("Wrong input!");
			}
		}
		//Integer.toBinaryString(a).replace(' ', '0')
		System.out.printf("|%-10X|%s|%10.2f|%-10.3f|",a,String.format("%10s", Integer.toBinaryString(a)).replace(' ', '0'),b,c);

	}

}

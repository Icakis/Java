import java.util.Locale;
import java.util.Scanner;


public class Problem03_PointsInsideAFigure {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		boolean Pass = false;
		double x = 0;
		double y= 0;
		while(!Pass){
			try {
				System.out.print("Input point coordinates (x,y):");
				Scanner input = new Scanner(System.in);
				x = input.nextDouble();
				y = input.nextDouble();
				Pass = true;
			} catch (Exception e) {
				System.out.println("Wrong input!");
			}
		}
		if(x>22.5||x<12.5 ||y <6 || y>13.5){
			System.out.println("Outside");
		}
		else{
			if(x>17.5 && x<20 && y>8.5 && y<13.5){
				System.out.println("Outside");
			}
			else{
				System.out.println("Inside");
			}
		}
	}

}

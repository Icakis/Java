import java.util.Locale;
import java.util.Scanner;


public class Problem02_TriangleArea {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		boolean Pass = false;
		double[] points = new double[6];
		int i = 0;
		Scanner input = new Scanner(System.in);
		while(!Pass){

			try {

				System.out.printf("Input %d point coordinates (x,y):",i/2+1);
				points[i] = input.nextDouble();
				i++;
				points[i] = input.nextDouble();
				i++;
				if(i==6){
					Pass = true;
				}
			} catch (Exception e) {
				System.out.println("Wrong input!");
				input = new Scanner(System.in);
				i = 0;
			}
		}
		double area = Math.abs((points[0]*(points[3]-points[5])+points[2]*(points[5]-points[1])+points[4]*(points[1]-points[3]))/2);
		System.out.printf("\nTriangle area is: %d", (int)Math.round(area));
	}

}

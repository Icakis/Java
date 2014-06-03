import java.util.Locale;
import java.util.Scanner;

public class Problem05_AngleUnitConverter {

	public static double degToRad(double angleDeg) {
		return (angleDeg * Math.PI / 180.0);
	}

	public static double radToDeg(double angleRad) {
		return (angleRad * 180.0 / Math.PI);
	}

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		boolean Pass = false;
		int n = Integer.MIN_VALUE;
		Scanner input = new Scanner(System.in);
		while (!Pass) {
			try {
				n = input.nextInt();
				if (n > 0) {
					Pass = true;
				} else {
					throw new Exception();
				}

			} catch (Exception e) {
				System.out.println("Wrong input for number of queries!");
				input = new Scanner(System.in);
			}
		}
		input.nextLine();
		double[][] allData = new double[n][2];
		for (int i = 0; i < n; i++) {
			String[] measureString = input.nextLine().split(" ");
			try {
				double value = Double.parseDouble(measureString[0]);
				if (measureString[1].equalsIgnoreCase("rad")) {
					allData[i][0] = radToDeg(value);
					allData[i][1] = 0;
				} else if (measureString[1].equalsIgnoreCase("deg")) {
					allData[i][0] = degToRad(value);
					allData[i][1] = 1;
				} else {
					throw new Exception();
				}

			} catch (Exception e) {
				System.out.println("Wrong input for value or measure! "+e);
				input = new Scanner(System.in);
				i--;
			}
		}
		for (double[] ds : allData) {
			System.out.printf("%.6f %s\n", ds[0], ds[1] == 0 ? "deg" : "rad");
		}
	}
}

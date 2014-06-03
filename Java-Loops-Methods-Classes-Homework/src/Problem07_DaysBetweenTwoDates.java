import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.util.Scanner;

public class Problem07_DaysBetweenTwoDates {

	public static Date inputDate(Scanner input) {
		boolean Pass = false;
		SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
		String inputString;
		Date outputDate = null;
		while (!Pass) {
			try {
				System.out.print("Input date in format dd-MM-yyyy:");
				inputString = input.nextLine();
				outputDate = myFormat.parse(inputString);
				Pass = true;
			} catch (ParseException e) {
				e.printStackTrace();
				System.out
						.println("Wrong input for Date or wrong format(dd-MM-yyyy)");
				input = new Scanner(System.in);
			}
		}
		return outputDate;
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		Date firstDate = inputDate(input);
		Date secondDate = inputDate(input);
		System.out.printf("\nDays between two dates: "
				+ TimeUnit.DAYS.convert(
						secondDate.getTime() - firstDate.getTime(),
						TimeUnit.MILLISECONDS));
	}

}

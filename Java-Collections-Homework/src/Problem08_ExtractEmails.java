import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem08_ExtractEmails {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String inputString = input.nextLine();

		Pattern p = Pattern
				.compile("[a-zA-Z0-9]+(([._-][a-zA-Z0-9]+)+)?@[a-zA-Z0-9]+(([.-][a-zA-Z0-9]+)+)?[.][a-zA-Z0-9]+");
		Matcher m = p.matcher(inputString);

		while (m.find()) {
			System.out.println(m.group());
		}
	}

}

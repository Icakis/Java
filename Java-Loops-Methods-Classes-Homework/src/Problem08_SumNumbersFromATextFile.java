import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem08_SumNumbersFromATextFile {

	public static void main(String[] args) {
		Scanner input = null;
		int sum = 0;
		try {
			input = new Scanner(new FileInputStream("./Problem08_Input/Input.txt"), "UTF-8");
			while (input.hasNextLine()) {
				sum += Integer.parseInt(input.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error");
		} catch (NumberFormatException e) {
			System.out.println("Error reading file! ");
		} catch (Exception e) {
			System.out.println("Error: "+e);
		}finally {
			input.close();
		}
		System.out.printf("Sum of digit in file: %d", sum);
	}
}

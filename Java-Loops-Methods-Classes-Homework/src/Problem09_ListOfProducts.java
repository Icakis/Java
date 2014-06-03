import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Problem09_ListOfProducts {
	//It's created class Product.class in different file
	public static ArrayList<Product> readFile() {
		Scanner input = null;
		ArrayList<Product> allProductsInList = new ArrayList<Product>();
		try {
			input = new Scanner(new FileInputStream(
					"./Problem09_Input-Output/Input.txt"), "UTF-8");
			while (input.hasNextLine()) {
				String[] currentLine = input.nextLine().split(" ");
				BigDecimal itemPrice = new BigDecimal(currentLine[1]);
				Product newItem = new Product(currentLine[0], itemPrice);
				allProductsInList.add(newItem);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error");
		} catch (NumberFormatException e) {
			System.out.println("Error reading file! ");
		} catch (Exception e) {
			System.out.println("Error: " + e);
		} finally {
			input.close();
		}
		return allProductsInList;
	}

	public static void writeFile(ArrayList<Product> listToWrite) {

		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(
					"./Problem09_Input-Output/Output.txt"));

			for (int i = 0; i < listToWrite.size(); i++) {
				String currentLine = listToWrite.get(i).getPrice().toString()
						+ " " + listToWrite.get(i).getName() + "\n";
				out.write(currentLine);
			}
			out.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error");
		} catch (NumberFormatException e) {
			System.out.println("Error reading file! ");
		} catch (Exception e) {
			System.out.println("Error: " + e);
		} finally {
			System.out.println("Writting to file...done");
		}
		return;
	}

	public static void main(String[] args) {
		ArrayList<Product> printProducts = readFile();
		Collections.sort(printProducts, new Comparator<Product>() {
			public int compare(Product firstDecimal, Product secondDecimal) {
				return firstDecimal.getPrice().compareTo(
						secondDecimal.getPrice());
			}
		});

		for (Product product : printProducts) {
			System.out.printf("Price: %s Name: %s\n", product.getPrice()
					.toString(), product.getName());
		}
		writeFile(printProducts);
	}
}


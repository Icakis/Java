import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem10_OrderOfProducts {
	public static ArrayList<Product> readFile(String path,boolean readProducts) {
		Scanner input = null;
		ArrayList<Product> allProductsInList = new ArrayList<Product>();
		try {
			if(readProducts){
				input = new Scanner(new FileInputStream(path
						), "UTF-8");
				while (input.hasNextLine()) {
					String[] currentLine = input.nextLine().split(" ");
					BigDecimal itemPrice = new BigDecimal(currentLine[1]);
					Product newItem = new Product(currentLine[0], itemPrice);
					allProductsInList.add(newItem);
				}
			}else{
				input = new Scanner(new FileInputStream(path
						), "UTF-8");
				while (input.hasNextLine()) {
					String[] currentLine = input.nextLine().split(" ");
					BigDecimal itemPrice = new BigDecimal(currentLine[0]);
					Product newItem = new Product(currentLine[1], itemPrice);
					allProductsInList.add(newItem);
				}
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

	public static void writeFile(String pathSum,BigDecimal sum) {

		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(
					pathSum));

			out.write(sum.toString()+"\n");
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
		String pathProducts="./Problem10_Input-Output/Products.txt";
		String pathOrder="./Problem10_Input-Output/Order.txt";
		String pathsum="./Problem10_Input-Output/Output.txt";
		ArrayList<Product> allProducts = readFile(pathProducts,true);
		ArrayList<Product> orderProducts = readFile(pathOrder,false);

		BigDecimal sum=BigDecimal.ZERO;
		for (Product product : orderProducts) {
			for (Product searchedProduct : allProducts) {
				if(product.getName().equalsIgnoreCase(searchedProduct.getName())){
					sum=sum.add(product.getPrice().multiply(searchedProduct.getPrice()));
				}
			}
		}
		System.out.printf("%.2f\n",sum);
		writeFile(pathsum,sum);
	}
}


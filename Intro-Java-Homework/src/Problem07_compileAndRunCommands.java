import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Problem07_compileAndRunCommands {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new FileReader("./src/compile-and-run-commands.txt")))
		{
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}
		} catch (IOException e) {
			System.out.println("Error reading file. Check in \"src\" folder for compile-and-run-commands.txt");
			//e.printStackTrace();
		} 
	}

}

import java.util.ArrayList;
import java.util.Scanner;


public class Problem09_CombineListsOfLetters {
	public static ArrayList<Character> inputLetters(String inputLineString){
		String[] letterStrings = inputLineString.split(" ");
		ArrayList<Character> listChars = new ArrayList<Character>();
		for (String string : letterStrings) {
			listChars.add(string.charAt(0));
		}
		return listChars;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);//new ArrayList<Character>();
		String firstLine = input.nextLine();
		String secondLine = input.nextLine();
		ArrayList<Character> firstList = inputLetters(firstLine);
		ArrayList<Character> secondtList = inputLetters(secondLine);

		ArrayList<Character> newList = new ArrayList<Character>();
		newList.addAll(firstList);
		for (Character character : secondtList) {
			if(!firstList.contains(character)){
				newList.add(character);
			}
		}
		for (Character character : newList) {
			System.out.printf("%s ",character.toString());
		}
	}

}

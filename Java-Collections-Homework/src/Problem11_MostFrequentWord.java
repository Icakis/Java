import java.util.Scanner;
import java.util.TreeMap;

public class Problem11_MostFrequentWord {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String inputString = input.nextLine();
		String[] arrayStrings = inputString.split("[^a-zA-Z]+");
		TreeMap<String,Integer>allWords = new TreeMap<String,Integer>();
		for (String word : arrayStrings) {
			if (!allWords.containsKey(word.toLowerCase())) {//contains(word)
				allWords.put(word.toLowerCase(),1);
			}else {
				Integer count = allWords.get(word.toLowerCase());
				allWords.put(word.toLowerCase(),count+1);
			}
		}
		int maxFrequency = 0;
		for (Integer count : allWords.values()) {
			if(count>maxFrequency){
				maxFrequency=count;
			}
		}
		for (String word : allWords.keySet()) {
			Integer count =allWords.get(word);
			if (maxFrequency==count) {
				System.out.printf("%s -> %d times\n",word,count);
			}
		}
	}

}

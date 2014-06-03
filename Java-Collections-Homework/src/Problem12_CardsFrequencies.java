import java.util.ArrayList;
import java.util.Scanner;

public class Problem12_CardsFrequencies {
	public static String[] allCards = new String[] { "2", "3", "4", "5", "6",
			"7", "8", "9", "10", "J", "Q", "K", "A" };
	public static String[] allSuits = new String[] { "\u2663", "\u2666",
			"\u2665", "\u2660" };

	public static int totalLenght;

	public static ArrayList<Card> inputCards(Scanner input) {
		ArrayList<Card> allInputCards = new ArrayList<>();
		boolean noErrors;
		do {
			try {
				noErrors = true;
				String allCardString = input.nextLine();
				String[] eachCardStrings = allCardString.split(" ");
				totalLenght = eachCardStrings.length;
				int inputOrder = 0;
				for (String card : eachCardStrings) {
					int cardFaceIndex = -1;
					int cardSuitIndex = -1;
					String cardFace = card.substring(0, card.length() - 1);
					String cardSuit = String
							.valueOf(card.charAt(card.length() - 1));
					for (int i = 0; i < allCards.length; i++) {
						if (allCards[i].compareTo(cardFace) == 0) {
							cardFaceIndex = i;
							break;
						}
					}
					for (int i = 0; i < allSuits.length; i++) {
						if (allSuits[i].compareTo(cardSuit) == 0) {
							cardSuitIndex = i;
							break;
						}
					}
					if (cardFaceIndex == -1 || cardSuitIndex == -1) {
						throw new IllegalArgumentException(
								"No such card or suit!");
					}
					boolean cardNotFound = true;
					for (Card card2 : allInputCards) {
						if (card2.getFace().compareToIgnoreCase(cardFace) == 0) {
							card2.setCount(card2.getCount() + 1);
							cardNotFound = false;
							break;
						}
					}
					if (cardNotFound) {
						Card addCard = new Card(cardFace, 1, inputOrder);
						allInputCards.add(addCard);
						inputOrder++;
					}
				}
			} catch (Exception e) {
				System.out.println("Wrong input!(No such card or suit)");
				noErrors = false;
				allInputCards = new ArrayList<>();
				input = new Scanner(System.in);
			}
		} while (!noErrors);
		return allInputCards;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Card> allInputCards = inputCards(input);
		for (int i = 0; i < allInputCards.size(); i++) {
			for (int k = 0; k < allInputCards.size(); k++) {
				if (allInputCards.get(k).getInputNum() == i) {
					System.out.printf("%s -> %.2f%%\n", allInputCards.get(k)
							.getFace(), (double) allInputCards.get(k)
							.getCount() / totalLenght * 100);
				}
			}

		}
	}
}

class Card {
	private String face;
	private int count;
	private int inputNum;

	public Card(String face, int count, int inputNum) {
		this.face = face;
		this.count = count;
		this.inputNum = inputNum;
	}

	public String getFace() {
		return face;
	}

	public int getCount() {
		return count;
	}

	public int getInputNum() {
		return inputNum;
	}

	public void setCount(int newCount) {
		this.count = newCount;
	}
}
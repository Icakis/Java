public class Problem03_FullHouse {
	public static String[] allCards = { "2", "3", "4", "5", "6", "7", "8", "9",
			"10", "J", "Q", "K", "A" };
	public static String[] allSuits = { "\u2663", "\u2666", "\u2665", "\u2660" };
	public static String[] cardsForFullHouse = new String[2];
	public static String[] suitsFor5Cards = new String[5];
	public static int count = 0;

	public static void printSuits() {
		System.out.printf("%s", "(");
		for (int i = 0; i < suitsFor5Cards.length; i++) {
			if (i >= 3) {
				System.out.printf("%s%s ", suitsFor5Cards[i],
						cardsForFullHouse[1]);
			} else {
				System.out.printf("%s%s ", suitsFor5Cards[i],
						cardsForFullHouse[0]);
			}
		}
		System.out.printf("%s", ") ");
		count++;
		return;
	}

	public static void allSuits(int currentIndexSuit, int currentSuit) {
		if (currentIndexSuit == 3) {// suitsFor3Cards.length) {
			currentSuit = 0;
		} else if (currentIndexSuit >= 5) {
			printSuits();
			return;
		}
		for (int counter = currentSuit; counter < allSuits.length; counter++) {
			suitsFor5Cards[currentIndexSuit] = allSuits[counter];
			allSuits(currentIndexSuit + 1, counter +1);
		}
		return;
	}

	public static void allFullHouses(int currentIndexCard, int currentCard,
			int skipCard) {
		if (currentIndexCard == cardsForFullHouse.length) {
			allSuits(0, 0);
			return;
		}
		for (int counter = 0; counter < allCards.length; counter++) {
			if (counter != skipCard) {
				cardsForFullHouse[currentIndexCard] = allCards[counter];
				allFullHouses(currentIndexCard + 1, currentCard + 1, counter);
			}
		}
		return;
	}

	public static void main(String[] args) {
		allFullHouses(0, -1, -1);
		System.out.println();
		System.out.println(count);
	}

}

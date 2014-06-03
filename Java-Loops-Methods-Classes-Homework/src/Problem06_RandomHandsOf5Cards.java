import java.util.Random;
import java.util.Scanner;

public class Problem06_RandomHandsOf5Cards {
	public static String[] allCards = { "2", "3", "4", "5", "6", "7", "8", "9",
			"10", "J", "Q", "K", "A" };
	public static String[] allSuits = { "\u2663", "\u2666", "\u2665", "\u2660" };

	public static void randomHand() {
		int[][] randomHand = new int[5][2];
		Random randomGenerator = new Random();
		int randomCard = randomGenerator.nextInt(13);
		int randomSuit = randomGenerator.nextInt(4);
		randomHand[0][0] = randomCard;
		randomHand[0][1] = randomSuit;
		int cardsGenerated = 1;
		while (cardsGenerated <= 4) {
			randomCard = randomGenerator.nextInt(13);
			randomSuit = randomGenerator.nextInt(4);
			boolean generateNewCard = false;
			for (int i = 0; i < cardsGenerated; i++) {
				if (randomHand[i][0] == randomCard
						&& randomHand[i][1] == randomSuit) {
					generateNewCard = true;
					continue;
				}
			}
			if (!generateNewCard) {
				randomHand[cardsGenerated][0] = randomCard;
				randomHand[cardsGenerated][1] = randomSuit;
				cardsGenerated++;
			}
		}
		for (int[] hand : randomHand) {
			System.out.printf("%s%s ", allCards[hand[0]], allSuits[hand[1]]);
		}
	}

	public static void main(String[] args) {
		boolean Pass = false;
		int numHands = Integer.MIN_VALUE;
		Scanner input = new Scanner(System.in);
		while (!Pass) {
			try {
				System.out.print("Input number of hands to generate:");
				numHands = input.nextInt();
				if (numHands > 0) {
					Pass = true;
				} else {
					throw new Exception();
				}

			} catch (Exception e) {
				System.out.println("Wrong input for number of hands!");
				input = new Scanner(System.in);
			}
		}
		for (int i = 0; i <numHands; i++) {
			randomHand();
			System.out.println();
		}
	}

}

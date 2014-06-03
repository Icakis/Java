import java.util.HashMap;
import java.util.Map;

public class Problem04_FullHouseWithJockersLoopsHashTree {

	public static void main(String[] args) {
		String[] cards = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J",
				"Q", "K", "A", };
		char[] suits = { '♣', '♦', '♥', '♠' };
		int count = 0;
		Map<String, Integer> set = new HashMap<>();
		String[] results = new String[5];
		for (int i = 0; i < cards.length; i++) {
			for (int j = 0; j < cards.length; j++) {
				if (i == j) {
					continue;
				}
				for (int j2 = 0; j2 < suits.length; j2++) {
					for (int k = j2 + 1; k < suits.length; k++) {
						for (int k2 = k + 1; k2 < suits.length; k2++) {
							for (int l = 0; l < suits.length; l++) {
								for (int l2 = l + 1; l2 < suits.length; l2++) {
									for (int m = 0; m <= Math.pow(2, 5) - 1; m++) {
										int num = m;
										for (int m2 = 0; m2 < 5; m2++) {
											if (num % 2 == 1) {
												results[m2] = "*";
												num /= 2;
											}
										}
										set.put("(" + results[4] +" "+ results[3]+" "
												+ results[2]+" " + results[1]+" "
												+ results[0] + ")", 1);
										results[4] = cards[i] + suits[j2];
										results[3] = cards[i] + suits[k];
										results[2] = cards[i] + suits[k2];
										results[1] = cards[j] + suits[l];
										results[0] = cards[j] + suits[l2];
										count++;
									}
								}
							}
						}
					}
				}
			}
		}
		for (Map.Entry<String, Integer> str : set.entrySet()) {
			System.out.print(str.getKey());
			System.out.println();
		}
		System.out.println();
		System.out.println(count);
	}

}
public class Problem04_FullHouseWithJockersLoops {
	
	public static boolean isFullHouse(Card[] hand){
		String firstFace = "";
		int firstCount = 0;
		String secondFace = "";
		int secondCount = 0;
		for (int i = 0; i < hand.length; i++) {
			if(hand[i].face != "*" ){
				if(firstFace == ""){
					firstFace = hand[i].face;
					firstCount = 1;
				}
				else if(hand[i].face != firstFace && secondFace != ""){
					if(hand[i].face != secondFace){
						return false;
					}
					else{
						secondCount++;
						if(secondCount > 3){
							return false;
						}
					}
				}
				else if(hand[i].face != firstFace && secondFace == ""){
					secondFace = hand[i].face;
					secondCount = 1;
				}
				else{
					firstCount++;
					if(firstCount > 3){
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public static Card[] hand = new Card[5];

	public static void main(String[] args) {
		String[] faces = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
		String[] suits = {"♣", "♦", "♥", "♠"};
		Card[] cards = new Card[57];
		cards[0] = new Card("*", "");
		cards[1] = new Card("*", "");
		cards[2] = new Card("*", "");
		cards[3] = new Card("*", "");
		cards[4] = new Card("*", "");
		int p = 5;
		for(int i = 0; i < suits.length; i++){
			for(int j = 0; j < faces.length; j++){
				cards[p++] = new Card(faces[j], suits[i]);
			}
		}
		int fullHouseCount = 0;
		for(int i = 0; i < cards.length - 4; i++){
			for(int j = i + 1; j < cards.length - 3; j++){
				for(int k = j + 1; k < cards.length - 2; k++){
					for(int l = k + 1; l < cards.length - 1; l++){
						for(int m = l + 1; m < cards.length; m++){
							Card[] hand = new Card[5];	
							hand[0] = cards[i];
							hand[1] = cards[j];
							hand[2] = cards[k];
							hand[3] = cards[l];
							hand[4] = cards[m];
							if(isFullHouse(hand)){
								fullHouseCount++;
								System.out.printf("( %s %s %s %s %s )", hand[0], hand[1], hand[2], hand[3], hand[4]);
							}
						}
					}
				}
			}
		}
		System.out.printf("%d full houses", fullHouseCount);
	}
}


class Card {
	String face;
	String suit;
	
	public Card(String f, String s){
		this.face = f;
		this.suit = s;
	}
	
	public String toString(){
		return this.face + this.suit;
	}
}
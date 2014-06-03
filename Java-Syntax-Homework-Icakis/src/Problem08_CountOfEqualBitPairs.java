import java.util.Scanner;

public class Problem08_CountOfEqualBitPairs {

	public static void main(String[] args) {
		boolean Pass = false;
		int num = Integer.MIN_VALUE;
		while(!Pass){
			try {
				System.out.print("Input int number:");
				Scanner input = new Scanner(System.in);
				num = input.nextInt();
				Pass = true;
			} catch (Exception e) {
				System.out.println("Wrong input!");
			}
		}
		//length to last significant digit example: 5 -> 101 => numLength = 3;
		double numLength = Math.round(Math.log(num)/Math.log(2.0));
		if(num==0){
			numLength=0;
		}
		int count = 0;
		for(int i=0;i<numLength-1;i++){
			int mask1 = 1<<i;
			int mask2 = 1<<i+1;
			if(((mask1&num)==0 && (mask2&num)==0)||((mask1&num)!=0 && (mask2&num)!=0)){
				count++;
			}
		}
		System.out.printf("Sequences of two equal bits (\"00\" or \"11\"): %d",count);

	}

}

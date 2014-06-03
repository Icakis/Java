import java.util.Scanner;

public class Problem07_CountOfBitsOne {
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
		int count = 0;
		for(int i=0;i<Integer.SIZE;i++){
			int mask = 1<<i;
			if((mask&num)!=0){
				count++;
			}
		}
		//Integer.bitCount(num)
		System.out.printf("Count of bits 1: %d",count);
	}

}

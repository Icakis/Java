import java.util.Arrays;
import java.util.Scanner;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;


public class Problem08_SortArrayOfStrings {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Input Array lenght:");
		int len = input.nextInt();
		String[] theArray = new String[len];
		for(int i=0;i<theArray.length;i++){
			System.out.printf("Array[%d]=",i);
			theArray[i]=input.next();
		}
		System.out.println();
		Arrays.sort(theArray,String.CASE_INSENSITIVE_ORDER);
		for(int i=0;i<theArray.length;i++){
			System.out.printf("Array[%d]=%s%n",i,theArray[i]);
		}
	}

}

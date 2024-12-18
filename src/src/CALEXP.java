package src;

import java.util.Scanner;

public class CALEXP {

	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int timesLoop = sc.nextInt();
		int row = 0;
		
		while (timesLoop-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			System.out.println("#" + (row + 1) + " " + handleMultiple(a, b));
			row++;
	    }
		sc.close();
	}

	private static int handleMultiple(int a, int b) {
		if (b == 0 ) return 1;
		return a * handleMultiple(a, b-1);
	}

}

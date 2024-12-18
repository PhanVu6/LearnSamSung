package src;

import java.util.Scanner;

public class CALSQRT {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int timesLoop = sc.nextInt();
		int row = 0;
		
		while (timesLoop-- > 0) {
			int n = sc.nextInt();

			System.out.println("#" + (row + 1) + " " + (int) sqroot(n));
			row++;
	    }
		sc.close();
	}
	
    private static double sqroot(double square) {
    	if (square <= 0) return 0;
    	
    	double root = square/3;
    	
    	for(int i = 1; i <= 32; i++) {
    		root = (root + square/root)/2;
    	}
    	
    	return root;
    }

}

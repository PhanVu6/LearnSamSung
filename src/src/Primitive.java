package src;
import java.util.*;
import java.io.FileInputStream;
import java.lang.*;

public class Primitive {

	public static void main (String[] args) throws java.lang.Exception
	{
		System.setIn(new FileInputStream("inputPrimitive.txt"));
		Scanner sc = new Scanner(System.in);
		int timesLoop = sc.nextInt();
		int row = 0;
		
		while (row < timesLoop) {
			handleFindPrimitive(sc);
			row++;
		}
		
	}
	
	private static void handleFindPrimitive(Scanner sc) {
		int start = sc.nextInt();
		int end = sc.nextInt();

		for (int i = start; i <= end; i++) {
			if (i <= 1) continue;
			
			if(checkPrimitive(i, end)) {
				System.out.println(i);
			}
			start++;
		}
		
	}
	
	private static boolean checkPrimitive(int num, int end) {
		for (int i = 2; i <= Math.sqrt(end); i++) {
			if (num % i == 0 && num != i) return false;
		}
		
		return true;
	}

}

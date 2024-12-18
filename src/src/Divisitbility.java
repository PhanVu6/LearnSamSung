package src;

import java.util.*;
import java.io.FileInputStream;
import java.lang.*;

public class Divisitbility {

	public static void main (String[] args) throws java.lang.Exception
	{
		System.setIn(new FileInputStream("inputDivibility.txt"));
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int row = 0;
		
		while (row < t) {
			trueNumber(sc);
			row++;
		}
	}
	
	private static void trueNumber(Scanner sc) {
		int n = sc.nextInt();
		int	x = sc.nextInt();
		int	y = sc.nextInt();
		String result = "";	
		
		for (int index = 2; index <= n ; index++) {
			if (index % x == 0 && index % y != 0) {
				result += index + " ";
			}
		}
		System.out.println(result.trim());
	}

}

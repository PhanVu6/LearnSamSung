package src;

import java.util.*;
import java.lang.*;

public class Ex1 {
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		
		execute(sc);
	}
	
	private static void execute(Scanner sc){
		int number = sc.nextInt();
		while (number != 42) {			
			System.out.println(number);
			sc.nextLine();
			number = sc.nextInt();
		}
	}
}

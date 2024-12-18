package src;
import java.util.*;
import java.lang.*;
public class AddRev {

	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int timesLoop = sc.nextInt();
		
		while(timesLoop != 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			a = reverseNumber(a);
			b = reverseNumber(b);
			
			System.out.println(reverseNumber(a+b));

			timesLoop--;
		}
		
		sc.close();
		
    }
    
    private static int reverseNumber(int number) {
       int reverse = 0;
       
       while (number != 0) {
    	   reverse = reverse*10 + number%10;
    	   number /= 10;
       }
       
       return reverse;
    }

}

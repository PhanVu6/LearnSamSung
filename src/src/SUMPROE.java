package src;
import java.util.*;
import java.lang.*;

public class SUMPROE {
	private static final int MOD = 1000007;

	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int timesLoop = sc.nextInt();
		int row = 0;
		
		while (timesLoop-- > 0) {
			int n = sc.nextInt();
			System.out.println(handleSum(n));
	    }
		sc.close();
	}
	
	private static int handleSum(int n) {
        int sum = 0;

        for (int i = 1; i <= n; i++) {
        	sum =(sum +  (int) ((long) i * (n/i) % MOD)) % MOD;
        }

        return sum;
    }

}

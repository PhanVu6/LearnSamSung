package src;
import java.util.*;
import java.io.FileInputStream;
import java.lang.*;

public class SoNen {

	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
	    int T = sc.nextInt(); // Đọc số lượng test cases
	    StringBuilder result = new StringBuilder();
	
	    for (int i = 1; i <= T; i++) {
	        long N = sc.nextLong(); // Đọc số N
	        int minimalNumber = (int) (N % 9); // Tính N mod 9
	        if (minimalNumber == 0 && N != 0) {
	            minimalNumber = 9; // Nếu mod 9 = 0 và N != 0 thì kết quả là 9
	        }
	        result.append("#").append(i).append(" ").append(minimalNumber).append("\n");
	    }
	    sc.close();
	
	    System.out.print(result.toString());
	}	
}

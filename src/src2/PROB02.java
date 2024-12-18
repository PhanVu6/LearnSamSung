package src2;

import java.util.Scanner;

public class PROB02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int M, N;
		char [][] arr;
		int[] result = new int[5];
		
		for (int tc = 0; tc < T; tc++) {
			M = sc.nextInt();
			N = sc.nextInt();
			sc.nextLine();
			arr = new char[501][501];
			
			for (int i = 0; i < 5*M + 1; i++) {
				String line = sc.next();
				for (int j = 0; j < 5*N + 1; j++) {
					arr[i][j] = line.charAt(j);
				}
			}
			
			for (int i = 0; i < result.length; i++) {
				result[i] = 0;
			}
			
//			Xử lý
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					int row = 5*i +1;
					int col = 5*j +1;
					
					if (arr[row][col] == '.') {
						result[0]++;
					} else if (arr[row + 1][col] == '.') {
						result[1]++;
					} else if (arr[row + 2][col] == '.') {
						result[2]++;
					} else if (arr[row + 3][col] == '.') {
						result[3]++;
					} else {
						result[4]++;
					}
				}
			}
			
			// In kết quả
            System.out.print("#" + (tc + 1));
            for (int count : result) {
                System.out.print(" " + count);
            }
            System.out.println();
		}
	}

}

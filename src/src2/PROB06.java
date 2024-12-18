package src2;
import java.util.Scanner;

public class PROB06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int M, N;
		char [][] matrix;
		
		for (int tc = 0; tc < T; tc++) {
			M = sc.nextInt();
			N = sc.nextInt();
			matrix = new char[M][N];
			int result = 0;
			String line;
			
			for (int i = 0; i < M; i++) {
				line = sc.next();
				for (int j = 0; j < N; j++) {
					matrix[i][j] = line.charAt(j);
				}
			}
			
//			Xử lý (Code này fail rồi chưa biết nguyên nhân)
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (matrix[i][j] == 'H') {
						boolean rightA = (j + 1 > N-1) ? true : matrix[i][j + 1] != 'A';
						boolean leftA = (j - 1 < 0) ? true : matrix[i][j - 1] != 'A';
						boolean rightB = (j + 2 > N-1) ? true : matrix[i][j + 1] != 'B' && matrix[i][j + 2] != 'B';
						boolean leftB = (j - 2 < 0) ? true : matrix[i][j - 1] != 'B' && matrix[i][j - 2] != 'B';
						boolean rightC = (j + 3 > N-1) ? true : matrix[i][j + 1] != 'C' && matrix[i][j + 2] != 'C' && matrix[i][j + 3] != 'C';
						boolean leftC = (j - 3 < 0) ? true : matrix[i][j - 1] != 'C' && matrix[i][j - 2] != 'C' && matrix[i][j - 3] != 'C';
						
						boolean topA = (i + 1 > M-1) ? true : matrix[i+1][j] != 'A';
						boolean bottomA = (i - 1 < 0) ? true : matrix[i-1][j] != 'A';
						boolean topB = (i + 2 > M-1) ? true : matrix[i+1][j] != 'B' && matrix[i+2][j] != 'B';
						boolean bottomB = (i - 2 < 0) ? true : matrix[i-1][j] != 'B' && matrix[i-2][j] != 'B';
						boolean topC = (i + 3 > M-1) ? true : matrix[i+1][j] != 'C' && matrix[i+2][j] != 'C' && matrix[i+3][j] != 'C';
						boolean bottomC = (i - 3 < 0) ? true : matrix[i-1][j] != 'C' && matrix[i-2][j] != 'C' && matrix[i-3][j] != 'C';
						
						if (
								(topA && rightA && bottomA && leftA)
								&& (topB && rightB && bottomB && leftB)
								&& (topC && rightC && bottomC && leftC)) {
							result++;
						}
					}
				}
			}
		
			System.out.println("#" + (tc + 1) + " " + result);
		}
		

	}

}

package src2;

import java.io.FileInputStream;
import java.util.Scanner;
import java.lang.*;

public class QKPE {
	private static final int hau = 1;
	private static final int ma = 2;
	private static final int tot = 3;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("inputBoard.txt"));
		Scanner sc = new Scanner(System.in);
		int M, N, K, totalSafe;
		int[][] matrix = new int[1000][1000];
		boolean[][] checkSafe = new boolean[1000][1000];
		int testCase = 1;

		while (true) {
			totalSafe = 0;
			M = sc.nextInt();
			N = sc.nextInt();
			
			if (M == 0 && N == 0) {
				break;
			}
			

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					matrix[i][j] = 0;
					checkSafe[i][j] = false;
				}
			}

			for (int i = 1; i <= 3; i++) {
				K = sc.nextInt();
				for (int j = 1; j <= K; j++) {
					int x = sc.nextInt();
					int y = sc.nextInt();

					if (i == 1) {
						matrix[x - 1][y - 1] = hau;
					} else if (i == 2) {
						matrix[x - 1][y - 1] = ma;
					} else if (i == 3) {
						matrix[x - 1][y - 1] = tot;
					}
				}
			}

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (matrix[i][j] == hau) { // Hậu
						handleCheckSafe(checkSafe, matrix, i, j, hau, M, N);
					} else if (matrix[i][j] == ma) { // Mã
						handleCheckSafe(checkSafe, matrix, i, j, ma, M, N);
					}else if (matrix[i][j] == tot) { // Mã
						handleCheckSafe(checkSafe, matrix, i, j, tot, M, N);
					}
					
				}
			}

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
//					System.out.print(checkSafe[i][j] +""+ matrix[i][j] + " ");
					if (!checkSafe[i][j]) {
						totalSafe++;
					}
				}
//				System.out.println();
			}
			
			System.out.println("Board "+ testCase + " has " + totalSafe + " safe squares.");
//			System.out.println();
			testCase++;
		}
	}

	private static boolean handleCheckSafe(boolean[][] checkSafe, int[][] matrix, int x, int y, int type, int M,
			int N) {

		if (type == hau) {
			boolean checkDuongCheo;
//			bên trên
			for (int i = x; i >= 0; i--) {
				if (matrix[i][y] != tot && matrix[i][y] != ma) {
					checkSafe[i][y] = true;
				} else {
					break;
				}
			}
//			bên phải
			for (int i = y; i < N; i++) {
				if (matrix[x][i] != tot && matrix[x][i] != ma) {
					checkSafe[x][i] = true;
				} else {
					break;
				}
			}

//			bên trái
			for (int i = y; i >= 0; i--) {
				if (matrix[x][i] != tot && matrix[x][i] != ma) {
					checkSafe[x][i] = true;
				} else {
					break;
				}
			}

//			bên dưới
			for (int i = x; i < M; i++) {
				if (matrix[i][y] != tot && matrix[i][y] != ma) {
					checkSafe[i][y] = true;
				} else {
					break;
				}
			}

//			Đường chéo từ trái sang phải (dưới lên)
			checkDuongCheo = true;
			for (int i = x; i < M && checkDuongCheo; i++) {
				for (int j = y; j < N; j++) {
					if (j - i == y - x) {
						if (matrix[i][j] != tot && matrix[i][j] != ma) {
							checkSafe[i][j] = true;
						} else {
							checkDuongCheo = false;
							break;
						}
					}
				}
			}

//			Đường chéo từ trái sang phải (trên xuống)
			checkDuongCheo = true;
			for (int i = x; i >= 0 && checkDuongCheo; i--) {
				for (int j = y; j >= 0; j--) {
					if (j - i == y - x) {
						if (matrix[i][j] != tot && matrix[i][j] != ma) {
							checkSafe[i][j] = true;
						} else {
							checkDuongCheo = false;
							break;
						}
					}
				}
			}

//			Đường chéo từ trái sang phải (dưới lên)
			checkDuongCheo = true;
			for (int i = x; i < M && checkDuongCheo; i++) {
				for (int j = y; j < N; j++) {
					if (j - i == y - x) {
						if (matrix[i][j] != tot && matrix[i][j] != ma) {
							checkSafe[i][j] = true;
						} else {
							checkDuongCheo = false;
							break;
						}
					}
				}
			}

//			Đường chéo từ phải sang trái (dưới lên)
			for (int i = x; i >= 0 && checkDuongCheo; i--) {
				for (int j = y; j < N; j++) {
					if (j + i == y + x) {
						if (matrix[i][j] != tot && matrix[i][j] != ma) {
							checkSafe[i][j] = true;
						} else {
							checkDuongCheo = false;
							break;
						}
					}
				}
			}

//			Đường chéo từ phải sang trái (trên xuống)
			checkDuongCheo = true;
			for (int i = x; i < M && checkDuongCheo; i++) {
				for (int j = y; j >= 0; j--) {
					if (j + i == y + x) {
						if (matrix[i][j] != tot && matrix[i][j] != ma) {
							checkSafe[i][j] = true;
						} else {
							checkDuongCheo = false;
							break;
						}
					}
				}
			}

		} else if (type == ma) {
			/*
			 * Trái 
			 * */
//			Bên trên cùng phía trái
			if (x-2 >= 0 && y-1 >= 0) {
				checkSafe[x-2][y-1] = true;
			}
			
//			Bên trên phần tiếp theo phía trái
			if (x-1 >= 0 && y-2 >= 0) {
				checkSafe[x-1][y-2] = true;
			}
			
//			Bên dưới cùng phía trái
			if (x+2 < M && y-1 >= 0) {
				checkSafe[x+2][y-1] = true;
			}
			
//			Bên dưới liền kề bên trên phần trước phía trái
			if (x+1 < M && y-2 >= 0) {
				checkSafe[x+1][y-2] = true;
			}
			
			/*
			 * Phải 
			 * */
//			Bên trên cùng phía phải
			if (x-2 >= 0 && y+1 < N) {
				checkSafe[x-2][y+1] = true;
			}
			
//			Bên trên phần tiếp theo phía phải
			if (x-1 >= 0 && y+2 < N) {
				checkSafe[x-1][y+2] = true;
			}
			
//			Bên dưới cùng phía phải
			if (x+2 < M && y+1 < N) {
				checkSafe[x+2][y+1] = true;
			}
			
//			Bên dưới liền kề bên trên phần trước phía phải
			if (x+1 < M && y+2 < N) {
				checkSafe[x+1][y+2] = true;
			}
		}

		return checkSafe[x][y] = true;
	}

}

package src;

import java.util.Scanner;

public class NUMPER {

	public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int timesLoop = sc.nextInt();
        StringBuilder result = new StringBuilder();

        for (int row = 1; row <= timesLoop; row++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            result.append("#").append(row).append(" ").append(handleNumber(start, end)).append("\n");
        }
        sc.close();
        System.out.println(result.toString().trim());
    }

    private static String handleNumber(int start, int end) {
        int sqrtStart = (int) Math.ceil(Math.sqrt(start));
        int sqrtEnd = (int) Math.floor(Math.sqrt(end));

        if (sqrtStart > sqrtEnd) {
            return "NO NUMBER";
        }

        StringBuilder result = new StringBuilder();
        for (int i = sqrtStart; i <= sqrtEnd; i++) {
            result.append(i * i).append(" ");
        }

        return result.toString().trim();
    }
}

package BOJ;

import java.util.Scanner;

public class BOJ9465 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int[][] sticker = new int[3][n + 1];
            for (int i = 1; i <= 2; i++) {
                for (int j = 1; j <= n; j++) {
                    sticker[i][j] = sc.nextInt();
                }
            }

            int[][] dp = new int[n + 1][3];
            for (int i = 1; i <= n; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2]));
                dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][2]) + sticker[1][i];
                dp[i][2] = Math.max(dp[i - 1][0], dp[i - 1][1]) + sticker[2][i];
            }
            System.out.println(Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2])));
        }
    }
}

package BOJ;

import java.util.Scanner;

public class BOJ11726 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if (i == 1) {
                dp[i] = 1;
            } else if (i == 2) {
                dp[i] = 2;
            } else {
                dp[i] = (dp[i-1] + dp[i-2]) % 10007;
            }
        }
        System.out.print(dp[N]);
    }
}

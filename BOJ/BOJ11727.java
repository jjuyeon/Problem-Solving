package BOJ;

import java.util.Scanner;

public class BOJ11727 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if (i == 1) {
                dp[i] = 1;
            } else if (i == 2) {
                dp[i] = 3;
            } else {
                // 길이가 1 남았을 때? 1*2 타일 1개로 채움
                // 길이가 2 남았을 때? 2*1 타일 2개로 채움 + 2*2 타일 1개로 채움
                                // 1*2 타일 2개로 채울 수 있지만, 이는 곧 dp[i-1]과 중복되게 된다
                dp[i] = (dp[i-1] + 2*dp[i-2]) % 10007;
            }
        }
        System.out.print(dp[N]);
    }
}

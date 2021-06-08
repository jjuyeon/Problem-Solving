package BOJ;

import java.util.Scanner;

public class BOJ9095 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] dp = new int[11];
        dp[1] = 1; dp[2] = 2; dp[3] = 4;
        for(int i=4; i<11; i++){
            // 1을 추가하는 경우 + 2를 추가하는 경우 + 3을 추가하는 경우
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        int n = sc.nextInt();
        while(n-- > 0){
            System.out.println(dp[sc.nextInt()]);
        }
    }
}

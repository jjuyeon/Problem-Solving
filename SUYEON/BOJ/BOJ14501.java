package BOJ;

import java.util.*;

public class BOJ14501 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] t = new int[n+1];
        int[] p = new int[n+1];
        int[] dp = new int[n+1]; // dp[n] = n일까지 얻는 이익
        for(int i=1; i<=n; i++){
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
            dp[i] = p[i];
        }


        for(int i=2; i<=n; i++){ // n일(마지막날)까지 체크하기
            for(int j=1; j<i; j++){
                // i보다 작아야,, i일 전에 끝난 상담만 업데이트할 수 있다
                // (t[j] + j -> 이 이후에 j 상담에 대한 돈 받음)
                if(i >= t[j] + j) {
                    dp[i] = Math.max(dp[i], p[i] + dp[j]);
                }
            }
        }

        int ans = 0;
        for(int i=1; i<=n; i++){
            if(i+t[i] <= n+1){ // i+t[i] 이후에 돈을 받으므로, 그 날이 퇴사일까지여야함
                ans = Math.max(ans, dp[i]);
            }
        }
        System.out.print(ans);
    }
}

package BOJ;

import java.util.Scanner;

public class BOJ2839_dp {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[5001]; // dp 인덱스 값: 무게
        dp[3] = 1; dp[5] = 1; // 초기화
        for(int i=6; i<=5000; i++){
            if(dp[i-3] == 0 || dp[i-5] == 0){
                if(dp[i-3] == 0 && dp[i-5] == 0){ // 무게가 0일때는 업데이트하지 않음
                    continue;
                }
                dp[i] = (dp[i-3]!=0)? dp[i-3]+1 : dp[i-5]+1;
            }
            else{ // 둘 중 가장 적은 개수를 가진 무게를 선택
                dp[i] = Math.min(dp[i-3], dp[i-5]) + 1;
            }
        }

        System.out.print(dp[n]==0? -1 : dp[n]);
    }
}

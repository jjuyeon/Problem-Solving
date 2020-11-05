import java.util.*;

public class BOJ1463 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        for(int i=2; i<=n; i++){ // 3가지 중 가장 최소 연산을 찾는 방법 ㅠ
            dp[i] =dp[i-1] + 1;
            if(i%2 == 0){
                dp[i] = Math.min(dp[i], dp[i/2] + 1);
            }
            if(i%3 == 0){
                dp[i] = Math.min(dp[i], dp[i/3] + 1);
            }
        }

        System.out.print(dp[n]);
    }
}

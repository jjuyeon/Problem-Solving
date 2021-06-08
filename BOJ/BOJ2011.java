import java.util.Scanner;

public class BOJ2011 {
    // (DP 관련 문제) 어떤 암호가 주어졌을 때, 그 암호의 해석이 몇 가지가 나올 수 있는지 구하는 프로그램을 작성하시오.
    static int cal_dp(String input){
        int[] dp = new int[input.length()+1];
        if(input.charAt(0) == '0'){
            return 0;
        }
        dp[0] = dp[1] = 1;
        for(int i=2; i<dp.length; i++){
            int charToINT = (input.charAt(i-2) - '0') * 10 + (input.charAt(i-1) - '0');
            if(input.charAt(i-1) > '0') dp[i] = dp[i-1];
            if(charToINT >=10 && charToINT <= 26) dp[i] = (dp[i-2] + dp[i]) % 1000000;
        }
        return dp[input.length()];
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        System.out.println(cal_dp(input));
    }
}

package BOJ;

import java.util.Scanner;
import java.util.Arrays;

// https://devowen.com/263
// https://www.acmicpc.net/board/view/37112
// https://www.acmicpc.net/board/view/37112

public class BOJ10422 {
    static int ans;
    static final int MOD = 1000000007;
    static int[][] dp;

    public static void main(String[] args){
        dp = new int[5001][5001];
        for(int i=0; i<5001; i++){ // 초기화
            Arrays.fill(dp[i], -1);
        }

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int test_case=1; test_case<=t; test_case++){
            int l = sc.nextInt();
            if(l % 2 == 0){
                System.out.println(recursive_minus(l/2, l/2));
//                ans = 0;
//                recursive_plus(0, 0, l);
//                System.out.println(ans);
            }
            else{
                System.out.println(0);
            }
        }
    }

    // 해당 코드는 시간초과
    private static void recursive_plus(int open, int close, int l){
        if(open+close == l) {
            ++ans;
            return;
        }

        //1. (((
        //2. ((())) --ok
        //3. ((())
        //4. ((()
        //5. (((
        //6. (()
        //7. (()(
        //8. (()()
        //9. (()()) --ok
        // ........

        if(open < l/2) {
            recursive_plus(open+1, close, l);
        }

        if(close < open) {
            recursive_plus(open, close+1, l);
        }
    }

    // 발상의 전환 -> 더하는거 말고 이미 다 만들어져있는 문자열에서 괄호를 하나씩 빼보자
    private static int recursive_minus(int open, int close){ // 여는 괄호 개수, 닫는 괄호 개수
        // 정상 종료
        if(open == 0 && close == 0) return 1; // 둘 다 0개이면 정상적인 괄호가 만들어지므로 1

        // 종료 조건(기저조건)
        if(open < 0 || close < 0) return 0; // 여는 괄호 개수 또는 닫는 괄호 개수 중 하나라도 음수면 만들 수 있는 괄호 없음 => 종료
        if(open > close) return 0; // 지워나가다보면, 중복되는 문자열 패턴이 나온다 -> 이를 중복해서 더하는 것을 방지
        // if(open < close) return 0; // 그래서 이렇게 조건을 줘도 상관없다. 그냥 단순히 중복만 방지하면 된다

        int ans = dp[open][close];
        if(ans != -1){ // 메모이제이션 쓰기
            return ans; // 계산한 값있으면 그거 가져다쓰기
        }
        ans = recursive_minus(open-1, close) + recursive_minus(open, close-1); // 여는 괄호, 닫는 괄호 하나씩 빼면서 유효한 괄호인지 검사
        ans %= MOD;

        return dp[open][close] = ans; // 계산 결과가 나왔으면 저장(메모이제이션)
    }

}

package BOJ;

/**
 * 메모리초과 오류 뜨는 이유: 처음에는 Brute force로 완전탐색을 통해 구현
 * mid에 위치하면 중복적인 계산이 존재하게 됨(왼쪽 위 대각선, 오른쪽 위 대각선에서 두번 계산하게 됨)
 * 그러므로 dp를 사용해야 함 --> 실제 코딩테스트였으면 0점이다. (항상 메모리 체크하자 -> 메모리가 적어보이면 dp문제다)
 */

import java.io.*;
import java.util.*;

public class BOJ1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] triangle = new int[n][n];
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<i+1; j++){
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n][n];
        System.out.println(get_max_sum(dp, triangle, n));
    }

    static int get_max_sum(int[][] dp, int[][] triangle, int height) {
        dp[0][0] = triangle[0][0];
        for(int i=1; i<height; i++){
            dp[i][0] = triangle[i][0] + dp[i-1][0]; // left
            dp[i][i] = triangle[i][i] + dp[i-1][i-1]; // right
        }

        for(int i=2; i<height; i++){
            for(int j=1; j<i; j++){ // mid
                dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j], dp[i-1][j-1]);
            }
        }

        int answer = 0;
        for(int j=0; j<height; j++){ // 삼각형의 마지막 줄에 최대 값이 존재할 것이므로(삼각형의 처음에서 끝까지 업데이트) 마지막 줄의 dp만 탐색
            answer = Math.max(answer, dp[height-1][j]);
        }
        return answer;
    }
}
package BOJ;

import java.io.*;
import java.util.*;

/**
 * 최소 순회 경로가 있다면 어디서 출발하든간에 원래 위치로 돌아오기만 하면 이동한 거리는 같다 = 출발점을 0으로만 설정하고 돌려도 된다
 * https://www.acmicpc.net/board/view/29929
 */
public class BOJ2098 {
    static final int INF =  16 * 1000000; // 최대길이 16, 행렬의 최대성분 1,000,000
    static int n;
    static int[][] weight;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        weight = new int[n][n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                weight[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new long[1<<n][n];
        long ans = tsp(0,0); // 출발점: 0
        System.out.print(ans);
    }

    private static long tsp(int visit, int nowPos){
        visit |= (1<<nowPos); // 방문 체크

        // 모든 도시를 다 방문한 경우
        if(visit == (1<<n)-1){
            if(weight[nowPos][0] == 0){ // 현재 위치 -> 출발 위치로 갈 수 없으면
                return Integer.MAX_VALUE;
            }

            return weight[nowPos][0]; // 현재 위치 -> 출발 위치로 가는 비용
        }

        // 지금까지 계산된 거리 값이 있다면 그 값을 리턴해주고 중복 계산을 피한다
        if(dp[visit][nowPos] != 0){
            return dp[visit][nowPos];
        }

        // 지금까지 계산된 거리 값이 없으므로 최소 거리 계산을 위해 int 최대값으로 초기화
        dp[visit][nowPos] = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            if(i == nowPos){ // 현재 위치->현재 위치이므로 불필요한 연산
                continue;
            }
            if((visit&(1<<i))==0 && weight[nowPos][i]>0){ // 방문하지 않은 위치 && 갈 수 있으면
                dp[visit][nowPos] = Math.min(dp[visit][nowPos], tsp(visit, i) + weight[nowPos][i]); // 최소값 저장
            }
        }

        return dp[visit][nowPos];
    }
}

package BOJ;

import java.io.*;
import java.util.*;

/**
 * 최소 순회 경로가 있다면 어디서 출발하든간에 원래 위치로 돌아오기만 하면 이동한 거리는 같다 = 출발점을 0으로만 설정하고 돌려도 된다
 * https://www.acmicpc.net/board/view/29929
 */
public class BOJ10971 {
    static final int INF =  10 * 1000000; // 최대길이 10, 행렬의 최대성분 1,000,000
    static int n;
    static int[][] weight;
    static int[][] dp;

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

        dp = new int[1<<n][n];
        for(int i=0; i<(1<<n); i++){
            Arrays.fill(dp[i], INF);
        }

        int ans = tsp(0,0); // 출발점: 0
        System.out.print(ans);
    }

    private static int tsp(int visit, int nowPos){
        visit = visit | (1<<nowPos); // 지금 방문 중인 위치 체크

        // 모든 도시를 다 방문한 경우
        if(visit == (1<<n)-1){
            if(weight[nowPos][0] > 0){ // 현재 위치에서 처음 위치(0)으로 돌아가는 길이 있으면 해당 비용 반환
                return weight[nowPos][0];
            }
            return INF; // 길이 없으면 최대값 반환
        }

        // 이전에 계산한 값이 있을 경우 중복 계산을 피하기 위함
        if(dp[visit][nowPos] != INF){
            return dp[visit][nowPos];
        }

        for(int i=0; i<n; i++){
            if(i!=nowPos && (visit&(1<<i))==0 && weight[nowPos][i]>0){ // 다음으로 방문할 위치가 방문했던 점이 아니고 && 갈 수 있는 길이 있다면
                dp[visit][nowPos] = Math.min(dp[visit][nowPos], tsp(visit, i) + weight[nowPos][i]);
            }
        }

        return dp[visit][nowPos];
    }

}

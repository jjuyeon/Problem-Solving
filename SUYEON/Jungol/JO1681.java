package Jungol;

import java.io.*;
import java.util.*;

public class JO1681 {
    // 결국 N을 작게 준 문제는 그냥 브루트포스로 푸는게 맞는거 같다..

    static int n, ans;
    static int[][] weight;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = stoi(br.readLine());
        visited = new boolean[n];
        weight = new int[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                weight[i][j] = stoi(st.nextToken());
            }
        }

        ans = Integer.MAX_VALUE;
        visited[0] = true;
        dfs(0, 0, 0);
        System.out.print(ans);
    }

    private static void dfs(int now, int cost, int cnt){
        if(cost > ans) return; // 가지치기

        if(cnt == n-1){
            // 모든 장소 방문 후, 회사에 돌아와야 함
            if(weight[now][0] > 0){
                cost += weight[now][0];
                ans = Math.min(ans, cost);
            }
            return;
        }

        // 모든 장소를 한 번씩 들러 물건을 배달
        for(int i=0; i<n; i++){
            if(!visited[i] && weight[now][i]>0){
                visited[i] = true;
                dfs(i, cost+weight[now][i], cnt+1);
                visited[i] = false;
            }
        }
    }

    private static int stoi(String s){
        return Integer.parseInt(s);
    }
}

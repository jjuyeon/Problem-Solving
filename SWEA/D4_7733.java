package SWEA;

import java.util.*;

public class D4_7733 {

    static int n;
    static boolean[][] visited;
    static int[][] cheese;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            n = sc.nextInt();
            cheese = new int[n][n];
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    cheese[i][j] = sc.nextInt();
                }
            }

            int ans = 1;
            for(int day = 1; day <=100; day++){
                visited = new boolean[n][n];
                eatCheese(day);
                ans = Math.max(ans, getAreaCnt());
            }
            System.out.println("#"+test_case+" "+ans);
        }

    }

    private static void eatCheese(int day){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(cheese[i][j] <= day){
                    visited[i][j] = true;
                }
            }
        }
    }

    private static int getAreaCnt(){
        int cnt = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]){
                    visited[i][j] = true;
                    dfs(i, j);
                    ++cnt;
                }
            }
        }
        return cnt;
    }

    private static void dfs(int r, int c){
        for(int i=0; i<4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr>=0 && nr<n && nc>=0 && nc<n && !visited[nr][nc]){
                visited[nr][nc] = true;
                dfs(nr, nc);
            }
        }
    }
}

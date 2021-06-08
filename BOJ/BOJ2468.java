package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2468 {

    static int n;
    static boolean[][] visited;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = stoi(br.readLine());
        map = new int[n][n];
        boolean[] check = new boolean[101];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = stoi(st.nextToken());
                check[map[i][j]] = true;
            }
        }

        int ans = 1; // [틀린 이유] 아무 지역도 물에 잠기지 않을 수도 있다. -> 그러므로, 초기값 1로 설정!
        for(int c=100; c>=0; --c){
            if(check[c]){
                visited = new boolean[n][n];
                submerge(c);
                ans = Math.max(ans, getAreaCnt());
            }
        }

        System.out.print(ans);
    }

    private static void submerge(int num){
        for(int i=0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] <= num) {
                    visited[i][j] = true;
                }
            }
        }
    }

    private static int getAreaCnt(){
        int cnt = 0;

        for(int i=0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
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

    private static int stoi(String str){
        return Integer.parseInt(str);
    }
}

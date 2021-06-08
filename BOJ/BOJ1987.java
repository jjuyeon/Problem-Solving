package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1987 {

    static int R, C, ans;
    static boolean[][] v;
    static String[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new String[R][C];
        for(int i=0; i<R; i++){
            board[i] = br.readLine().split("");
        }

        v = new boolean[R][C];
        ans = 0;
        dfs(0,0,1, board[0][0]);
        System.out.print(ans);
    }

    static int[] dr = {-1,1,0,0}; // 상하좌우
    static int[] dc = {0,0,-1,1};
    private static void dfs(int r, int c, int cnt, String visited){
        for(int i=0; i<4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr<0 || nr>=R || nc<0 || nc>=C || v[nr][nc] || visited.contains(board[nr][nc])){
                continue;
            }

            v[nr][nc] = true;
            visited += board[nr][nc];
            dfs(nr, nc, cnt+1, visited);
            v[nr][nc] = false;
            visited = visited.replace(board[nr][nc], "");
        }

        ans = Math.max(ans, cnt);
    }
}

package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1987_bitmask {
    static int R, C, ans;
    static boolean[][] v;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        for(int i=0; i<R; i++){
            board[i] = br.readLine().toCharArray();
        }

        v = new boolean[R][C];
        ans = 0;
        dfs(0,0,1, 1<<(board[0][0]-'A'));
        System.out.print(ans);
    }

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    private static void dfs(int r, int c, int cnt, int visitedAlpha){
        for(int i=0; i<4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr<0 || nr>=R || nc<0 || nc>=C || v[nr][nc]){ // 범위 벗어나고, 방문한 위치면 패스
                continue;
            }
            if((visitedAlpha & (1<<(board[nr][nc]-'A'))) == 0){ // 아직 만난적 없는 알파벳일 때
                v[nr][nc] = true;
                dfs(nr, nc, cnt+1, visitedAlpha|(1<<(board[nr][nc]-'A')));
                v[nr][nc] = false;
            }
        }

        ans = Math.max(ans, cnt);
    }

}

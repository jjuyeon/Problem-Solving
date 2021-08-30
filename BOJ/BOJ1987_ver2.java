package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1987_ver2 {

    static int R, C, ans = 0;
    static char [][] board;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R+1][C+1];
        for (int i = 1; i <= R; i++) {
            String line = br.readLine();
            for (int j = 1; j <= C; j++) {
                board[i][j] = line.charAt(j-1);
            }
        }

        boolean[] visited = new boolean[26];
        visited[board[1][1] - 'A'] = true;
        dfs(1, 1, 1, visited);
        System.out.println(ans);
    }

    private static void dfs(int r, int c, int cnt, boolean[] visited) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr>0 && nr<=R && nc>0 && nc<=C && !visited[board[nr][nc] - 'A']) {
                visited[board[nr][nc] - 'A'] = true;
                dfs(nr, nc, cnt+1, visited);
                visited[board[nr][nc] - 'A'] = false;
            }
        }
        ans = Math.max(ans, cnt);
    }
}

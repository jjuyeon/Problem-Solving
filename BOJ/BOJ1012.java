package BOJ;

import java.util.Scanner;

public class BOJ1012 {

    static int n, m;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 0; tc < T; tc++) {
            m = sc.nextInt();
            n = sc.nextInt();
            int k = sc.nextInt();

            visited = new boolean[n][m];
            map = new int[n][m];
            for (int i = 0; i < k; i++) {
                int r = sc.nextInt();
                int c = sc.nextInt();
                map[c][r] = 1;
            }

            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        ++cnt;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 1 && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny);
            }
        }
    }
}

package BOJ;

import java.util.Scanner;

// https://www.sumyeong.kim/?p=308
// https://hibee.tistory.com/204
public class BOJ14500 {

    static int N, M, ans;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][][] exceptionDir = {
            {{0, 0}, {0, -1}, {0, 1}, {-1, 0}}, // ㅗ
            {{0, 0}, {-1, 0}, {1, 0}, {0, 1}}, // ㅏ
            {{0, 0}, {0, -1}, {0, 1}, {1, 0}}, // ㅜ
            {{0, 0}, {-1, 0}, {1, 0}, {0, -1}} // ㅓ
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        visited = new boolean[N][M];
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    dfs(i, j, 1, arr[i][j]);
                    visited[i][j] = false;

                    exception_dfs(i, j);
                }
            }
        }
        System.out.println(ans);
    }

    private static void dfs(int r, int c, int depth, int sum) {
        if (depth == 4) {
            ans = Math.max(ans, sum);
            return;
        }
        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc]) {
                visited[nr][nc] = true;
                dfs(nr, nc, depth + 1, sum + arr[nr][nc]);
                visited[nr][nc] = false;
            }
        }
    }

    private static void exception_dfs(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int sum = 0;
            boolean flag = true;
            for (int j = 0; j < 4; j++) {
                int nr = r + exceptionDir[i][j][0];
                int nc = c + exceptionDir[i][j][1];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    sum += arr[nr][nc];
                    flag = false;
                }
            }
            if(!flag)
                ans = Math.max(ans, sum);
        }
    }
}

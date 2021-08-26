package BOJ;

import java.util.*;

public class BOJ17086 {

    static int N, M;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dc = {0, 0, -1, 1, 1, -1, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int time = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0) {
                    time = Math.max(time, bfs(new int[]{i, j, 0}));
                }
            }
        }
        System.out.println(time);
    }

    private static int bfs(int[] arr) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        queue.offer(arr);
        visited[arr[0]][arr[1]] = true;

        int nr, nc, ans = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (map[now[0]][now[1]] == 1) {
                ans = now[2];
                break;
            }
            for (int i = 0; i < 8; i++) {
                nr = now[0] + dr[i];
                nc = now[1] + dc[i];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc]) {
                    queue.offer(new int[]{nr, nc, now[2] + 1});
                    visited[nr][nc] = true;
                }
            }
        }
        return ans;
    }
}

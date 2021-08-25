package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2206_ver2 {

    static int N, M;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= M; j++) {
                arr[i][j] = line.charAt(j-1);
            }
        }
        bfs();
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Pos {
        int r, c;
        int cnt;
        int drill;

        Pos(int r, int c, int cnt, int drill) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.drill = drill;
        }
    }

    private static void bfs() {
        Queue<Pos> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[2][N + 1][M + 1];
        queue.offer(new Pos(1, 1, 1, 0));
        visited[0][1][1] = true; // 벽을 안부신 경우
        visited[1][1][1] = true; // 벽을 부신 경우

        int nr, nc, cnt, drill;
        while (!queue.isEmpty()) {
            Pos now = queue.poll();
            if (now.r == N && now.c == M) {
                System.out.println(now.cnt);
                return;
            }
            for (int i = 0; i < 4; i++) {
                nr = now.r + dr[i];
                nc = now.c + dc[i];
                cnt = now.cnt;
                drill = now.drill;
                if (nr >= 1 && nr <= N && nc >= 1 && nc <= M && !visited[drill][nr][nc]) {
                    if (arr[nr][nc] == '0') {
                        queue.offer(new Pos(nr, nc, cnt+1, drill));
                        visited[drill][nr][nc] = true;
                    } else if (arr[nr][nc] == '1' && drill == 0) {
                        queue.offer(new Pos(nr, nc, cnt+1, 1));
                        visited[1][nr][nc] = true;
                    }
                }
            }
        }
        System.out.println(-1);
    }
}

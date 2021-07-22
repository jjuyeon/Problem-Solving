package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ10026 {

    static int n;
    static boolean isColor;
    static char[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        int cnt = 0;
        isColor = true;
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    color(i, j, arr[i][j]);
                    ++cnt;
                }
            }
        }
        System.out.print(cnt + " ");
        cnt = 0;
        isColor = false;
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    color(i, j, arr[i][j]);
                    ++cnt;
                }
            }
        }
        System.out.println(cnt);
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static void color(int i, int j, char color) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nr = now[0] + dr[k];
                int nc = now[1] + dc[k];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
                    if (isColor && arr[nr][nc] == color) {
                        queue.offer(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    } else if (!isColor) {
                        if (arr[nr][nc] == 'B') {
                            if (color == 'B') {
                                queue.offer(new int[]{nr, nc});
                                visited[nr][nc] = true;
                            }
                        } else {
                            if (color != 'B') {
                                queue.offer(new int[]{nr, nc});
                                visited[nr][nc] = true;
                            }
                        }
                    }
                }
            }
        }
    }
}

package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2178 {

    static int n, m;
    static int[][] arr;

    static class Point {
        int x;
        int y;
        int cnt;
        Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        bfs();
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(1, 1, 1));

        boolean[][] visited = new boolean[n][m];
        while(!queue.isEmpty()) {
            Point now = queue.poll();
            if(now.x == n && now.y == m) {
                System.out.println(now.cnt);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx < 1 || nx > n || ny < 1 || ny > m || visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                queue.offer(new Point(nx, ny, now.cnt + 1));
            }
        }
    }
}

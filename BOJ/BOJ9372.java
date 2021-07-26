package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ9372 {

    static int n;
    static boolean[] visited;
    static boolean[][] edge;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 0; tc < T; tc++) {
            n = sc.nextInt();
            int m = sc.nextInt();

            visited = new boolean[n + 1];
            edge = new boolean[n + 1][n + 1];
            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                edge[a][b] = edge[b][a] = true;
            }

            bfs();
        }
    }

    static void bfs() {
        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int now = queue.poll();
                cnt++;
                for (int j = 1; j <= n; j++) {
                    if(edge[now][j] && !visited[j]) {
                        queue.offer(j);
                        visited[j] = true;
                    }
                }
            }
        }
        System.out.println(cnt-1);
    }
}

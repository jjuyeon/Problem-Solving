package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ4485 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int problem = 1;
        while (true) {
            int N = stoi(br.readLine());
            if (N == 0) {
                return;
            }

            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = stoi(st.nextToken());
                }
            }

            System.out.println("Problem " + problem + ": " + dijkstra(N, map));
            ++problem;
        }
    }

    private static int dijkstra(int N, int[][] map) {
        final int INF = Integer.MAX_VALUE;

        boolean[][] visited = new boolean[N][N];
        int[][] minCost = new int[N][N];
        for (int i = 0; i < N; i++)
            Arrays.fill(minCost[i], INF);

        minCost[0][0] = map[0][0];

        int x = 0, y = 0, nx, ny, cost;
        while (true) {
            cost = INF;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && cost > minCost[i][j]) {
                        cost = minCost[i][j];
                        x = i;
                        y = j;
                    }
                }
            }
            if (x == N - 1 && y == N - 1) break;
            visited[x][y] = true;

            for(int d = 0; d<4; d++){
                nx = x + dx[d];
                ny = y + dy[d];
                if(nx>=0 && nx<N && ny>=0 && ny<N){
                    minCost[nx][ny] = Math.min(minCost[nx][ny], cost + map[nx][ny]);
                }
            }
        }

        return minCost[N-1][N-1];
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}

package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1238 {
    static int N;
    static int[][] adj;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int M = sc.nextInt();
        int X = sc.nextInt();

        adj = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            adj[sc.nextInt()][sc.nextInt()] = sc.nextInt();
        }

        int maxCost = 0;
        for (int i = 1; i <= N; i++) {
            if (i == X) continue;
            maxCost = Math.max(maxCost, dijkstra(i, X) + dijkstra(X, i));
        }
        System.out.print(maxCost);
    }

    private static int dijkstra(int start, int end) {
        boolean[] visited = new boolean[N + 1];
        int[] minCost = new int[N + 1];
        Arrays.fill(minCost, Integer.MAX_VALUE);

        minCost[start] = 0;
        int vertex = start, cost;
        while (true) {
            // 방문하지 않은 정점 중 다이렉트로 출발지에서 자신으로 오는 비용이 최소인 정점 선택
            cost = Integer.MAX_VALUE;
            for (int i = 1; i <= N; i++) {
                if (!visited[i] && cost > minCost[i]) {
                    cost = minCost[i];
                    vertex = i;
                }
            }
            visited[vertex] = true;
            if (vertex == end) {
                return cost;
            }

            // 현재 정점에서 경유지 거쳐서 도착하는게 더 빠를 때 업데이트
            for (int i = 1; i <= N; i++) {
                if (!visited[i] && adj[vertex][i] != 0) {
                    if (minCost[i] > cost + adj[vertex][i]) {
                        minCost[i] = cost + adj[vertex][i];
                    }
                }
            }
        }

    }
}

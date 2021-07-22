package BOJ;

import java.util.*;

public class BOJ1260_v2 {

    static ArrayList<Integer>[] edgeList;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();

        edgeList = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            edgeList[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            edgeList[x].add(y);
            edgeList[y].add(x);
        }
        for (int i = 1; i <= n; i++) {
            Collections.sort(edgeList[i]);
        }

        visited = new boolean[n+1];
        dfs(0, n, v);
        System.out.println();
        visited = new boolean[n+1];
        bfs(v);
    }

    static void dfs(int cnt, int n, int vertex) {
        if(cnt == n+1) {
            return;
        }
        System.out.print(vertex + " ");
        visited[vertex] = true;

        for (int i : edgeList[vertex]) {
            if(!visited[i]) {
                dfs(cnt+1, n, i);
            }
        }
    }

    static void bfs(int vertex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertex);
        visited[vertex] = true;
        while(!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");
            for (int i : edgeList[now]) {
                if(!visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}

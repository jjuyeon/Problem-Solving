package BOJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ1238_pq {

    static class Edge implements Comparable<Edge> {
        int end, cost;

        Edge(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o){
            return this.cost - o.cost;
        }
    }
    static int N;
    static ArrayList<Edge>[] edgeList;
    static int[] minCost;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int M = sc.nextInt();
        int X = sc.nextInt();

        edgeList = new ArrayList[N + 1];
        for(int i=1; i<=N; i++)
            edgeList[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            edgeList[sc.nextInt()].add(new Edge(sc.nextInt(), sc.nextInt()));
        }

        int[] time = new int[N+1];
        for(int i=1; i<=N; i++){ // 가는길
            if(i == X) continue;
            dijkstra(i);
            time[i] += minCost[X];

        }
        dijkstra(X); // 돌아오는길
        for(int i=1; i<=N; i++){
            if(i == X) continue;
            time[i] += minCost[i];

        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, time[i]);
        }
        System.out.print(max);
    }

    private static void dijkstra(int start){
        boolean[] visited = new boolean[N+1];
        minCost = new int[N+1];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        minCost[start] = 0;
        pq.offer(new Edge(start, 0));

        int vertex, cost;
        while(!pq.isEmpty()){
            Edge now = pq.poll();
            vertex = now.end;
            cost = now.cost;

            if(visited[vertex]) continue;
            visited[vertex] = true;


            for(Edge next : edgeList[vertex]){
                if(minCost[next.end] > cost + next.cost){
                    minCost[next.end] = cost + next.cost;
                    pq.offer(new Edge(next.end, minCost[next.end]));
                }
            }
        }
    }
}

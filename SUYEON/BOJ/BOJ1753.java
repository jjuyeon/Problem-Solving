package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1753 { // 다익스트라 문제

    static class Node implements Comparable<Node>{
        int end, cost;

        Node(int end, int cost){
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }

    static LinkedList<Node>[] graph;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = stoi(st.nextToken());
        int e = stoi(st.nextToken());

        int k = stoi(br.readLine());

        graph = new LinkedList[v+1];
        distance = new int[v+1];
        for(int i=1; i<=v; i++){
            graph[i] = new LinkedList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int from = stoi(st.nextToken());
            int to = stoi(st.nextToken());
            int weight = stoi(st.nextToken());
            graph[from].add(new Node(to, weight));
        }

        dijkstra(k);
        printDistance(v);
    }

    private static void dijkstra(int start){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        distance[start] = 0;
        queue.offer(new Node(start, 0));

        while(!queue.isEmpty()){
            Node now = queue.poll();

            if(distance[now.end] < now.cost) continue;

            for(Node next : graph[now.end]){
                if(distance[next.end] > distance[now.end] + next.cost){
                    distance[next.end] = distance[now.end] + next.cost;
                    queue.offer(new Node(next.end, distance[next.end]));
                }
            }
        }
    }

    private static void printDistance(int v) {
        for(int i=1; i<=v; i++){
            int dist = distance[i];

            if(dist == Integer.MAX_VALUE){
                System.out.println("INF");
            }
            else{
                System.out.println(dist);
            }
        }
    }

    private static int stoi(String s){
        return Integer.parseInt(s);
    }
}

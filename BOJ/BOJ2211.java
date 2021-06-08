import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int end;
    int cost;

    public Node(int end, int cost){
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o){
        return this.cost - o.cost;
    }
}

public class BOJ2211 { // implement 'dijkstra algorithm' using priority queue
    static LinkedList<Node>[] graph;
    static int[] parent;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = stoi(st.nextToken());
        int m = stoi(st.nextToken());

        graph = new LinkedList[n+1];
        for(int i=1; i<=n; i++)
            graph[i] = new LinkedList<>();

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = stoi(st.nextToken());
            int v2 = stoi(st.nextToken());
            int cost = stoi(st.nextToken());
            graph[v1].add(new Node(v2,cost));
            graph[v2].add(new Node(v1,cost));
        }

        dijkstra(1, n);
        printAnswer(1, n);
    }

    static void printAnswer(int start, int n){
        System.out.println(n-1); // 무조건 간선의 수는 (정점의 수 - 1)
        for(int i=1; i<=n; i++){
            if(i == start) continue;
            System.out.println(parent[i] + " " + i);
        }
    }

    static void dijkstra(int start, int n){
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        parent = new int[n+1];

        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, dist[start]));

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(now.cost > dist[now.end]) // 이미 더 짧은 거리가 업데이트 되어있는 경우 생략
                continue;

            for(Node next : graph[now.end]){ // graph[now.v]에는 현재 정점 v에 인접한 노드들이 저장되어 있음
                if(dist[next.end] > (dist[now.end] + next.cost)){
                    dist[next.end] = dist[now.end] + next.cost;
                    parent[next.end] = now.end;
                    pq.add(new Node(next.end, dist[next.end]));
                }
            }
        }
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}

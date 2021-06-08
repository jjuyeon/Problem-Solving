import java.util.*;
import java.io.*;

class Node10282 implements Comparable<Node10282>{
    int end;
    int cost;

    public Node10282(int end, int cost){
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node10282 o){
        return this.cost-o.cost;
    }
}

public class BOJ10282 {
    static LinkedList<Node10282>[] graph;
    static int[] dist;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = stoi(br.readLine());
        for(int i=0; i<testCase; i++){
            st = new StringTokenizer(br.readLine());
            int n = stoi(st.nextToken());
            int d = stoi(st.nextToken());
            int c = stoi(st.nextToken()); // start vertex

            makeSet(n);

            for(int j=0; j<d; j++){ // 그래프 완성
                st = new StringTokenizer(br.readLine());
                int a = stoi(st.nextToken());
                int b = stoi(st.nextToken());
                int s = stoi(st.nextToken());
                graph[b].add(new Node10282(a,s));
            }

            dijkstra(c);
            answer(n);
        }
    }

    static void makeSet(int n){
        graph = new LinkedList[n+1];
        dist = new int[n+1];

        for(int i=1; i<=n; i++){
            graph[i] = new LinkedList<>();
            dist[i] = Integer.MAX_VALUE;
        }
    }

    static void dijkstra(int start){
        dist[start] = 0;
        PriorityQueue<Node10282> pq = new PriorityQueue<>();
        pq.add(new Node10282(start, dist[start]));

        while(!pq.isEmpty()){
            Node10282 now = pq.poll();

            if(dist[now.end] < now.cost)
                continue;

            for(Node10282 next : graph[now.end]){ // 다음 노드(now.end)와 인접한 노드에 대해서만 탐색
                if(dist[next.end] > (dist[now.end] + next.cost)){
                    dist[next.end] = dist[now.end] + next.cost;
                    pq.add(new Node10282(next.end, dist[next.end]));
                }
            }
        }
    }

    static void answer(int n){
        int computer = 0;
        int time = 0;

        for(int i=1; i<=n; i++){
            if(dist[i] != Integer.MAX_VALUE){
                computer++;
                time = Math.max(time, dist[i]); // [시작점-해당점]까지의 최소 거리가 이미 다 계산되어 저장되어 있으므로 최종으로 업데이트된 거리를 찾으면 됨.
            }
        }
        System.out.println(computer + " " + time);
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}

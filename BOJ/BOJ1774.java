package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1774 { // 전형적인 MST 문제 -> kruskal 알고리즘 사용

    static class Edge implements Comparable<Edge> {
        int start, end;
        double cost;

        Edge(int start, int end, double cost){
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o){
            if(this.cost > o.cost){
                return 1;
            }
            else if(this.cost == o.cost){
                return 0;
            }
            return -1;
        }
    }

    static int[] parent, rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = stoi(st.nextToken());
        int m = stoi(st.nextToken());

        int[][] vertex = new int[n+1][2];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            vertex[i][0] = stoi(st.nextToken());
            vertex[i][1] = stoi(st.nextToken());
        }

        parent = new int[n+1]; // 초기화
        rank = new int[n+1];
        for(int i=1; i<=n; i++){
            parent[i] = i;
            rank[i] = 0;
        }

        for(int i=0; i<m; i++){ // 이미 연결된 통로는 union으로 합쳐준다
            st = new StringTokenizer(br.readLine());
            union(stoi(st.nextToken()), stoi(st.nextToken()));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>(); // 최적화: PriorityQueue 사용
        for(int i=1; i<=n; i++){
            for(int j=i+1; j<=n; j++){
                double cost = Math.sqrt(Math.pow(vertex[i][0]-vertex[j][0], 2) + Math.pow(vertex[i][1]-vertex[j][1], 2));
                pq.add(new Edge(i, j, cost)); // 간선을 기준으로 진행되므로, 간선 하나만 넣어주면 됨
            }
        }

        double ans = 0;
        while(!pq.isEmpty()){
            Edge now = pq.poll(); // 간선의 가중치가 작은 값부터 나옴
            if(union(now.start, now.end)){
                ans += now.cost;
            }
        }

        System.out.print(String.format("%.2f", ans));
    }

    private static int find(int a){
        if(parent[a] == a) return a;
        return find(parent[a]);
    }

    private static boolean union(int a, int b){
        a = find(a);
        b = find(b);

        if(a == b) return false;

        if(rank[a] > rank[b]){
            parent[b] = a;
        }
        else {
            parent[a] = b;
        }
        if(rank[a] == rank[b]){
            ++rank[b];
        }

        return true;
    }

    private static int stoi(String str){
        return Integer.parseInt(str);
    }
}

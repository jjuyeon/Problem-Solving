package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1647 { // kruskal 사용 -> parent가 2개가 될때까지 union이니까 간선이 n-2개가 선택될 때 끝낸다

    static class Edge implements Comparable<Edge> {
        int from, to, cost;
        Edge(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o){ // 오름차순
            return this.cost - o.cost;
        }
    }

    static int[] parent, rank;
    static Edge[] edgeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = stoi(st.nextToken());
        int m = stoi(st.nextToken());

        edgeList = new Edge[m];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            edgeList[i] = new Edge(stoi(st.nextToken()), stoi(st.nextToken()), stoi(st.nextToken()));
        }
        Arrays.sort(edgeList); // 오름차순으로 최소 간선부터 뽑아내도록 한다

        makeSet(n); // 배열 초기화
        kruskal(n, m);
    }

    private static void makeSet(int n){
        parent = new int[n+1];
        rank = new int[n+1];
        for(int i=1; i<=n; i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    private static void kruskal(int n, int m){
        int sum = 0, cnt = 0;
        for(int i=0; i<m; i++){
            Edge edge = edgeList[i];
            if(union(edge.from, edge.to)){ // 합칠 수 있으면 간선 하나 추가되는 것!
                sum += edge.cost; // 비용 업데이트
                ++cnt; // 간선 수 업데이트
            }

            if(cnt == n-2){ // 간선이 n-1개일 때 하나로 합쳐지므로, 간선이 n-2개가 선택될 때 끝낸다
                break;
            }
        }
        System.out.print(sum);
    }

    private static int find(int a){ // 부모 찾기
        if(parent[a] == a) return a;
        return find(parent[a]);
    }

    private static boolean union(int a, int b){ // 합치기
        a = find(a);
        b = find(b);

        if(a == b) return false;

        if(rank[a] > rank[b]){ // rank 사용해서 최적화
            parent[b] = a;
        }
        else{
            parent[a] = b;
        }
        if(rank[a] == rank[b]){
            ++rank[b];
        }
        return true;
    }

    private static int stoi(String s){
        return Integer.parseInt(s);
    }
}

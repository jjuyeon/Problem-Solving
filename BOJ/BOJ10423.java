import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge>{
    int v1;
    int v2;
    int cost;

    public Edge(int v1, int v2, int cost){
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o){
        if(this.cost > o.cost)
            return 1; // 기준 값이 비교 대상보다 더 크다
        else if(this.cost == o.cost)
            return 0;
        else
            return -1;
    }
}

public class BOJ10423 { // using kruskal algorithm
    static ArrayList<Edge> edgeList;
    static int[] parent;
    static int[] rank;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = stoi(st.nextToken());
        int m = stoi(st.nextToken());
        int k = stoi(st.nextToken());

        parent = new int[n+1];
        rank = new int[n+1];
        for(int i=1; i<=n; i++){
            parent[i] = i;
            rank[i] = 0;
        }

        st = new StringTokenizer(br.readLine());
        int standard = stoi(st.nextToken());
        for(int i=1; i<k; i++){
            int power = stoi(st.nextToken());
            union(standard, power);
        }

        edgeList = new ArrayList<>();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int u = stoi(st.nextToken());
            int v = stoi(st.nextToken());
            int w = stoi(st.nextToken());
            edgeList.add(new Edge(u,v,w));
        }

        Collections.sort(edgeList);

        int sum = 0;
        for (Edge edge : edgeList) {
            if (!isSameParent(edge.v1, edge.v2)) {
                sum += edge.cost;
                union(edge.v1, edge.v2);
            }
        }

        System.out.print(sum);
    }

    static void union(int v1, int v2){
        v1 = find(v1);
        v2 = find(v2);

        if(v1 == v2) return;

        if(rank[v1] < rank[v2]){
            parent[v1] = v2;
        }else{
            parent[v2] = v1;
            if(rank[v1] == rank[v2]){
                rank[v1]++;
            }
        }
    }

    static int find(int v){
        if(parent[v] == v){
            return v;
        }

        return parent[v] = find(parent[v]);
    }

    static boolean isSameParent(int v1, int v2){
        v1 = find(v1);
        v2 = find(v2);
        return (v1 == v2);
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}

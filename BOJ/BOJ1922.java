import java.util.*;
import java.io.*;

class Edge1922 implements Comparable<Edge1922>{
    int v1;
    int v2;
    int cost;

    public Edge1922(int v1, int v2, int cost){
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge1922 o){
        return this.cost - o.cost;
    }
}

public class BOJ1922 {
    static ArrayList<Edge1922> edgeList;
    static int[] parent;
    static int[] rank;

    public static void main(String[] args) throws IOException{ //using kruskal algorithm
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = stoi(br.readLine());
        int m = stoi(br.readLine());

        parent = new int[n+1];
        rank = new int[n+1];
        for(int i=1; i<=n; i++){
            parent[i] = i;
            rank[i] = 0;
        }

        edgeList = new ArrayList<>();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            int c = stoi(st.nextToken());
            edgeList.add(new Edge1922(a,b,c));
        }

        Collections.sort(edgeList); // 오름차순 정렬

        int sum = 0;
        for(int i=0; i<edgeList.size(); i++){
            Edge1922 now = edgeList.get(i);
            if(!isSameParent(now.v1, now.v2)){
                sum += now.cost;
                union(now.v1, now.v2);
            }
        }

        System.out.print(sum);
    }

    static boolean isSameParent(int v1, int v2){
        if(find(v1) == find(v2))
            return true;
        return false;
    }

    static void union(int v1, int v2){
        v1 = find(v1);
        v2 = find(v2);

        if(v1 == v2)
            return;

        if(rank[v1] < rank[v2]){
            parent[v1] =v2;
        }else{
            parent[v2] = v1;

            if(rank[v1] == rank[v2])
                rank[v1]++;
        }
    }

    static int find(int v){
        if(parent[v] == v)
            return v;
        return parent[v] = find(parent[v]);
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}

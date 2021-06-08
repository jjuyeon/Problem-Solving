import java.util.*;
import java.io.*;

class Edge16202 implements Comparable<Edge16202>{
    int v1;
    int v2;
    int cost;

    Edge16202(int v1, int v2, int cost){
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge16202 e){
        return this.cost - e.cost;
    }
}

public class BOJ16202 { // using kruskal
    static ArrayList<Edge16202> edgeList;
    static int[] parents;
    static int[] ranks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = stoi(st.nextToken());
        int m = stoi(st.nextToken());
        int k = stoi(st.nextToken());

        edgeList = new ArrayList<>();
        parents = new int[n+1];
        ranks = new int[n+1];

        for(int i=1; i<=m; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = stoi(st.nextToken());
            int v2 = stoi(st.nextToken());
            edgeList.add(new Edge16202(v1,v2,i));
        }

        Collections.sort(edgeList);

        for(int i=0; i<k; i++){
            int answer = makeMST(n);
            sb.append(answer).append(" ");

            if(answer != 0){
                edgeList.remove(0);
            }
        }

        System.out.println(sb.toString());
    }

    static int makeMST(int n){
        int sum = 0, edgeCount = 0;
        for(int i=1; i<=n; i++){
            parents[i] = i;
            ranks[i] = 0;
        }

        for(Edge16202 edge : edgeList){
            if(!isSameParent(edge.v1, edge.v2)){
                sum += edge.cost;
                union(edge.v1, edge.v2);
                edgeCount++;
            }
        }

        return (edgeCount == n-1) ? sum : 0;
    }

    static boolean isSameParent(int v1, int v2){
        v1 = find(v1);
        v2 = find(v2);
        return v1 == v2;
    }

    static void union(int v1, int v2){
        v1 = find(v1);
        v2 = find(v2);

        if(v1 == v2){
            return;
        }

        if(ranks[v1] < ranks[v2]){
            parents[v1] = v2;
        }else{
            parents[v2] = v1;
            if(ranks[v1] == ranks[v2]){
                ranks[v1]++;
            }
        }
    }

    static int find(int v){
        if(parents[v] == v){
            return v;
        }
        return parents[v] = find(parents[v]);
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}

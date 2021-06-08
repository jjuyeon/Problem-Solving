import java.util.*;
import java.io.*;

// Edge의 가중치를 오름차순하기 위해서 Edge 객체 필요
// 정렬의 기준을 정하는 방법: Comparable 인터페이스 구현(여기선 Edge 객체의 가중치를 기준으로 정렬)
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
            return 1;
        else if(this.cost == o.cost)
            return 0;
        else
            return -1;
    }
}

// 사이클을 형성하는 간선인지 확인하기 위해 union-find 연산 필요
public class BOJ1197_ver_kruskal {
    static ArrayList<Edge> edgeList; // 오름차순한 edge의 가중치를 저장하기 위해 만든 자료구조
    static int[] parent; // union-find를 위해 만든 자료구조
    static int[] rank; // union 연산을 최적화하기 위해 만든 자료구조

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        parent = new int[v+1];
        rank = new int[v+1];
        for(int i=1; i<=v; i++){
            parent[i] = i;
            rank[i] = 0;
        }

        edgeList = new ArrayList<>();
        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edgeList.add(new Edge(v1, v2, cost));
        }
        Collections.sort(edgeList); // 가중치를 기준으로 오름차순으로 나열

        int sum = 0;
        for(int i=0; i<edgeList.size(); i++){
            Edge edge = edgeList.get(i); // 가중치 제일 높은 edge 부터 탐색하는게 kruskal 알고리즘!
            if(!isSameParent(edge.v1, edge.v2)){ // 같은 부모가 아니라면 같은 집합에 속해있지 않으므로 MST가 될 수 있음
                sum += edge.cost;
                union(edge.v1, edge.v2); // MST집합으로 합쳐줌
            }
        }

        System.out.print(sum);
    }

    public static boolean isSameParent(int v1, int v2){
        v1 = find(v1);
        v2 = find(v2);
        if(v1 == v2)
            return true;
        else
            return false;
    }

    public static void union(int v1, int v2){
        v1 = find(v1);
        v2 = find(v2);

        if(v1 == v2) return; // 이미 같은 집합

        // union-by-rank 사용
        if(rank[v1] < rank[v2]){ // 깊이가 더 깊은 트리로 합치기
            parent[v1] = v2;
        }else{
            parent[v2] = v1;

            if(rank[v1] == rank[v2])
                rank[v1]++;
        }
    }

    public static int find(int v){
        if(parent[v] == v) // 부모(최상위)노드
            return v;

        return parent[v] = find(parent[v]); // 최상위 부모 노드를 찾을 때까지 타고 올라감
    }
}
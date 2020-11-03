import java.util.*;
import java.io.*;

// Edge의 가중치를 오름차순하기 위해서 Edge 객체 필요
// 정렬의 기준을 정하는 방법: Comparable 인터페이스 구현(여기선 Edge 객체의 가중치를 기준으로 정렬)
class Edge_prim implements Comparable<Edge_prim> {
    int v1;
    int v2;
    int cost;

    public Edge_prim(int v1, int v2, int cost){
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge_prim o){
        if(this.cost > o.cost)
            return 1;
        else if(this.cost == o.cost)
            return 0;
        else
            return -1;
    }
}

public class BOJ1197_ver_prim {
    // 시작 정점에서부터 출발하여 신장트리 집합을 단계적으로 확장해 나가는 방법

    static boolean visited[];
    static LinkedList<Edge_prim>[] graph;
    static ArrayList<Edge_prim> MST;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        visited = new boolean[v+1];
        graph = new LinkedList[v+1];
        for(int i=1; i<=v; i++)
            graph[i] = new LinkedList<>();

        for(int i=1; i<=e; i++){ // 그래프 형성
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[v1].add(new Edge_prim(v1,v2,cost));
            graph[v2].add(new Edge_prim(v2,v1,cost));
        }

        MST = new ArrayList<>();
        System.out.print(makeMST(1));
    }

    static int makeMST(int start){
        //1.시작정점 아무거나 지정
        //2.선택한 정점에 연결된 간선들을 우선순위 큐에 집어넣는다.
        //3.우선순위 큐에서 간선 poll하면 제일 짧은애가 나온다. 그 끝에 정점이 이미 방문한 정점이 아니라면 해당간선 선택한다.
        //4. 2~3 반복. n-1개의 간선이 선택할때까지 or 모든 정점이 연결될때까지

        int sum = 0;
        PriorityQueue<Edge_prim> pq = new PriorityQueue<>();
        Queue<Integer> q = new LinkedList<>(); // 정점 방문 스케줄을 위한 자료구조

        q.add(start);

        while(!q.isEmpty()){
            int now = q.poll();
            visited[now] = true; // 방문했음을 체크

            for(Edge_prim edge : graph[now]){ // 현재 정점 now에서 연결된 간선들 중
                if(!visited[edge.v2]) // 방문한 적 없는 정점으로 가는 간선(v1->v2) 체크
                    pq.add(edge); // 방문한 적 없는 간선들은 우선순위 큐에 넣는다
            }

            while(!pq.isEmpty()){
                Edge_prim edge = pq.poll(); // 지금 들어있는 간선들 중 제일 가중치 낮은 간선
                if(!visited[edge.v2]){ // 현재 우선순위 큐에서 나온 간선이 방문한 적 없는 간선이라면
                    q.add(edge.v2); // 정점으로 선택 됨, 정점 방문 스케줄에 추가
                    sum += edge.cost; // 가중치 추가
                    //visited[edge.v2] = true; // 방문했음을 체크
                    MST.add(edge); // 방문이 끝난 정점은 MST 집합에 추가
                    break; // 한 단계에 한 개의 간선씩만 뽑아가야 하므로 break
                }
            }
        }

        return sum;
    }
}

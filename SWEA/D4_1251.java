package SWEA;

import java.util.*;

// 4월 12일 유튜브 수업
// MST
// 1) Prim(정점 중심)
//    : 인접행렬 - 밀집그래프 유리
//    : 인접리스트 - 희소그래프 유리
//    +) PriorityQueue 사용
// 2) Kruskal(간선 중심)
//    : 간선리스트

// 현재 문제는 밀집그래프이므로, Prim을 사용할 때, 밀집 그래프에 유리한 인접행렬을 쓰는 것이 좋다
// new long[1000][1000] => 8*1,000,000 = 8MB
// 메모리상으로 봤을 때, 인접리스트로 사용하는 건 메모리 사용만 늘어난다

// kruskal 사용시, 간선리스트의 최대크기 = n*(n-1)/2
// 그러므로, 메모리상, 시간상 Prim의 인접행렬 방법을 사용하는 것이 좋다!

/////////////////////////////////////////////////
/* 문제 시간복잡도 정리
    - 문제 조건: 밀집그래프 -> 정점에 비해 간선 多
    - 간선 개수가 (정점개수)^2개 ..!

    1) PQ X Prim
        : O(V^2)
    2) PQ Prim
        : O(V^2 * logV)
    3) Kruskal
        : 간선리스트 정렬하는 시간이 대부분(오래걸림)
            -> Quick Sort : O(NlogN) => O(ElogE) => O(V^2 * logV^2)
*/
////////////////////////////////////////////////
public class D4_1251 {

    static class Edge implements Comparable<Edge>{
        int end;
        double cost;
        Edge(int end, double cost){
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

    static LinkedList<Edge>[] graph;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int[] x = new int[n];
            int[] y = new int[n];
            for(int i=0; i<n; i++){
                x[i] = sc.nextInt();
            }
            for(int i=0; i<n; i++){
                y[i] = sc.nextInt();
            }
            double e = sc.nextDouble();

            graph = new LinkedList[n];
            for(int i=0; i<n; i++){
                graph[i] = new LinkedList<>();
            }
            for(int i=0; i<n; i++){
                for(int j=i+1; j<n; j++){
                    double cost = (Math.pow(x[i]-x[j], 2) + Math.pow(y[i]-y[j], 2));
                    graph[i].add(new Edge(j, cost));
                    graph[j].add(new Edge(i, cost));
                }
            }

            double ans = Math.min(Double.MAX_VALUE, prim(0, n));
            System.out.println("#"+test_case+" "+Math.round(ans*e));
        }
    }

    // 시간복잡도: V*log(V) + E*log(V) = (V+E)*log(V) => 모든 정점이 연결되어있으므로 (V+V^2)*log(V) = V^2*log(V)
    // 즉, 최종 시간복잡도: V^2*log(V) .. 겁나 오래걸림 .. ㅠ
    // 교훈 : PQ를 쓰는게 항상 최적화가 되는건 아니다!
    private static double prim(int start, int n){
        boolean[] visited = new boolean[n];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        double sum = 0;
        while(!queue.isEmpty()){
            int now = queue.poll(); // 정점 수만큼 뽑는다 -> V*log(V)

            for(Edge edge : graph[now]){
                if(!visited[edge.end]){
                    pq.offer(edge);
                }
            }

            while(!pq.isEmpty()){
                Edge nowEdge = pq.poll();
                if(!visited[nowEdge.end]){ // 업데이트마다 PQ에 넣는다
                    sum += nowEdge.cost;
                    // 총 간선 수만큼 넣는다 -> 간선수E*log(V)
                    // 현재 문제는 밀집 그래프 -> 간선의 수가 V^2
                    queue.offer(nowEdge.end);
                    visited[nowEdge.end] = true;
                    break;
                }
            }
        }

        return sum;
    }

}

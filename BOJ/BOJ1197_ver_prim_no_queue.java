package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1197_ver_prim_no_queue {

    static class Edge {
        int to, weight;
        Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = stoi(st.nextToken());
        int e = stoi(st.nextToken());

        LinkedList<Edge>[] graph = new LinkedList[v+1];
        for(int i=1; i<=v; i++){
            graph[i] = new LinkedList<>();
        }

        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = stoi(st.nextToken());
            int v2 = stoi(st.nextToken());
            int weight = stoi(st.nextToken());
            graph[v1].add(new Edge(v2, weight));
            graph[v2].add(new Edge(v1, weight));
        }

        boolean[] visited = new boolean[v+1];
        int[] minDist = new int[v+1];
        for(int i=1; i<=v; i++){
            minDist[i] = Integer.MAX_VALUE;
        }

        int weight = 0;
        minDist[1] = 0; // 시작 정점을 1로 설정

        for(int i=0; i<v; i++){
            int min = Integer.MAX_VALUE;
            int curVertex = 1;

            // 현재 상태에서 가장 최소 비용을 가지는 정점을 찾는다
            for(int j=1; j<=v; j++){
                if(!visited[j] && min>minDist[j]){
                    min = minDist[j];
                    curVertex = j;
                }
            }
            // 해당 정점 방문 처리 및 가중치 업데이트
            weight += min;
            visited[curVertex] = true;

            // 현재 정점을 포함했을 때, 최소 비용 간선 찾아 업데이트
            for(Edge adjEdge : graph[curVertex]){
                // 저장되어 있는 간선보다, 현재 정점을 지나가는 간선이 더 최소비용일 때 업데이트
                if(!visited[adjEdge.to] && minDist[adjEdge.to] > adjEdge.weight){
                    minDist[adjEdge.to] = adjEdge.weight;
                }
            }
        }

        System.out.print(weight);
    }

    private static int stoi(String s){
        return Integer.parseInt(s);
    }
}

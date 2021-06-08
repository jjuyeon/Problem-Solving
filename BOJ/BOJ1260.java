package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1260 {

    static boolean[] visited;
    static ArrayList<Integer>[] vertexList;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi(st.nextToken());
        int m = stoi(st.nextToken());
        int startV = stoi(st.nextToken());

        vertexList = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            vertexList[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int from = stoi(st.nextToken());
            int to = stoi(st.nextToken());
            vertexList[from].add(to); // 방향이 없음(양방향)
            vertexList[to].add(from);
        }

        // "방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문" 조건때문에 sort 해줘야 함
        for(int i=1; i<n+1; i++){
            Collections.sort(vertexList[i]);
        }

        visited = new boolean[n+1];
        dfs(startV);
        sb.append("\n");
        visited = new boolean[n+1];
        bfs(startV);
        System.out.print(sb.toString());
    }

    // 큐
//    static void bfs(int vertex){
//        Queue<Integer> queue = new LinkedList<>();
//        queue.offer(vertex);
//
//        while(!queue.isEmpty()){
//            int nowV = queue.poll();
//            if(!visited[nowV]) {
//                visited[nowV] = true; // 이렇게 하면 안됨, 값이 커지면 큐가 터짐
//                sb.append(nowV).append(" ");
//                for (int v : vertexList[nowV]) {
//                    queue.offer(v);
//                }
//            }
//        }
//    }

    static void bfs(int vertex){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(vertex);
        visited[vertex] = true; // 이렇게 큐에 넣었을 때 바로 visited값을 true로 업데이트해줘야함
        while(!queue.isEmpty()){
            int nowV = queue.poll();
            sb.append(nowV).append(" ");
            for(int v : vertexList[nowV]){
                if(!visited[v]){
                    queue.offer(v);
                    visited[v] = true; // 이렇게 큐에 넣었을 때 바로 visited값을 true로 업데이트해줘야함
                }
            }
        }
    }

    // 재귀
    static void dfs(int vertex){
        visited[vertex] = true;
        sb.append(vertex).append(" ");

        for(int v : vertexList[vertex]){
            if(!visited[v]) {
                dfs(v);
            }
        }
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}

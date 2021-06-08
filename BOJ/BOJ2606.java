package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2606 {

    static int n, ans;
    static ArrayList<Integer>[] vertexList;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = stoi(br.readLine());
        visited = new boolean[n+1];
        vertexList = new ArrayList[n+1]; // vertex가 1부터 시작
        for(int i=1; i<=n; i++){ // 초기화
            vertexList[i] = new ArrayList<>();
        }

        int m = stoi(br.readLine());
        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            vertexList[a].add(b);
            vertexList[b].add(a); // 양방향 간선
        }

        ans = 0;
        dfs(1);
        System.out.print(ans);
    }

    private static void dfs(int searchV){
        visited[searchV] = true;
        for(int vertex : vertexList[searchV]){
            if(!visited[vertex]){
                ans++;
                dfs(vertex);
            }
        }
    }

    private static int stoi(String str){
        return Integer.parseInt(str);
    }
}

package SWEA;

import java.util.*;

public class D4_1238 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int len = sc.nextInt();
            int start = sc.nextInt();

            LinkedList<Integer>[] adjList = new LinkedList[101];
            for(int i=1; i<=100; i++){
                adjList[i] = new LinkedList<>();
            }
            for(int i=0; i<len; i+=2){
                adjList[sc.nextInt()].add(sc.nextInt());
            }

            System.out.println("#"+test_case+" "+bfs(start, adjList));
        }
    }

    private static int bfs(int start, LinkedList<Integer>[] adj){
        boolean[] visited = new boolean[101];
        Queue<int[]> queue = new LinkedList<>();
        LinkedList<int[]> contactList = new LinkedList<>();

        queue.offer(new int[]{start, 0});
        visited[start] = true;

        int cnt = 0;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            contactList.add(now);
            cnt = now[1];

            for(int i : adj[now[0]]){
                if(!visited[i]){
                    visited[i] = true;
                    queue.offer(new int[]{i, cnt+1});
                }
            }
        }

        int ans = 0;
        for (int[] arr : contactList) {
            if (arr[1] == cnt) {
                ans = Math.max(ans, arr[0]);
            }
        }
        return ans;
    }
}

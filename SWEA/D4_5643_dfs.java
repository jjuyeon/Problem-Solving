package SWEA;

import java.util.Scanner;

public class D4_5643_dfs {

    static int N;
    static int[][] height;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            int M = sc.nextInt();
            height = new int[N+1][N+1];
            for(int i=0; i<M; i++){
                int from = sc.nextInt();
                int to = sc.nextInt();
                height[from][to] = 1;
                height[to][from] = -1;
            }

            int ans = 0;
            for(int i=1; i<=N; i++){
                boolean[] visited = new boolean[N+1];
                dfs(i, visited, 1);
                dfs(i, visited, -1);
                if(isAllVisited(visited)) ++ans;
            }
            System.out.println("#"+test_case + " "+ans);
        }
    }

    private static void dfs(int num, boolean[] visited, int upDown){
        visited[num] = true;
        for(int i=1; i<=N; i++){
            if(!visited[i] && height[num][i] == upDown){
                dfs(i, visited, upDown);
            }
        }
    }
    private static boolean isAllVisited(boolean[] visited){
        for(int i=1; i<=N; i++){
            if(!visited[i]) return false;
        }
        return true;
    }
}

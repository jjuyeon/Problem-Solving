package BOJ;

import java.util.Scanner;

// https://data-make.tistory.com/568
public class BOJ2458_memoization {

    static int N;
    static int[][] height;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int M = sc.nextInt();
        height = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++)
            height[i][0] = -1;

        for (int i = 0; i < M; i++)
            height[sc.nextInt()][sc.nextInt()] = 1;

        // 현재 노드보다 키가 큰 노드(from -> to) 체크
        for (int i = 1; i <= N; i++) {
            if (height[i][0] == -1) {
                gtDFS(i);
            }
        }
        // 현재 노드보다 키가 작은 노드 체크
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                height[0][j] += height[i][j];
            }
        }
        int ans = 0;
        for(int j=1; j<=N; j++){
            if(height[j][0] + height[0][j] == N-1) ++ans;
        }
        System.out.print(ans);
    }

    private static void gtDFS(int num){
        for(int i=1; i<=N; i++){
            if(height[num][i] == 1){
                // i까지 큰 노드가 몇개인지 탐색이 안되어있음 -> 먼저 탐색 필요
                if(height[i][0] == -1){
                    gtDFS(i);
                }
                if(height[i][0] > 0){ // i까지 탐색했을 때 키가 큰 노드가 존재한다면 업데이트 계산 필요
                    // i 노드가 num 노드보다 키가 더 크므로, 당연히 j 노드도 num 노드보다 크다
                    for(int j=1; j<=N; j++){
                        if(height[i][j] == 1){
                            height[num][j] = 1;
                        }
                    }
                }
            }
        }

        // 업데이트 완료 ^ㅡ^
        int cnt = 0;
        for(int j=1; j<=N; j++){
            if(height[num][j] == 1) ++cnt;
        }
        height[num][0] = cnt;
    }
}

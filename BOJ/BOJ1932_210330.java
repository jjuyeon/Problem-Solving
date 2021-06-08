package BOJ;

import java.util.Scanner;

public class BOJ1932_210330 {

    static int n;
    static int[][] tri, visited;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        visited = new int[n][n];
        tri = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                tri[i][j] = sc.nextInt();
                visited[i][j] = -1;
            }
        }

//        System.out.print(recursive(0, 0)); // 재귀
        System.out.print(dynamic()); // dp
    }

    private static int dynamic(){
        int[][] dp = new int[n][n];
        dp[0][0] = tri[0][0];

        for(int i=1; i<n; i++){
            dp[i][0] = dp[i-1][0] + tri[i][0]; // left
            dp[i][i] = dp[i-1][i-1] + tri[i][i]; // right
        }
        for(int i=2; i<n; i++){ // mid
            for(int j=1; j<i; j++){
                dp[i][j] = tri[i][j] + Math.max(dp[i-1][j] , dp[i-1][j-1]);
            }
        }

        int ans = 0;
        for(int i=0; i<n; i++){
            ans = Math.max(ans, dp[n-1][i]);
        }
        return ans;
    }

    private static int recursive(int row, int col){
        if(visited[row][col] != -1) return visited[row][col]; // 방문했으면 더 이상 불필요한 계산 안하도록 함(가지치기)
        if(row == n-1) return tri[row][col]; // 리프노드에 오면 현재 값 리턴
        return visited[row][col] = Math.max(recursive(row+1, col)+tri[row][col], recursive(row+1, col+1)+tri[row][col]); // 그 당시에 최대 값 저장
    }
}

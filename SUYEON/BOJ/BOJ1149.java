package BOJ;

import java.util.Scanner;

// 참고 : https://st-lab.tistory.com/128

public class BOJ1149 {

    static int n;
    static int[][] color, dp;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        color = new int[n][3];
        for(int i=0; i<n; i++){
            for(int j=0; j<3; j++){
                color[i][j] = sc.nextInt();
            }
        }

        dp = new int[n][3];
        for(int i=0; i<3; i++){
            dp[0][i] = color[0][i];
        }

        int red = dfs(n-1, 0);
        int green = dfs(n-1, 1);
        int blue = dfs(n-1, 2);

        System.out.print(Math.min(red, Math.min(green, blue)));
    }

    private static int dfs(int n, int sel){
        if(dp[n][sel] == 0){
            if(sel == 0){
                dp[n][0] = Math.min(dfs(n-1, 1), dfs(n-1, 2)) + color[n][0];
            }
            else if(sel == 1){
                dp[n][1] += Math.min(dfs(n-1, 0), dfs(n-1, 2)) + color[n][1];
            }
            else if(sel == 2){
                dp[n][2] += Math.min(dfs(n-1, 0), dfs(n-1, 1)) + color[n][2];
            }
        }

        return dp[n][sel];
    }
}

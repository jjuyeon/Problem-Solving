package SWEA;

import java.util.Scanner;

public class D2_2001 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[][] matrix = new int[n][n];
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++)
                    matrix[i][j] = sc.nextInt();
            }

            int max = Integer.MIN_VALUE;
            for(int i=0; i<=n-m; i++){
                for(int j=0; j<=n-m; j++){
                    int sum = 0;
                    for(int x = i; x<i+m; x++){
                        for(int y = j; y<j+m; y++)
                            sum += matrix[x][y];
                    }
                    max = Math.max(sum, max);
                }
            }

            System.out.printf("#%d %d%n", test_case, max);
        }
    }
}

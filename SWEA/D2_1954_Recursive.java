package SWEA;

import java.io.*;

public class D2_1954_Recursive {

    static int[][] puzzle;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T= Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = Integer.parseInt(br.readLine());
            puzzle = new int[n][n];
            recursive(0, -1, n, 1, 1);

            System.out.println("#"+test_case);
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    System.out.print(puzzle[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    static void recursive(int x, int y, int n, int dir, int val){
        if(n==0)
            return;

        for(int i=0; i<2*n-1; i++){
            if(i<n){
                y+=dir;
            }else{
                x+=dir;
            }
            puzzle[x][y] = val++;
        }
        recursive(x, y, n-1, -dir, val);
    }
}

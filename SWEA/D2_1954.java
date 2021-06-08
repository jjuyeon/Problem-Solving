package SWEA;

import java.io.*;

public class D2_1954 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T= Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = Integer.parseInt(br.readLine());

            if(n == 1) {
                System.out.println("#"+test_case);
                System.out.println(1);
                continue;
            }

            int[][] puzzle = new int[n][n];
            int x=0, y=0;

            int[] directionX = {0,1,0,-1};
            int[] directionY = {1,0,-1,0};
            int direction = 0;

            for(int i=1; i<=n*n; i++){
                puzzle[x][y] = i; // 값 업데이트

                x += directionX[direction];
                y += directionY[direction]; // 방향 업데이트

                if(x<0 || y<0 || x>=n || y>=n){ // 범위를 벗어남
                    x -= directionX[direction];
                    y -= directionY[direction];

                    direction = (direction + 1) % 4;

                    x += directionX[direction];
                    y += directionY[direction];
                }

                if(puzzle[x][y] != 0){ // 달팽이처럼 안으로 꼬아 들어갈 때
                    x -= directionX[direction];
                    y -= directionY[direction];

                    direction = (direction + 1) % 4;

                    x += directionX[direction];
                    y += directionY[direction];
                }
            }

            System.out.println("#"+test_case);
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    System.out.print(puzzle[i][j]+" ");
                }
                System.out.println();
            }
        }
    }
}

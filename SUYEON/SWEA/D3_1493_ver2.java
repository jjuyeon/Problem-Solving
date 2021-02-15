package SWEA;

import java.util.Scanner;

public class D3_1493_ver2 {

    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();

        // map에 값 미리 만들기
        int[][] points = new int[301][301];
        int val = 1;
        for (int i = 0; i <= 300; i++) {
            for (int j = i; j >= 0; j--) {
                points[i - j][j] = val++;
            }
        }

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int p = sc.nextInt();
            int q = sc.nextInt();

            int px=0, py=0, qx=0, qy=0;
            for(int i=0; i<=300; i++){
                for(int j=0; j<=300; j++){
                    if(points[i][j] == p){
                        px = i;
                        py = j;
                    }
                    if(points[i][j] == q){
                        qx = i;
                        qy = j;
                    }
                }
            }

            sb.append("#").append(test_case).append(" ").append(points[px+qx+1][py+qy+1]).append("\n");
        }

        System.out.print(sb.toString());
    }
}

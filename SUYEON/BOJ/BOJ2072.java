package BOJ;

import java.util.Scanner;

public class BOJ2072 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[20][20]; // index 1~19

        int[] dr = {-1,1,0,0,-1,1,-1,1}; // 상하 / 좌우 / 좌상->우하 / 우상->좌하
        int[] dc = {0,0,-1,1,-1,1,1,-1};

        for(int ans=1; ans<=n; ans++){ // 흑:1, 백:2
            int r = sc.nextInt();
            int c = sc.nextInt();
            int color = (ans%2==0)? 2 : 1;
            map[r][c] = color;

            for(int d=0; d<8; d+=2){
                int omokCount = 1;
                for(int i=d; i<=d+1; i++){
                    int nr = r+dr[i];
                    int nc = c+dc[i];
                    while(nr>=1 && nr<=19 && nc>=0 && nc<=19 && map[nr][nc]==color){
                        ++omokCount;
                        nr += dr[i];
                        nc += dc[i];
                    }
                }
                if(omokCount == 5){
                    System.out.print(ans);
                    return;
                }
            }
        }

        System.out.print(-1);
    }
}

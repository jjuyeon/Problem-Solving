package BOJ;

import java.util.Scanner;

public class BOJ10163 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[101][101];

        for(int num=1; num<=n; num++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int width = sc.nextInt();
            int height = sc.nextInt();

            for(int i=x; i<x+width; i++){
                for(int j=y; j<y+height; j++){
                    map[i][j] = num;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int num=1; num<=n; num++){
            int count = 0;
            for(int i=0; i<101; i++){
                for(int j=0; j<101; j++){
                    if(map[i][j] == num){
                        ++count;
                    }
                }
            }
            sb.append(count).append("\n");
        }

        System.out.print(sb.toString());
    }
}

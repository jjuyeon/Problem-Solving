package SWEA;

import java.util.Scanner;

public class D4_1210_recursive {

    static int[][] ladder;

    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int T = sc.nextInt();

            int x = -1;
            int y = -1;
            ladder = new int[100][100];
            for(int i=0; i<100; i++){
                for(int j=0; j<100; j++){
                    ladder[i][j] = sc.nextInt();
                    if(ladder[i][j] == 2){
                        x = i;
                        y = j;
                    }
                }
            }
            sb.append("#").append(T).append(" ").append(recursive(x, y, 2)).append("\n");
        }
        System.out.print(sb.toString());
    }

    static int recursive(int x, int y, int nowDirection){
        if(x == 0) {
            return y;
        }

        if(nowDirection!=1 && y-1>=0 && ladder[x][y-1]>0){ // 좌(위로 올라가는 것보다 우선 순위가 높음)
            nowDirection = 0; // 현재 좌로 이동 중임을 나타냄
            y -= 1;
        }

        if(nowDirection!=0 && y+1<100 && ladder[x][y+1]>0){ // 우(위로 올라가는 것보다 우선 순위가 높음)
            nowDirection = 1; // 현재 우로 이동 중임을 나타냄
            y += 1;
        }

        if(ladder[x-1][y] == 1){ // 연속되는 좌우 이동이 끝나면
            nowDirection = 2; // 좌로 가든 우로 가든 상관없으므로 바꿔줌
            x -= 1;
        }

        return recursive(x, y, nowDirection);
    }
}

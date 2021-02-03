package SWEA;

import java.util.Scanner;

public class D4_1210_loop {
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int T = sc.nextInt();

            int x = -1;
            int y = -1;
            int[][] ladder = new int[100][100];
            for(int i=0; i<100; i++){
                for(int j=0; j<100; j++){
                    ladder[i][j] = sc.nextInt();
                    if(ladder[i][j] == 2){
                        x = i;
                        y = j;
                    }
                }
            }

            // 좌우에 사다리가 없으면 무조건 위로 올라감
            // 밑으로는 안내려감(왜? 사다리를 밑에서부터 위로 타고 올라가는 중임)

            int nowDirection = 2; // 좌<->우로 반복되는 것을 막아주는 변수
            while(x > 0){
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
            }

            sb.append("#").append(T).append(" ").append(y).append("\n");
        }
        System.out.print(sb.toString());
    }
}

package BOJ;

import java.util.*;
import java.io.*;

public class BOJ14891 {

    static char[][] status;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        status = new char[4][8];
        for(int i=0; i<4; i++){
            status[i] = br.readLine().toCharArray();
        }

        int k = Integer.parseInt(br.readLine());
        for(int l=0; l<k; l++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1; // index가 0부터 시작하므로
            int dir = Integer.parseInt(st.nextToken());

            int[] turningNum = new int[4]; // index: 톱니바퀴 번호, value: 방향

            turningNum[num] = dir; // 기준 톱니바퀴 정보 저장

            int searchIdx = num-1, searchDir = -dir; // 기준 톱니바퀴 왼쪽 검사
            while(searchIdx>=0){
                if(status[searchIdx][2] == status[searchIdx+1][6]){ // 현재 톱니바퀴가 못움직이면 이후것도 못움직임
                    break;
                }
                else{
                    turningNum[searchIdx] = searchDir;
                    searchDir *= -1;
                }

                --searchIdx;
            }

            searchIdx = num+1; searchDir = -dir; // 기준 톱니바퀴 오른쪽 검사
            while(searchIdx<=3){
                if(status[searchIdx-1][2] == status[searchIdx][6]){
                    break;
                }
                else{
                    turningNum[searchIdx] = searchDir;
                    searchDir *= -1;
                }

                ++searchIdx;
            }

            // 돌리기
            for(int i=0; i<4; i++){
                int val = turningNum[i];
                if(val != 0){
                    turn(i, val);
                }
            }
        }


        // 점수 구하기
        int ans = 0;
        for(int i=0; i<4; i++){
            if(status[i][0] == '1'){
                ans += fac(i);
            }
        }
        System.out.print(ans);
    }

    private static void turn(int num, int dir){
        if(dir == 1) { // 시계방향
            char temp = status[num][7];
            System.arraycopy(status[num], 0, status[num], 1, 7);
            status[num][0] = temp;
        }
        else if(dir == -1){ // 반시계방향
            char temp = status[num][0];
            System.arraycopy(status[num], 1, status[num], 0, 7);
            status[num][7] = temp;
        }
    }

    private static int fac(int i){
        if(i==0){
            return 1;
        }
        return 2*fac(i-1);
    }
}

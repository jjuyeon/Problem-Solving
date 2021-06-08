package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2477 {

    static class Pos {
        int dir;
        int len;

        Pos(int dir, int len){
            this.dir = dir;
            this.len = len;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        int x=0, y=0;
        Pos[] orders = new Pos[7];
        for(int i=0; i<6; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            orders[i] = new Pos(dir, len); // 방향 정보, 길이 정보를 저장하면서

            if(dir==1 || dir==2){ // x, y의 최대값을 같이 찾는다
                x = Math.max(x, len);
            }
            else if(dir==3 || dir==4){
                y = Math.max(y, len);
            }
        }
        orders[6] = orders[0]; // 마지막 입력 값 -> 처음 입력 값도 탐색하기 위해, 배열의 끝에 처음 입력 위치를 넣어준다

        int[] head = {1, 4, 2, 3}; // 작은 사각형이 될 수 있는 방향 순서에 대한 모든 경우의 수
        int[] tail = {3, 1, 4, 2};

        boolean flag = false;
        for(int i=1; i<7; i++){
            for(int d=0; d<4; d++){
                if(orders[i-1].dir==head[d] && orders[i].dir==tail[d]){
                    System.out.print(k * (x*y - orders[i-1].len*orders[i].len));
                    flag = true; // 한번만 검사하면 되므로 사용한 변수
                    break;
                }
            }
            if(flag){ // 찾았다면 바로 반복문을 끝내고 프로그램을 종료한다
                break;
            }
        }
    }
}

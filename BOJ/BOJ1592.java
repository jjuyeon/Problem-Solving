package BOJ;

import java.util.*;
import java.io.*;

public class BOJ1592 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int answer = 0;
        int[] players = new int[N];

        int nowPlayer = 0; // 처음 player는 0번째 인덱스이므로
        players[0] = 1; // 지금 받은 공도 포함시킴
        while(players[nowPlayer] < M){
            if(players[nowPlayer] % 2 == 0){ // 짝수(반시계방향)
                nowPlayer -= L;
                if(nowPlayer < 0){
                    nowPlayer += N;
                }
            }
            else{ // 홀수(시계방향)
                nowPlayer = (nowPlayer + L) % N;
            }
            players[nowPlayer]++;
            answer++;
        }

        System.out.print(answer);
    }
}

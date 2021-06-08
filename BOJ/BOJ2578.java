package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2578 {

    static int[][] game;
    static boolean[][] isVisited;
    static boolean leftDiagonal, rightDiagonal;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        game = new int[5][5];
        isVisited = new boolean[5][5];
        for(int i=0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                game[i][j] = stoi(st.nextToken());
            }
        }
        int[] bingoNum = new int[25];
        for(int i=0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                bingoNum[5*i+j] = stoi(st.nextToken());
            }
        }

        // bingo start
        int cnt, bingoCnt = 0;
        for(cnt=0; cnt<25; cnt++){
            if(bingoCnt >= 3){
                break;
            }
            int[] location = findLocation(bingoNum[cnt]);
            bingoCnt += check_bingo(location[0], location[1]);
        }

        System.out.println(cnt);
    }

    static int check_bingo(int x, int y){
        isVisited[x][y] = true;
        int i, cnt = 0;

        // 가로
        for(i=0; i<5; i++){
            if(!isVisited[x][i]){
                break;
            }
        }
        if(i==5){
            cnt++;
        }

        // 세로
        for(i=0; i<5; i++){
            if(!isVisited[i][y]){
                break;
            }
        }
        if(i==5){
            cnt++;
        }

        // 왼쪽 대각선
        if(!leftDiagonal){
            for(i=0; i<5; i++){
                if(!isVisited[i][i]){
                    break;
                }
            }
            if(i==5){
                leftDiagonal = true;
                cnt++;
            }
        }

        if(!rightDiagonal) {
            // 오른쪽 대각선
            for (i = 0; i < 5; i++) {
                if (!isVisited[i][4 - i]) {
                    break;
                }
            }
            if (i == 5) {
                rightDiagonal = true;
                cnt++;
            }
        }

        return cnt;
    }

    static int[] findLocation(int n){
        int[] result = new int[2];
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(game[i][j] == n){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}

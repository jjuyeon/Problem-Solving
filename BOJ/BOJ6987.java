package BOJ;

import java.io.*;
import java.util.*;

public class BOJ6987 {

    static boolean isRight;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int l=0; l<4; l++){
            int[] win = new int[6];
            int[] draw = new int[6];
            int[] lose = new int[6];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum = 0;
            for(int i=0; i<6; i++){
                sum += win[i] = Integer.parseInt(st.nextToken());
                sum += draw[i] = Integer.parseInt(st.nextToken());
                sum += lose[i] = Integer.parseInt(st.nextToken());
            }
            if(sum != 30){
                sb.append(0).append(" ");
                continue;
            }

            /* 총 15가지 경우
            a: b,c,d,e,f
            b: c,d,e,f
            c: d,e,f
            d: e,f
            e: f
            */

            int[] team1 = {0,0,0,0,0,1,1,1,1,2,2,2,3,3,4};
            int[] team2 = {1,2,3,4,5,2,3,4,5,3,4,5,4,5,5};

            isRight = false;
            dfs(0, win, draw, lose, team1, team2);
            if(isRight) sb.append(1).append(" ");
            else sb.append(0).append(" ");
        }

        System.out.print(sb.toString());
    }

    private static void dfs(int game, int[] win, int[] draw, int[] lose, int[] team1, int[] team2){
        if(game == 15){
            int cnt = 0;
            for(int i=0; i<6; i++){
                if(win[i]==0 && draw[i]==0 && lose[i]==0){
                    ++cnt;
                }
            }
            if(cnt==6){
                isRight = true;
            }
            return;
        }

        int t1 = team1[game];
        int t2 = team2[game];
        // 승리하는 경우
        if(win[t1]>0 && lose[t2]>0){
            --win[t1]; --lose[t2];
            dfs(game+1, win, draw, lose, team1, team2);
            ++win[t1]; ++lose[t2];
        }
        // 비기는 경우
        if(draw[t1]>0 && draw[t2]>0){
            --draw[t1]; --draw[t2];
            dfs(game+1, win, draw, lose, team1, team2);
            ++draw[t1]; ++draw[t2];
        }
        // 지는 경우
        if(lose[t1]>0 && win[t2]>0){
            --lose[t1]; --win[t2];
            dfs(game+1, win, draw, lose, team1, team2);
            ++lose[t1]; ++win[t2];
        }
    }
}

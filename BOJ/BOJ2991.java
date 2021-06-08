package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2991 {

    static int a,b,c,d;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = stoi(st.nextToken());
        b = stoi(st.nextToken());
        c = stoi(st.nextToken());
        d = stoi(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int p = stoi(st.nextToken()); // 우체부의 도착 시간
        int m = stoi(st.nextToken()); // 우유배달원의 도착 시간
        int n = stoi(st.nextToken()); // 신문배달원의 도착 시간

        sb.append(attackDog(p)).append("\n");
        sb.append(attackDog(m)).append("\n");
        sb.append(attackDog(n));
        System.out.print(sb.toString());
    }

    static int attackDog(int time){
        int attackCnt = 0;
        int routine_forA, routine_forB;
        boolean attackTime_forA = false, attackTime_forB = false;
        for(int i=1; i<=time; i++){
            routine_forA = i % (a+b);
            routine_forB = i % (c+d);
            if(routine_forA <= a && routine_forA > 0){ // 개A 공격시간
                attackTime_forA = true;
            }else{
                attackTime_forA = false;
            }

            if(routine_forB <= c && routine_forB > 0){ // 개B 공격시간
                attackTime_forB = true;
            }else{
                attackTime_forB = false;
            }
        }

        if(attackTime_forA) attackCnt++;
        if(attackTime_forB) attackCnt++;
        return attackCnt;
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}

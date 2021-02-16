package Jungol;

import java.io.*;
import java.util.*;

public class JO1828 {

    static class Chemistry implements Comparable<Chemistry>{
        int minus, plus;

        Chemistry(int minus, int plus){
            this.minus = minus;
            this.plus = plus;
        }

        @Override
        public int compareTo(Chemistry o){
            if(this.minus == o.minus){
                return this.plus - o.plus;
            }
            return this.minus - o.minus;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        Chemistry[] temper = new Chemistry[n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            temper[i] = new Chemistry(stoi(st.nextToken()), stoi(st.nextToken()));
        }
        Arrays.sort(temper);

        int count = 1;
        int from = temper[0].minus;
        int to = temper[0].plus;
        for(int i=1; i<n; i++){
            // from update 부분
            if(temper[i].minus < to){
                from = temper[i].minus;
            }
            // to update 부분
            if(temper[i].plus < to){
                to = temper[i].plus;
            }

            // 범위를 아예 벗어난 부분
            if(to < temper[i].minus){
                count++;
                from = temper[i].minus;
                to = temper[i].plus;
            }
        }
        System.out.print(count);
    }

    private static int stoi(String str){
        return Integer.parseInt(str);
    }
}

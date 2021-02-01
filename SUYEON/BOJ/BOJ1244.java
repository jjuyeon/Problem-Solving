package BOJ;

import java.util.*;
import java.io.*;

public class BOJ1244 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = stoi(br.readLine());
        int[] state = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            state[i] = stoi(st.nextToken());
        }

        int M =stoi(br.readLine());
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int gender = stoi(st.nextToken());
            int number = stoi(st.nextToken()); // 인덱스 1부터 시작

             if(gender == 1){ // 배수만큼 업데이트
                 for(int j=number; j<=N; j+=number){
                     state[j] = (state[j] == 0)? 1 : 0;
                 }
             }
             else if(gender == 2){
                 int start = number;
                 int end = number;
                 while(true){
                     int ns = start - 1;
                     int ne = end + 1;

                     if(ns <= 0 || ne > N) { // 범위 넘어가면 끝냄
                         break;
                     }

                     if(state[ns] != state[ne]){ // 값이 대칭되지 않으면 끝냄
                         break;
                     }

                     start = ns;
                     end = ne;
                 }
                 for(int j=start; j<=end; j++){ // 해당되는 범위만큼 업데이트
                     state[j] = (state[j] == 0)? 1 : 0;
                 }
             }
        }
        for(int i=1; i<=N; i++){
            sb.append(state[i]).append(" ");
            if(i%20 == 0){
                sb.append("\n");
            }
        }

        System.out.print(sb.toString());
    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}

package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2961 {

    static long ans;
    static int N;
    static int[] S, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());
        S = new int[N];
        B = new int[N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            S[i] = stoi(st.nextToken());
            B[i] = stoi(st.nextToken());
        }

        ans = Long.MAX_VALUE;
        combination(0, 1, 0);
        System.out.print(ans);
    }

    private static void combination(int cnt, long mul, long sum){
        if(cnt == N){
            if(sum!=0) { // 재료는 적어도 하나 사용해야함
                ans = Math.min(ans, Math.abs(mul - sum));
            }
            return;
        }

        // 뽑은 경우
        combination(cnt+1, mul*S[cnt], sum+B[cnt]);
        // 안뽑은 경우
        combination(cnt+1, mul, sum);
    }

    private static int stoi(String str){
        return Integer.parseInt(str);
    }
}

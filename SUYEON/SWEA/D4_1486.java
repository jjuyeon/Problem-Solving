package SWEA;

import java.util.*;

public class D4_1486 {

    static int[] H;
    static int ans, N, B;

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = sc.nextInt();
            B = sc.nextInt();
            H = new int[N];
            for(int i=0; i<N; i++) {
                H[i] = sc.nextInt();
            }

            ans = Integer.MAX_VALUE;
            for(int i=0; i<N; i++){
                for(int j=1; j<=N; j++){
                    combination(i, j, H[i]);
                }
            }
            sb.append("#").append(test_case).append(" ").append(ans-B).append("\n");
        }
        System.out.print(sb.toString());
    }
    static void combination(int n, int r, int sum){
        if(r == 0){
            if(sum >= B){
                ans = Math.min(ans, sum);
            }
            return;
        }

        for(int i=n+1; i<N; i++){
            combination(i, r-1, sum + H[i]);
        }
    }
}

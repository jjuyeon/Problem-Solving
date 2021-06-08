package SWEA;

import java.util.*;

public class D3_5215_combination {

    static class Hamburger{
        int score;
        int kal;

        public Hamburger(int score, int kal){
            this.score = score;
            this.kal = kal;
        }
    }

    static Hamburger[] arr;
    static int N, L, bestScore;

    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = sc.nextInt();
            L = sc.nextInt();
            arr = new Hamburger[N];
            for(int i=0; i<N; i++){
                arr[i] = new Hamburger(sc.nextInt(), sc.nextInt());
            }

            bestScore = 0;
            for(int i=0; i<N; i++){ // 모든 햄버거가 적어도 한번씩 선택되도록 한다
                for(int j=1; j<=N; j++){ // 선택된 햄버거에 대해서 경우의 수 개수를 정해준다
                    combination(i, j, 0, 0);
                }
            }

            sb.append("#").append(test_case).append(" ").append(bestScore).append("\n");
        }

        System.out.print(sb.toString());
    }

    private static void combination(int n, int r, int score_sum, int kal_sum){
        if(r == 0){
            if(kal_sum <= L){
                bestScore = Math.max(bestScore, score_sum);
            }
            return;
        }
        for(int i=n; i<N; i++){ // 중복조합이 아니므로 인자에 i+1 , 하나 선택했으므로 r-1
            combination(i+1, r-1, score_sum+arr[i].score, kal_sum+arr[i].kal);
        }
    }
}
package SWEA;

import java.util.Scanner;

public class D3_5215_powerSet {

    static int[] score, kal;
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
            score = new int[N];
            kal = new int[N];
            for(int i=0; i<N; i++){
                score[i] = sc.nextInt();
                kal[i] = sc.nextInt();
            }

            bestScore = 0;
            powerSet(0, new boolean[N]);

            sb.append("#").append(test_case).append(" ").append(bestScore).append("\n");
        }

        System.out.print(sb.toString());
    }

    private static void powerSet(int idx, boolean[] selected){
        if(idx == N){ // 다 뽑았을 경우, 최대 점수 비교
            int sumKal = 0, sumScore = 0;
            for(int i=0; i<N; i++){
                if(selected[i]) {
                    sumKal += kal[i];
                    sumScore += score[i];
                }
            }
            if(sumKal <= L){
                bestScore = Math.max(bestScore, sumScore);
            }
            return;
        }

        // 뽑은 경우
        selected[idx] = true;
        powerSet(idx+1, selected);

        // 안뽑은 경우
        selected[idx] = false;
        powerSet(idx+1, selected);
    }
}
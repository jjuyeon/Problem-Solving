package SWEA;

import java.util.Scanner;

public class D3_5215_combination2 {

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
            combination(0, 0, 0);

            sb.append("#").append(test_case).append(" ").append(bestScore).append("\n");
        }

        System.out.print(sb.toString());
    }

    private static void combination(int count, int sumScore, int sumKal){
        if(sumKal > L){ // 뽑다가 L을 초과하면 바로 해당 경우의 수 구하기를 끝냄(뒤로 가도 승산 없음)
            return;
        }

        if(count == N){ // 다 뽑았을 경우, 최대 점수 비교
            bestScore = Math.max(bestScore, sumScore);
            return;
        }

        // 뽑은 경우
        combination(count+1, sumScore+score[count], sumKal+kal[count]);

        // 안뽑은 경우(안뽑은 경우도 경우의 수로 쳐서 count + 1 해주지만, 나머지 값들은 업데이트해주지 않음)
        combination(count+1, sumScore, sumKal);
    }
}
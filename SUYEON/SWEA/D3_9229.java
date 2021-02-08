package SWEA;

import java.util.Scanner;

public class D3_9229 {

    static int n, m, result;
    static int[] weights;

    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            n = sc.nextInt();
            m = sc.nextInt();
            weights = new int[n];
            for(int i=0; i<n; i++){
                weights[i] = sc.nextInt();
            }

            result = -1;
            knapsack();
//            knapsack(0,0,0);
            sb.append("#").append(test_case).append(" ").append(result).append("\n");
        }

        System.out.print(sb.toString());
    }

    static void knapsack(){
        for(int i=0; i<n; i++){
            if(weights[i] > m){
                continue;
            }
            for(int j=i+1; j<n; j++){
                if(weights[i] + weights[j] <= m){
                    result = Math.max(result, weights[i] + weights[j]);
                }
            }
        }
    }

    // recursive
    static void knapsack(int idx, int cnt, int sum){
        if(sum > m || cnt > 2){ // 기저조건(무게 m을 초과거나 count가 2를 넘어가면 바로 끝냄)
            return;
        }
        if(idx == n){ // 기저조건
            if(cnt == 2){
                result = Math.max(result, sum);
            }
            return;
        }

        // 선택한 경우
        knapsack(idx+1, cnt+1, sum+weights[idx]);
        // 선택하지 않은 경우
        knapsack(idx+1, cnt, sum);
    }
}

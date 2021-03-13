package BOJ;

import java.util.*;

public class BOJ14888 {

    static long max, min;
    static int n;
    static int[] numbers;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        numbers = new int[n];
        for(int i=0; i<n; i++){
            numbers[i] = sc.nextInt();
        }

        int plus = sc.nextInt();
        int minus = sc.nextInt();
        int multiply = sc.nextInt();
        int division = sc.nextInt();

        max = -1000000000; // 최소 -10억
        min = 1000000000; // 최대 10억
        dfs(numbers[0], 1, plus, minus, multiply, division);
        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(long result, int idx, int plus, int minus, int multiply, int division){
        if(idx == n){ // 기저조건 (현재 계산결과와 max/min값 업데이트)
            max = Math.max(result, max);
            min = Math.min(result, min);
            return;
        }

        if(plus>0) { // 덧셈 횟수가 남아있다면
            dfs(result + numbers[idx], idx + 1, plus - 1, minus, multiply, division);
        }
        if(minus>0) { // 뺄셈 횟수가 남아있다면
            dfs(result - numbers[idx], idx + 1, plus, minus - 1, multiply, division);
        }
        if(multiply>0) { // 곱셈 횟수가 남아있다면
            dfs(result * numbers[idx], idx + 1, plus, minus, multiply - 1, division);
        }
        if(division>0) { // 나눗셈 횟수가 남아있다면
            dfs(result / numbers[idx], idx + 1, plus, minus, multiply, division - 1);
        }
    }
}

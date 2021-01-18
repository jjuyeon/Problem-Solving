package SWEA;

import java.util.Scanner;

public class D2_1859 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        /**
         * 문제 풀기 전 input, output 범위부터 파악하자
         */

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }

            int standard = arr[n-1];
            long result = 0;
            for(int i=n-2; i>=0; i--){
                if(standard > arr[i]){
                    result += standard - arr[i];
                }else{
                    standard = arr[i];
                }
            }

            System.out.printf("#%d %d%n", test_case, result);
        }
    }
}

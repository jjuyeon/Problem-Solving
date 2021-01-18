package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class D2_1959 {
    static int small, big;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            small = sc.nextInt();
            big = sc.nextInt();

            int[] arrS, arrB;
            if(small<=big){
                arrS = new int[small];
                arrB = new int[big];
                for(int i=0; i<small; i++){
                    arrS[i] = sc.nextInt();
                }
                for(int i=0; i<big; i++){
                    arrB[i] = sc.nextInt();
                }

            }else{
                swap();
                arrS = new int[small];
                arrB = new int[big];
                for(int i=0; i<big; i++){
                    arrB[i] = sc.nextInt();
                }
                for(int i=0; i<small; i++){
                    arrS[i] = sc.nextInt();
                }
            }

            int max = -1000;
            for(int i=small-1; i<big; i++){
                int sum = 0;
                int idx_s = small-1, idx_b = i;
                while(idx_s >= 0){
                    sum += arrS[idx_s] * arrB[idx_b];
                    idx_b--; idx_s--;
                }
                max = Math.max(sum, max);
            }
            System.out.printf("#%d %d%n", test_case, max);
        }

    }

    static void swap(){
        int temp = small;
        small = big;
        big = temp;
    }
}

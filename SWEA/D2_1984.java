package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class D2_1984 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int[] arr = new int[10];
            for(int i=0; i<10; i++)
                arr[i] = sc.nextInt();

            Arrays.sort(arr);
            double sum = 0;
            for(int i=1; i<9; i++){
                sum += arr[i];
            }

            int mean = (int) Math.round(sum/8);
            System.out.printf("#%d %d%n", test_case, mean);
        }
    }
}

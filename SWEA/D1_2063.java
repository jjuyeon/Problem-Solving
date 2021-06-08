package SWEA;

import java.util.Scanner;
import java.util.Arrays;

public class D1_2063 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        int[] arr = new int[T];
        for(int test_case = 1; test_case <= T; test_case++)
        {
            arr[test_case-1] = sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(arr[T/2]);
    }
}

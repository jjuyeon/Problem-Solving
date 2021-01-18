package SWEA;

import java.util.Scanner;

public class D2_1284 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int p =sc.nextInt();
            int q = sc.nextInt();
            int r = sc.nextInt();
            int s = sc.nextInt();
            int w = sc.nextInt();

            // A회사 vs B회사
            int A = w*p;
            int B = q;
            if(w>r){
                B += s*(w-r);
            }
            int min = Math.min(A, B);

            System.out.printf("#%d %d%n", test_case, min);
        }
    }
}

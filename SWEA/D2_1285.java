package SWEA;

import java.util.Scanner;

// 자바 지원안되서 제출은 못함
public class D2_1285 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int min = 1000000;
            int min_count = 0;
            for(int i=0; i<n; i++){
                int compare = Math.abs(sc.nextInt());
                if(compare < min){
                    min = compare;
                    min_count = 1;
                }else if(compare == min){
                    min_count++;
                }
            }
            System.out.printf("#%d %d %d", test_case, min, min_count);
        }
    }
}

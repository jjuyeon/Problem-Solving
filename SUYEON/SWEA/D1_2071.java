package SWEA;

import java.util.Scanner;

public class D1_2071 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            double round = 0;
            for(int i=0; i<10; i++){
                round += sc.nextInt();
            }
            System.out.println("#" + test_case + " " + Math.round(round/10));
        }
    }
}

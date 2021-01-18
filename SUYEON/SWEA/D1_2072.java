package SWEA;

import java.util.Scanner;

public class D1_2072 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int sum = 0;
            for(int i=1; i<=10; i++){
                int num = sc.nextInt();
                if(num % 2 == 1){
                    sum+=num;
                }
            }
            System.out.println("#"+test_case+" "+sum);
        }
    }
}

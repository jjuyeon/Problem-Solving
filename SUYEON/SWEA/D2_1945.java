package SWEA;

import java.util.Scanner;

public class D2_1945 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int num = sc.nextInt();
            int a=-1, b=0, c=0, d=0, e=0;
            while(num % 11 == 0){
                e++;
                num /= 11;
            }
            while(num % 7 == 0){
                d++;
                num /= 7;
            }
            while(num % 5 == 0){
                c++;
                num /= 5;
            }
            while(num % 3 == 0){
                b++;
                num /= 3;
            }
            while(num != 0){
                a++;
                num /= 2;
            }

            System.out.println(String.format("#%d %d %d %d %d %d", test_case, a, b, c, d, e));
        }
    }
}

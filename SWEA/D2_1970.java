package SWEA;

import java.util.Scanner;

public class D2_1970 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++){
            int[] money_kinds = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
            int[] money_count = new int[8];

            int money = sc.nextInt();
            for(int i=0; i<money_kinds.length; i++){
                money_count[i] = money / money_kinds[i];
                money %= money_kinds[i];
            }

            StringBuilder sb = new StringBuilder();
            for(int i=0; i<8; i++)
                sb.append(money_count[i]).append(" ");
            System.out.printf("#%d%n%s%n", test_case, sb.toString());
        }
    }
}

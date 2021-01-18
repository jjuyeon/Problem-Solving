package SWEA;

import java.util.Scanner;

public class D2_1948 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int start_month = sc.nextInt();
            int start_day = sc.nextInt();
            int end_month = sc.nextInt();
            int end_day = sc.nextInt();

            int[] days = {-1, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

            int result;
            if(start_month == end_month) {
                result = end_day - start_day + 1;
            }else {
                result = days[start_month] - start_day + 1; // start month부터 처리
                for(int i=start_month+1; i<end_month; i++)
                    result += days[i];
                result += end_day; // end month 처리
            }

            System.out.printf("#%d %d%n", test_case, result);
        }

    }
}

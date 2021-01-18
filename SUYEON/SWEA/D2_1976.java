package SWEA;

import java.util.Scanner;

public class D2_1976 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++){
            int hour1 = sc.nextInt();
            int minute1 = sc.nextInt();
            int hour2 = sc.nextInt();
            int minute2 = sc.nextInt();

            int minute = minute1 + minute2;
            int hour = hour1 + hour2;

            if(minute >= 60){
                hour += 1;
                minute -= 60;
            }
            if(hour >= 13){
                hour -= 12;
            }

            System.out.printf("#%d %d %d%n", test_case, hour, minute);
        }
    }
}

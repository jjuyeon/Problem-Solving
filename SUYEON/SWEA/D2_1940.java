package SWEA;

import java.util.Scanner;

public class D2_1940 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int speed = 0;
            int distance = 0;

            for(int i=0; i<n; i++){
                int command = sc.nextInt();
                if(command == 1){
                    speed += sc.nextInt();
                }else if(command == 2){
                    speed += -sc.nextInt();
                }

                if(speed < 0)
                    speed = 0;

                distance += speed;
            }
            System.out.printf("#%d %d%n", test_case, distance);
        }
    }
}

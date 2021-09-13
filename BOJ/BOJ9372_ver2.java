package BOJ;

import java.util.Scanner;

public class BOJ9372_ver2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            for (int i = 0; i < M; i++) {
                sc.nextInt();
                sc.nextInt();
            }

            System.out.println(N - 1);
        }
    }
}

package BOJ;

import java.util.Scanner;

public class BOJ10163_ver2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matrix = new int[1001][1001];
        int N = sc.nextInt();

        for (int test_case = 1; test_case <= N; test_case++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int w = sc.nextInt();
            int h = sc.nextInt();
            
            for (int i = x; i < x + w; i++) {
                for (int j = y; j < y + h; j++) {
                    matrix[i][j] = test_case;
                }
            }
        }

        for (int test_case = 1; test_case <= N; test_case++) {
            int answer = 0;
            for (int i = 0; i < 1001; i++) {
                for (int j = 0; j < 1001; j++) {
                    if(matrix[i][j] == test_case) answer++;
                }
            }
            System.out.println(answer);
        }
    }
}

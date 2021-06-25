package Jungol;

import java.util.Arrays;
import java.util.Scanner;

public class JO1339 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n%2 == 0 || n < 1 || n > 100) {
            System.out.println("INPUT ERROR");
        } else {
            char[][] arr = new char[n][n];
            char a = 'A';
            for (int i = 0; i < n; i++) {
                Arrays.fill(arr[i], ' ');
            }

            for (int i = n / 2; i >= 0; i--) {
                for (int j = i; j < n-i; j++) {
                    arr[j][i] = a++;
                    if (a > 'Z') a = 'A';
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.printf("%c ", arr[i][j]);
                }
                System.out.println();
            }
        }
    }
}

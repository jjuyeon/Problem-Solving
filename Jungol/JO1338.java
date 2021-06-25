package Jungol;

import java.util.Arrays;
import java.util.Scanner;

public class JO1338 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        char[][] arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(arr[i], ' ');
        }

        char a = 'A';
        for (int i = 0; i < n; i++) {
            for (int j = i, k = n - 1; j < n; j++, k--) {
                arr[j][k] = a++;
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

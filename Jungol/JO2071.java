package Jungol;

import java.util.Scanner;

public class JO2071 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][n];

        // 바깥쪽만 1로 설정
        for (int i = 0; i < n; i++) {
            arr[i][0] = arr[i][i] = 1;
        }
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < n - 1; j++) {
                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
            }
        }

        switch (m) {
            case 1:
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (arr[i][j] == 0) break;
                        System.out.printf("%d ", arr[i][j]);
                    }
                    System.out.println();
                }
                break;
            case 2:
                for (int i = n-1; i >= 0; i--) {
                    for (int j = 0; j < n - 1 - i; j++) {
                        System.out.print(" ");
                    }
                    for (int j = 0; j < n; j++) {
                        if(arr[i][j] == 0) break;
                        System.out.printf("%d ", arr[i][j]);
                    }
                    System.out.println();
                }
                break;
            case 3:
                for (int i = n-1; i >= 0; i--) {
                    for (int j = n-1; j >= 0; j--) {
                        if(arr[j][i] == 0) break;
                        System.out.printf("%d ", arr[j][i]);
                    }
                    System.out.println();
                }
        }


    }
}

package Jungol;

import java.util.Scanner;

public class JO1856 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int num = 1;
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            if(i % 2 == 0){
                for (int j = 0; j < m; j++) {
                    arr[i][j] = num++;
                }
            }else {
                for (int j = m-1; j >= 0; j--) {
                    arr[i][j] = num++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%d ", arr[i][j]);
            }
            System.out.println();
        }
    }
}

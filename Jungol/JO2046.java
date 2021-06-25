package Jungol;

import java.util.Scanner;

public class JO2046 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][n];
        int num = 1;
        if(m == 1){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = num;
                }
                num++;
            }
        } else if(m == 2){
            for (int i = 0; i < n; i++) {
                if(i % 2 == 0){
                    for (int j = 0; j <n; j++) {
                        arr[i][j] = j+1;
                    }
                } else {
                    for (int j = n-1; j >= 0; j--) {
                        arr[i][j] = n-j;
                    }
                }
            }
        } else if(m == 3){
            for(int j=0; j<n; j++){
                arr[0][j] = j+1;
            }
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = arr[0][i] * (j+1);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d ", arr[i][j]);
            }
            System.out.println();
        }
    }
}

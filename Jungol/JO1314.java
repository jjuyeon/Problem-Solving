package Jungol;

import java.util.Scanner;

public class JO1314 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        char[][] arr = new char[n][n];
        char a = 'A';
        for (int i = 0; i < n; i++) {
            if(i % 2 == 0){
                for (int j = 0; j < n; j++) {
                    arr[j][i] = a++;
                    if(a > 'Z') a = 'A';
                }
            } else {
                for(int j=n-1; j>=0; j--){
                    arr[j][i] = a++;
                    if(a > 'Z') a = 'A';
                }
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

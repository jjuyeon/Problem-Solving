package Jungol;

import java.util.Scanner;

public class JO1495 {

    static int n;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];

        int x, y, num = 1;
        boolean isEven = true;
        for (int i = 0; i < n; i++) {
            if(isEven) {
                x = 0; y = i;
                while(isPossible(x, y)){
                    arr[x][y] = num++;
                    x++; y--;
                }
                isEven = false;
            } else {
                x = i; y = 0;
                while(isPossible(x, y)){
                    arr[x][y] = num++;
                    x--; y++;
                }
                isEven = true;
            }
        }

        for (int i = 1; i < n; i++) {
            if(isEven) {
                x = i; y = n-1;
                while(isPossible(x, y)){
                    arr[x][y] = num++;
                    x++; y--;
                }
                isEven = false;
            }else {
                x = n-1; y = i;
                while(isPossible(x, y)){
                    arr[x][y] = num++;
                    x--; y++;
                }
                isEven = true;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isPossible(int x, int y){
        if(x>=0 && x<n && y>=0 && y<n) return true;
        return false;
    }
}

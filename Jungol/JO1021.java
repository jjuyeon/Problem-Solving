package Jungol;

import java.util.Scanner;

public class JO1021 {

    static int[][] arr;
    static int[] result;
    static boolean[] basic;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[n+1][n+1];
        for (int i = 0; i < m; i++) {
            arr[sc.nextInt()][sc.nextInt()] = sc.nextInt();
        }

        basic = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= n; j++) sum += arr[i][j];
            if(sum == 0)
                basic[i] = true;
        }

        result = new int[n+1];
        recur(n);
        for (int i = 1; i <= n; i++) {
            if(basic[i]) {
                System.out.println(i + " " + result[i]);
            }
        }
    }

    static void recur(int n) {
        if(basic[n]) {
            result[n]++;
            return;
        }
        for (int i = 1; i < arr[n].length; i++) {
            if(arr[n][i] > 0){
                for (int j = 0; j < arr[n][i]; j++) {
                    recur(i);
                }
            }
        }
    }
}

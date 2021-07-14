package Jungol;

import java.util.Arrays;
import java.util.Scanner;

public class JO1814 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int cnt = 0;
        for (int i = 1; i < n; i++) {
            int idx = i, standard = arr[i];
            for (int j = i-1; j >= 0; j--) {
                if(arr[i] < arr[j]) {
                    idx = j;
                }
            }

            for (int j = i; j > idx; j--) {
                arr[j] = arr[j-1];
                ++cnt;
            }
            arr[idx] = standard;
        }
        System.out.print(cnt);
    }
}

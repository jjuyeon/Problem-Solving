package Jungol;

import java.util.Scanner;

public class JO1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 1; i < n; i++) {
            int idx = i, standard = arr[i];
            for (int j = i-1; j >= 0; j--) {
                if(arr[i] < arr[j]) {
                    idx = j;
                }
            }

            for (int j = i; j > idx; j--) {
                arr[j] = arr[j-1];
            }
            arr[idx] = standard;

            for (int j = 0; j < n; j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.println();
        }
    }
}

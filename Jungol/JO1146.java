package Jungol;

import java.util.Arrays;
import java.util.Scanner;

public class JO1146 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n - 1; i++) {
            int min = Integer.MAX_VALUE, minIdx = -1;
            for (int j = i; j < n; j++) {
                if(min > arr[j]) {
                    min = arr[j];
                    minIdx = j;
                }
            }

            swap(minIdx, i, arr);

            for (int j = 0; j < n; j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.println();
        }
    }

    static void swap(int a, int b, int[] arr) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

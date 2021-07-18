package Jungol;

import java.util.Scanner;

public class JO2817 {

    static int k;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = sc.nextInt();
        }

        lotto(0, 0, new int[6]);
    }

    static void lotto(int idx, int start, int[] selected) {
        if(idx == 6) {
            for (int i = 0; i < 6; i++) {
                System.out.print(selected[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = start; i < k; i++) {
            selected[idx] = arr[i];
            lotto(idx+1, i+1, selected);
            selected[idx] = 0;
        }
    }
}

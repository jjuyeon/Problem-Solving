package Jungol;

import java.util.Scanner;

public class JO1175 {

    static int n, m;
    static int[] selected;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        selected = new int[n];
        dice(0, 0);
    }

    static void dice(int idx, int sum) {
        if (idx == n) {
            if (sum == m) {
                for (int i = 0; i < n; i++) {
                    System.out.print(selected[i] + " ");
                }
                System.out.println();
            }
            return;
        }
        for (int i = 1; i <= 6; i++) {
            selected[idx] = i;
            dice(idx + 1, sum + i);
        }
    }
}

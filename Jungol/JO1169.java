package Jungol;

import java.util.Scanner;

public class JO1169 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] result = new int[n];

        switch(m) {
            case 1:
                one(0, n, result);
                break;
            case 2:
                two(0, n, result);
                break;
            case 3:
                three(0, n, result);
        }
    }

    static boolean isSelected(int num, int n, int[] selected) {
        for (int i = 0; i <n ; i++) {
            if(num == selected[i])
                return true;
        }
        return false;
    }

    static void three(int idx, int n, int[] selected) {
        if(idx == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(selected[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= 6; i++) {
            if(!isSelected(i, n, selected)) {
                selected[idx] = i;
                three(idx+1, n, selected);
                selected[idx] = 0;
            }
        }
    }

    static void two(int idx, int n, int[] selected) {
        if(idx == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(selected[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= 6; i++) {
            if(idx == 0 || selected[idx-1] <= i) {
                selected[idx] = i;
                two(idx+1, n, selected);
            }
        }
    }

    static void one(int idx, int n, int[] selected) {
        if(idx == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(selected[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= 6; i++) {
            selected[idx] = i;
            one(idx+1, n, selected);
        }
    }
}

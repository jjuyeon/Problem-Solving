package Jungol;

import java.util.Scanner;

public class JO1490 {

    static int[] np;
    static int n, k;
    static boolean isNextPermutation = false, isEnd = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        np = new int[k];
        for (int i = 0; i < k; i++) {
            np[i] = sc.nextInt();
        }

        permutation(0, 1, new int[k]);
        if(!isEnd) {
            System.out.print("NONE");
        }
    }

    static void permutation(int idx, int start, int[] selected) {
        if(isEnd)
            return;

        if(idx == k) {
            if(isNextPermutation) {
                for (int i = 0; i < k; i++) {
                    System.out.print(selected[i] + " ");
                }
                isEnd = true;
            }
            isNextPermutation = check(selected);

            return;
        }
        for (int i = start; i <= n; i++) {
            selected[idx] = i;
            permutation(idx+1, i+1, selected);
            selected[idx] = 0;
        }
    }

    static boolean check(int[] selected) {
        for (int i = 0; i < k; i++) {
            if(selected[i] != np[i]) {
                return false;
            }
        }
        return true;
    }
}

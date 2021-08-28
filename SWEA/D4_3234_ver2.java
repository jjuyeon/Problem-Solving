package SWEA;

import java.util.Scanner;

// https://so-cute-danu-dev.tistory.com/8
public class D4_3234_ver2 {

    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            ans = 0;
            permutation(0, 0, 0, arr, new boolean[N]);
            System.out.println("#" + test_case + " " + ans);
        }
    }

    private static void permutation(int idx, int left, int right, int[] arr, boolean[] selected) {
        if (idx == arr.length) {
            ++ans;
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!selected[i]) {
                selected[i] = true;
                permutation(idx + 1, left + arr[i], right, arr, selected);
                if(left >= right + arr[i]) {
                    permutation(idx + 1, left, right + arr[i], arr, selected);
                }
                selected[i] = false;
            }
        }
    }
}

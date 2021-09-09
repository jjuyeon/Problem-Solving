package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ14890 {

    static int N, L;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans += goRightWay(i, true);

            ans += goRightWay(i, false);
        }
        System.out.println(ans);
    }

    private static int goRightWay(int idx, boolean isRow) {
        boolean[] visited = new boolean[N];
        int[] height = new int[N];

        for (int j = 0; j < N; j++) {
            height[j] = isRow ? arr[idx][j] : arr[j][idx];
        }

        for (int i = 0; i < N - 1; i++) {
            if (Math.abs(height[i + 1] - height[i]) > 1) {
                return 0;
            }

            if (height[i] < height[i + 1]) {
                for (int j = i; j > i - L; j--) {
                    if (j < 0 || visited[j] || height[j] != height[i])
                        return 0;
                    visited[j] = true;
                }
            } else if (height[i] > height[i + 1]) {
                for (int j = i + 1; j < i + 1 + L; j++) {
                    if (j >= N || visited[j] || height[j] != height[i + 1])
                        return 0;
                    visited[j] = true;
                }
            }
        }

        return 1;
    }
}

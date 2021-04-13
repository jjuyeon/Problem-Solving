package SWEA;

import java.util.Scanner;

public class SW_4014 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int x = sc.nextInt();

            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            System.out.println("#" + test_case + " " + simul(map, n, x));
        }
    }

    private static int simul(int[][] map, int n, int x) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            // 가로
            if (isPossible(map, n, i, true)) {
                ++ans;
            }
            else if (isPossibleConstruct(map, n, x, i, true)) {
                ++ans;
            }
            // 세로
            if (isPossible(map, n, i, false)) {
                ++ans;
            }
            else if (isPossibleConstruct(map, n, x, i, false)) {
                ++ans;
            }
        }
        return ans;
    }

    private static boolean isPossible(int[][] map, int n, int idx, boolean isGaro) {
        int bar = isGaro ? map[idx][0] : map[0][idx];

        for (int i = 0; i < n; i++) {
            if ((isGaro ? map[idx][i] : map[i][idx]) != bar) return false;
        }
        return true;
    }

    private static boolean isPossibleConstruct(int[][] map, int n, int x, int idx, boolean isGaro) {
        boolean[] isConstructed = new boolean[n];
        int cnt = 0;
        int prev = isGaro? map[idx][0] : map[0][idx];

        for (int j = 0; j < n; j++) {
            int now = isGaro ? map[idx][j] : map[j][idx];
            if (now == prev) ++cnt;
            else {
                if (now - prev == 1) { // 오르막
                    if (cnt >= x) {
                        for (int l = j - 1; l >= j - x; l--) {
                            if (isConstructed[l]) return false;
                            isConstructed[l] = true;
                        }
                        cnt = 1;
                    } else {
                        return false;
                    }
                } else if (now - prev == -1) { // 내리막
                    if (j + x - 1 < n) {
                        for (int l = j; l < j + x; l++) {
                            // 뒤는 아직 탐색을 안해봤기 때문에 뒤에도 같은 길이인지 확인해봐야함
                            if (isConstructed[l] || (isGaro? map[idx][l]:map[l][idx]) != now) return false;
                            isConstructed[l] = true;
                        }
                        j = j + x - 1;
                        cnt = 1;
                    } else {
                        return false;
                    }
                } else { // 안이어짐
                    return false;
                }
            }
            // 한턴 끝
            prev = now;
        }
        return true;
    }
}

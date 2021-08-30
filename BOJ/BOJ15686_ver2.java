package BOJ;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ15686_ver2 {

    static int ans = Integer.MAX_VALUE;
    static ArrayList<int[]> chicken = new ArrayList<>();
    static ArrayList<int[]> home = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int val = sc.nextInt();
                if (val == 1) { // home
                    home.add(new int[]{i, j});
                } else if (val == 2) { // chicken
                    chicken.add(new int[]{i, j});
                }
            }
        }
        combination(0, 0, new int[M], M, chicken.size());
        System.out.println(ans);
    }

    private static void combination(int idx, int start, int[] selected, int r, int n) {
        if(idx == r) {
            ans = Math.min(ans, calTotalDist(selected));
            return;
        }

        for (int i = start; i < n; i++) {
            selected[idx] = i;
            combination(idx + 1, i + 1, selected, r, n);
        }
    }

    private static int calTotalDist(int[] selected) {
        int result = 0;
        for (int i = 0; i < home.size(); i++) {
            int dist = calDist(home.get(i), chicken.get(selected[0]));
            for (int j = 1; j < selected.length; j++) {
                dist = Math.min(dist, calDist(home.get(i), chicken.get(selected[j])));
            }
            result += dist;
        }
        return result;
    }

    private static int calDist(int[] d1, int[] d2) {
        return Math.abs(d1[0] - d2[0]) + Math.abs(d1[1] - d2[1]);
    }
}

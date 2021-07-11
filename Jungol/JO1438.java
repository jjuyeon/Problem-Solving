package Jungol;

import java.util.Scanner;

public class JO1438 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[101][101];

        int x, y;
        for (int i = 0; i < n; i++) {
            x = sc.nextInt();
            y = sc.nextInt();

            for (int j = x; j < x + 10; j++) {
                if (j > 100) break;
                for (int k = y; k < y + 10; k++) {
                    if (k > 100) break;
                    map[j][k] = 1;
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if(map[i][j] == 1)
                    ans++;
            }
        }
        System.out.print(ans);
    }
}

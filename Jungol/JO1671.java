package Jungol;

import java.util.Scanner;

public class JO1671 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[102][102];

        int x, y, nx, ny;
        for (int i = 0; i < n; i++) {
            x = sc.nextInt();
            y = sc.nextInt();

            for (int j = x; j < x + 10; j++) {
                if (j > 100) break;
                for (int k = y; k < y + 10; k++) {
                    if (k > 100) break;
                    arr[j][k] = 1;
                }
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int ans = 0;
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if (arr[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        nx = i + dx[k];
                        ny = j + dy[k];
                        if (arr[nx][ny] == 0) {
                            ++ans;
                        }
                    }
                }
            }
        }

        System.out.print(ans);
    }
}

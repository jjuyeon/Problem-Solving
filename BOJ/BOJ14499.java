package BOJ;

import java.util.Scanner;

public class BOJ14499 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int k = sc.nextInt();

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int[] dice = new int[6];
        int[][] direction = {
                {2, 0, 5, 3, 4, 1}, // 동
                {1, 5, 0, 3, 4, 2}, // 서
                {4, 1, 2, 0, 5, 3}, // 북
                {3, 1, 2, 5, 0, 4} // 남
        };
        int[] dx = {0, 0, -1, 1}; // 동서북남
        int[] dy = {1, -1, 0, 0};

        for (int i = 0; i < k; i++) {
            int cmd = sc.nextInt() - 1;
            x += dx[cmd];
            y += dy[cmd];
            if(x<0 || x>=n || y<0 || y>=m) {
                x -= dx[cmd];
                y -= dy[cmd];
            }
            else {
                // move
                int[] temp = new int[6];
                for (int j = 0; j < 6; j++) {
                    temp[j] = dice[j];
                }
                for (int j = 0; j < 6; j++) {
                    dice[j] = temp[direction[cmd][j]];
                }

                // action
                if(map[x][y] == 0) {
                    map[x][y] = dice[5];
                } else {
                    dice[5] = map[x][y];
                    map[x][y] =0;
                }

                //print
                System.out.println(dice[0]);
            }
        }
    }
}

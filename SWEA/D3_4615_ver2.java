package SWEA;

import java.util.Scanner;

public class D3_4615_ver2 {

    static int N;
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            int M = sc.nextInt();
            int mid = N / 2;
            arr = new int[N + 1][N + 1];
            arr[mid][mid] = 2;
            arr[mid + 1][mid] = 1;
            arr[mid][mid + 1] = 1;
            arr[mid + 1][mid + 1] = 2;

            int x, y, color;
            for (int i = 0; i < M; i++) {
                x = sc.nextInt();
                y = sc.nextInt();
                color = sc.nextInt();
                arr[x][y] = color;
                change(x, y, color);
            }

            int black = 0, white = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (arr[i][j] == 1) { // 흑돌
                        ++black;
                    } else if (arr[i][j] == 2) { // 백돌
                        ++white;
                    }
                }
            }
            System.out.println("#" + test_case + " " + black + " " + white);
        }
    }

    private static void change(int x, int y, int color) {
        int nx, ny;
        for (int i = 0; i < 8; i++) {
            boolean isOk = false;
            int cnt = 0;
            while (true) {
                cnt++;
                nx = x + cnt * dx[i];
                ny = y + cnt * dy[i];
                if (nx < 1 || nx > N || ny < 1 || ny > N || arr[nx][ny] == 0) {
                    break;
                }
                if (arr[nx][ny] == color) {
                    isOk = true;
                    break;
                }
            }

            if (isOk) {
                for (int j = 1; j < cnt; j++) {
                    nx = x + j * dx[i];
                    ny = y + j * dy[i];
                    arr[nx][ny] = color;
                }
            }
        }
    }
}

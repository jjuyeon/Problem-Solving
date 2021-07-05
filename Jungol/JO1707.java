package Jungol;

import java.util.Scanner;

public class JO1707 {

    static int[][] arr;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];

        int x = 0, y = 0, num = 1, dir = 0, nx, ny;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        while (true) {
            arr[x][y] = num++;

            nx = x + dx[dir];
            ny = y + dy[dir];
            if (isImpossible(nx, ny)) {
                dir = (dir + 1) % 4;
                nx = x + dx[dir];
                ny = y + dy[dir];
                if (isImpossible(nx, ny)) {
                    break;
                }
            }

            x = nx;
            y = ny;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d ", arr[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean isImpossible(int x, int y){
        if(x < 0 || x >= n || y < 0 || y >= n || arr[x][y] > 0){
            return true;
        }
        return false;
    }
}

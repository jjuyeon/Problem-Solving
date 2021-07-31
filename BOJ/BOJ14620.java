package BOJ;

import java.util.Scanner;

public class BOJ14620 {

    static int n, min = 3000;
    static int[][] map;
    static boolean[][] flower;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        flower = new boolean[n][n];
        dfs(0, 0);
        System.out.println(min);
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void dfs(int cnt, int total) {
        if (cnt == 3) {
            min = Math.min(min, total);
            return;
        }

        int sum, nx, ny;
        boolean isOk;

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                isOk = true;
                if (!flower[i][j]) { // 5개의 구역이 모두 비어있는지 확인
                    for (int k = 0; k < 4; k++) {
                        nx = i + dx[k];
                        ny = j + dy[k];
                        if(flower[nx][ny]) {
                            isOk = false;
                            break;
                        }
                    }

                    if(isOk) { // 5개의 구역이 모두 비어있으면
                        flower[i][j] = true;
                        sum = map[i][j];
                        for (int k = 0; k < 4; k++) { // 구역을 차지했다고 체크하고, 비용을 더해준다.
                            nx = i + dx[k];
                            ny = j + dy[k];
                            flower[nx][ny] = true;
                            sum += map[nx][ny];
                        }

                        dfs(cnt + 1, total + sum); // 한 개의 꽃을 끝냈으므로 다음 꽃으로 넘어간다.

                        flower[i][j] = false; // 다음의 경우의 수도 체크해야하니까, 차지했던 구역을 되돌려둔다.
                        for (int k = 0; k < 4; k++) {
                            nx = i + dx[k];
                            ny = j + dy[k];
                            flower[nx][ny] = false;
                        }
                    }
                }
            }
        }
    }
}

package BOJ;

import java.util.Scanner;

public class BOJ1405 {

    static int n;
    static double ans = 0;
    static double[] prob;
    static boolean[][] visited;

    static int[] dx = {0, 0, 0, 1, -1};
    static int[] dy = {0, 1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        prob = new double[5];
        for (int i = 1; i <= 4; i++) { // 동 서 남 북
            prob[i] = sc.nextInt() * 0.01;
        }

        visited = new boolean[31][31];
        visited[15][15] = true; // 로봇의 초기 위치는 방문 체크해주기

        int nx, ny;
        for (int i = 1; i <= 4; i++) {
            nx = 15 + dx[i];
            ny = 15 + dy[i];
            visited[nx][ny] = true; // 항상 1번째로 이동하는 위치 방문 체크
            dfs(1, nx, ny, prob[i]);
            visited[nx][ny] = false; // 다음 경우의 수를 위해, 방문 되돌리기
        }
        System.out.println(ans);
    }

    static void dfs(int cnt, int x, int y, double sum) {
        if (cnt == n) {
            ans += sum;
            return;
        }

        for (int i = 1; i <= 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (!visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(cnt + 1, nx, ny, sum * prob[i]);
                visited[nx][ny] = false;
            }
        }
    }
}

package SWEA;

import java.util.*;

public class SW_1953 {

    static class Pos {
        int r, c, type, time;

        Pos(int r, int c, int type, int time) {
            this.r = r;
            this.c = c;
            this.type = type;
            this.time = time;
        }
    }

    static int[] dr = {-1, 1, 0, 0}; // 상하좌우
    static int[] dc = {0, 0, -1, 1};
    static int N, M;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            M = sc.nextInt();
            int R = sc.nextInt();
            int C = sc.nextInt();
            int L = sc.nextInt();

            map = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            System.out.println("#" + test_case + " " + bfs(R, C, L));
        }
    }

    private static int bfs(int startR, int startC, int L) {
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(new Pos(startR, startC, map[startR][startC], 1));
        map[startR][startC] = 0;

        int ans = 1;
        while (!queue.isEmpty()) {
            Pos now = queue.poll();
            int r = now.r;
            int c = now.c;
            int type = now.type;
            int time = now.time;

            if (time == L) break;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] > 0 && checkConnectedPipe(d, type, map[nr][nc])) {
                    queue.offer(new Pos(nr, nc, map[nr][nc], time + 1));
                    map[nr][nc] = 0;
                    ++ans;
                }
            }
        }

        return ans;
    }

    private static boolean checkConnectedPipe(int dir, int nowType, int nextType) {
        // 0:상, 1:하, 2: 좌, 3: 우
        switch (dir) {
            case 0:
                if (nowType == 1 || nowType == 2 || nowType == 4 || nowType == 7) {
                    if (nextType == 1 || nextType == 2 || nextType == 5 || nextType == 6) {
                        return true;
                    }
                }
                break;
            case 1:
                if (nowType == 1 || nowType == 2 || nowType == 5 || nowType == 6) {
                    if (nextType == 1 || nextType == 2 || nextType == 4 || nextType == 7) {
                        return true;
                    }
                }
                break;
            case 2:
                if (nowType == 1 || nowType == 3 || nowType == 6 || nowType == 7) {
                    if (nextType == 1 || nextType == 3 || nextType == 4 || nextType == 5) {
                        return true;
                    }
                }
                break;
            case 3:
                if (nowType == 1 || nowType == 3 || nowType == 4 || nowType == 5) {
                    if (nextType == 1 || nextType == 3 || nextType == 6 || nextType == 7) {
                        return true;
                    }
                }
        }
        return false;
    }
}

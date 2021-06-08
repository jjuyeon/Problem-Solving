package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://leveloper.tistory.com/57
public class BOJ15683_bfs {

    static class Status {
        int blank;
        int[][] map;

        Status(int blank, int[][] map) {
            this.blank = blank;
            this.map = map;
        }
    }

    static int N, M, ans;
    static int[][] cctvList;
    static int[] dr = {-1, 0, 1, 0}; // 북, 서, 남, 동
    static int[] dc = {0, -1, 0, 1};
    static int[][][] dir = {
            {},
            {{0}, {1}, {2}, {3}},
            {{0, 2}, {1, 3}},
            {{0, 3}, {0, 1}, {1, 2}, {2, 3}},
            {{0, 1, 3}, {0, 1, 2}, {1, 2, 3}, {0, 2, 3}},
            {{0, 1, 2, 3}}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int cctvCnt = 0, blank = N * M;
        cctvList = new int[8][3];
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                if (0 < map[i][j] && map[i][j] < 6)
                    cctvList[cctvCnt++] = new int[]{i, j, map[i][j]};
                else if (map[i][j] == 6)
                    --blank;
            }
        }
        ans = blank -= cctvCnt;
        bfs(blank, cctvCnt, map);
        System.out.print(ans);
    }

    private static void bfs(int blankCnt, int cctvCnt, int[][] map) {
        Queue<Status> queue = new LinkedList<>();
        queue.offer(new Status(blankCnt, map));
        for (int i = 0; i < cctvCnt; i++) {
            int len = queue.size();
            for (int t = 0; t < len; t++) {
                Status now = queue.poll();
                int nowBlank = now.blank;
                int[][] nowMap = now.map;

                int cctvRow = cctvList[i][0];
                int cctvCol = cctvList[i][1];
                int cctvNum = cctvList[i][2];

                for (int j = 0; j < dir[cctvNum].length; j++) {
                    queue.offer(updateMap(cctvRow, cctvCol, dir[cctvNum][j], nowBlank, nowMap));
                }
            }
        }
    }

    private static Status updateMap(int r, int c, int[] dir, int prevBlank, int[][] prevMap) {
        int updateBlank = prevBlank;
        int[][] updateMap = new int[N][M];
        copy(updateMap, prevMap);
        int nr, nc;
        for (int i = 0; i < dir.length; i++) {
            nr = r;
            nc = c;
            while (true) {
                nr += dr[dir[i]];
                nc += dc[dir[i]];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M || updateMap[nr][nc] == 6) break;
                if (updateMap[nr][nc] == 0) {
                    updateMap[nr][nc] = -1;
                    --updateBlank;
                }
            }
        }
        ans = Math.min(ans, updateBlank);
        return new Status(updateBlank, updateMap);
    }

    private static void copy(int[][] copyMap, int[][] map) {
        for (int i = 0; i < N; i++) {
            System.arraycopy(map[i], 0, copyMap[i], 0, M);
        }
    }
}
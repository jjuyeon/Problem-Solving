package BOJ;

import java.util.Scanner;

public class BOJ15683_dfs {

    static int N, M, ans;
    static int[][] cctvList;
    static int[] dr = {-1, 1, 0, 0}; // 북, 남, 서, 동
    static int[] dc = {0, 0, -1, 1};
    static int[][][] dir = {
            {},
            {{0}, {1}, {2}, {3}},
            {{0, 1}, {2, 3}},
            {{0, 2}, {0, 3}, {1, 2}, {1, 3}},
            {{0, 2, 3}, {0, 1, 2}, {1, 2, 3}, {0, 1, 3}},
            {{0, 1, 2, 3}}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int cctvCnt = 0, blankCnt = N * M;
        cctvList = new int[8][3];
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                if (0 < map[i][j] && map[i][j] < 6)
                    cctvList[cctvCnt++] = new int[]{i, j, map[i][j]};
                else if (map[i][j] == 6) --blankCnt;
            }
        }

        blankCnt -= cctvCnt;
        ans = blankCnt;
        dfs(0, map, blankCnt, cctvCnt);
        System.out.print(ans);
    }

    private static void dfs(int idx, int[][] map, int blankCnt, int cctvCnt) {
        if (idx == cctvCnt) {
            ans = Math.min(ans, blankCnt);
            return;
        }

        int[][] updateMap = new int[N][M];
        copy(updateMap, map);

        int cctvRow = cctvList[idx][0];
        int cctvCol = cctvList[idx][1];
        int cctvNum = cctvList[idx][2];
        for (int i = 0; i < dir[cctvNum].length; i++) {
            int updateBlank = blankCnt;
            for (int j = 0; j < dir[cctvNum][i].length; j++) {
                int d = dir[cctvNum][i][j];
                int nr = cctvRow, nc = cctvCol;
                while (true) {
                    nr += dr[d];
                    nc += dc[d];
                    if (nr < 0 || nr >= N || nc < 0 || nc >= M || updateMap[nr][nc] == 6) break;
                    if (updateMap[nr][nc] == 0) {
                        updateMap[nr][nc] = -1;
                        --updateBlank;
                    }
                }
            }
            dfs(idx + 1, updateMap, updateBlank, cctvCnt);
            copy(updateMap, map);
        }
    }

    private static void copy(int[][] newMap, int[][] map) {
        for (int i = 0; i < N; i++) {
            System.arraycopy(map[i], 0, newMap[i], 0, M);
        }
    }
}

package SWEA;

import java.util.*;

public class SW_5656 {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int N, W, H, ans;
    static int[][] map;

    static class Pos {
        int r, c, cnt;

        Pos(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt(); // 구슬을 쏠 수 있는 횟수
            W = sc.nextInt(); // 열의 개수
            H = sc.nextInt(); // 행의 개수

            map = new int[H][W];
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            ans = W * H;
            permutation(0, new int[N]); // 중복순열로 N개의 열 뽑기
            System.out.println("#" + test_case + " " + ans);
        }
    }

    private static void permutation(int idx, int[] selected) {
        if (idx == N) {
            int[][] tempMap = copyMap();
            for (int i = 0; i < N; i++) {
                crushWall(selected[i], tempMap);
            }
            ans = Math.min(ans, getRemainWallCnt(tempMap));
            return;
        }
        for (int i = 0; i < W; i++) {
            selected[idx] = i;
            permutation(idx + 1, selected);
        }
    }

    private static void crushWall(int initCol, int[][] temp) {
        // start점 찾기
        int initRow = 0, initCnt = 0;
        for (int i = 0; i < H; i++) {
            if (temp[i][initCol] != 0) {
                initRow = i;
                initCnt = temp[i][initCol];
                break;
            }
        }

        Queue<Pos> queue = new LinkedList<>();
        queue.offer(new Pos(initRow, initCol, initCnt));
        temp[initRow][initCol] = 0; // crush

        while (!queue.isEmpty()) {
            Pos now = queue.poll();
            int r = now.r;
            int c = now.c;
            int cnt = now.cnt;

            for (int i = 0; i < 4; i++) {
                int nr = r, nc = c;
                for(int j=1; j<cnt; j++) { // 셀 안에 있는 숫자만큼 연쇄 crush
                    nr += dr[i];
                    nc += dc[i];
                    if (nr < 0 || nr >= H || nc < 0 || nc >= W || temp[nr][nc] == 0) continue;
                    queue.offer(new Pos(nr, nc, temp[nr][nc]));
                    temp[nr][nc] = 0;
                }
            }
        }
        // arrange (밑으로 정렬)
        arrangeMap(temp);
    }

    private static void arrangeMap(int[][] temp) {
        Stack<Integer> stack = new Stack<>();
        for (int j = 0; j < W; j++) {
            for (int i = 0; i < H; i++) {
                if (temp[i][j] != 0) {
                    stack.push(temp[i][j]);
                    temp[i][j] = 0;
                }
            }
            int idx = H - 1;
            while (!stack.isEmpty()) {
                temp[idx][j] = stack.pop();
                --idx;
            }
        }
    }

    private static int getRemainWallCnt(int[][] temp) {
        int cnt = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (temp[i][j] != 0) ++cnt;
            }
        }
        return cnt;
    }

    private static int[][] copyMap() {
        int[][] temp = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                temp[i][j] = map[i][j];
            }
        }
        return temp;
    }
}

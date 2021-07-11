package Jungol;

import java.util.Scanner;

public class JO1733_2 {

    static int[] dr = {1, 0, 1, 1};
    static int[] dc = {0, 1, -1, 1};
    static int[][] map = new int[20][20];
    static boolean[][] omok = new boolean[20][20];
    static boolean isFinish = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 19; i++) {
            for (int j = 1; j <= 19; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <= 19; i++) {
            for (int j = 1; j <= 19; j++) {
                if (map[i][j] != 0 && !omok[i][j]) {
                    for (int k = 0; k < 4; k++) {
                        omok[i][j] = true;
                        if (!isImpossible(i + -1 * dr[k], j + -1 * dc[k])) { // 이전에도 시도하다가 실패한 적 있는지 체크
                            if (map[i + -1 * dr[k]][j + -1 * dc[k]] == map[i][j]) continue; // 있으면 이후도 다 안됨
                        }

                        recur(i + dr[k], j + dc[k], k, map[i][j], 1);

                        if (isFinish) {
                            printAns(i, j, k);
                            return;
                        }
                    }
                }
            }
        }

        System.out.println(0);
    }

    static void printAns(int r, int c, int k) {
        int ansR = r, ansC = c;
        for (int i = 0; i < 4; i++) {
            r += dr[k];
            c += dc[k];
            if (c < ansC) {
                ansC = c;
                ansR = r;
            } else if (c == ansC && r < ansR) {
                ansR = r;
            }
        }

        System.out.println(map[r][c]);
        System.out.println(ansR + " " + ansC);
    }

    static void recur(int r, int c, int k, int color, int cnt) {
        if (cnt == 5) {
            if (isImpossible(r, c) || map[r][c] != color) {
                isFinish = true;
            }
            return;
        }

        if (!isImpossible(r, c) && !omok[r][c] && map[r][c] == color) {
            omok[r][c] = true;
            recur(r + dr[k], c + dc[k], k, color, cnt + 1);
            omok[r][c] = false;
        }
    }

    static boolean isImpossible(int i, int j) {
        return i <= 0 || i >= 20 || j <= 0 || j >= 20;
    }
}

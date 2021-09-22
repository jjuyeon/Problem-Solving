package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ17135_ver2 {

    static int N, M, D, ans;
    static int[][] originMap, map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        D = sc.nextInt();

        originMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                originMap[i][j] = sc.nextInt();
            }
        }

        // 궁수 3명 위치 경우의 수
        // -> 그 경우의 수에 따라 게임 플레이
        // -> 게임 종료시, 최대 공격 가능한 적의 수 저장
        ans = 0;
        combination(0, 0, new int[3]);
        System.out.println(ans);
    }

    private static void combination(int cnt, int idx, int[] selected) {
        if (cnt == 3) {
            ans = Math.max(ans, game(selected));
            return;
        }

        for (int i = idx; i < M; i++) {
            selected[cnt] = i;
            combination(cnt + 1, i + 1, selected);
        }
    }

    private static int game(int[] selected) {
        int result = 0;
        copyMap();
        while (findEnemy()) {
            // D 이하인 적 중에서 가장 가까운 적 -> 적이 여럿일 경우에는 가장 왼쪽에 있는 적을 공격
            result += shoot(selected);
            // 적은 아래로 한 칸 이동하며, 성이 있는 칸으로 이동한 경우에는 게임에서 제외된다.
            move();
        }
        return result;
    }

    private static void move() {
        for (int i = N - 2; i >= 0; i--) {
            for (int j = 0; j < M; j++) {
                map[i + 1][j] = map[i][j];
            }
        }
        for (int j = 0; j < M; j++) {
            map[0][j] = 0;
        }
    }

    private static int shoot(int[] selected) {
        int[][] result = new int[3][2];
        for (int i = 0; i < 3; i++) {
            Arrays.fill(result[i], -1);
        }

        for (int d = 0; d < 3; d++) {
            int dist = 100;
            int x = -1, y = M;

            for (int i = N - 1; i >= 0; i--) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1) {
                        int nowDist = calDistance(i, j, selected[d]);
                        if(D >= nowDist) {
                            if (dist > nowDist) {
                                dist = nowDist;
                                x = i;
                                y = j;
                            } else if (dist == nowDist && y > j) {
                                x = i;
                                y = j;
                            }
                        }
                    }
                }
            }

            if (x >= 0) {
                result[d][0] = x;
                result[d][1] = y;
            }
        }

        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (result[i][0] != -1) {
                int x = result[i][0];
                int y = result[i][1];
                if (map[x][y] == 1) {
                    ++cnt;
                    map[x][y] = 0;
                }
            }
        }

        return cnt;
    }

    private static int calDistance(int x, int y, int pos) {
        return Math.abs(x - N) + Math.abs(y - pos);
    }

    private static boolean findEnemy() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void copyMap() {
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = originMap[i][j];
            }
        }
    }
}

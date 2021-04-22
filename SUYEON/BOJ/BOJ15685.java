package BOJ;

import java.util.Scanner;

public class BOJ15685 {

    static int[][] map = new int[101][101];
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int y = sc.nextInt();
            int x = sc.nextInt();
            int d = sc.nextInt();
            int g = sc.nextInt();
            map[x][y] = 1; // 시작점 체크
            drawDragonCurve(x, y, d, g); // 0번째 ~ g번째 커브 체크
        }

        System.out.print(getRectangleCnt());
    }

    private static void drawDragonCurve(int x, int y, int d, int g) {
        int len = (int) Math.pow(2, g);
        int[] recordDir = new int[len];
        recordDir[0] = d;
        x += dx[d];
        y += dy[d];
        map[x][y] = 1; // 0번째 커브 체크

        // 0세대 : 0
        // 1세대 : [0][1]
        // 2세대 : [0 1][2 1]
        // 3세대 : [0 1 2 1][2 3 2 1]
        // ....
        int idx = 1, nowDir;
        for (int curve = 1; curve <= g; curve++) { // 1~g번째 커브 체크
            for (int i = idx - 1; i >= 0; i--) { // 이전에 저장된 방향 중 최신 업데이트 방향부터 계산
                nowDir = (recordDir[i] + 1) % 4; // 90도 회전
                x += dx[nowDir];
                y += dy[nowDir];
                map[x][y] = 1;
                recordDir[idx++] = nowDir; // 방향 저장 -> 이후에 드래곤 커브에 또 써야함
            }
        }
    }

    private static int getRectangleCnt() { // 2칸씩 봐서 꼭지점 4개가 드래곤 커브이면 카운팅
        int cnt = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] == 1 && map[i + 1][j] == 1 && map[i][j + 1] == 1 && map[i + 1][j + 1] == 1)
                    ++cnt;
            }
        }
        return cnt;
    }
}

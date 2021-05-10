package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BOJ21611 {

    static int N;
    static int[][] map;
    static int[] shark, bumbCnt;
    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1};
    static int[] snail = {3, 2, 4, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int M = sc.nextInt();
        map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        shark = new int[]{(N + 1) / 2, (N + 1) / 2};
        bumbCnt = new int[4];

        while (M-- > 0) { // 시뮬레이션 시작
            magic(sc.nextInt(), sc.nextInt());
            do {
                move();
            } while (bumb());
            grouping();
        }

        System.out.print(bumbCnt[1] + 2 * bumbCnt[2] + 3 * bumbCnt[3]);
    }

    private static void grouping() {
        Queue<Integer> queue = new LinkedList<>();
        // 반시계 달팽이를 위한 변수
        int x = shark[0], y = shark[1] - 1;
        if(map[x][y] == 0) return; // 모든 위치에 구슬이 없으면 끝낸다
        int d = 1, size = 1, cnt = 0;
        // 구슬 그룹을 처리하기 위한 변수
        int a = 1, b = map[x][y];

        // 1. 반시계 방향 달팽이를 돌면서 큐에 계산된 a,b를 넣는다.
        while (x != 1 || y != 1) {
            x += dx[snail[d]];
            y += dy[snail[d]];
            if (map[x][y] == 0) {
                queue.offer(a);
                queue.offer(b); // 이전 값 처리
                break; // 0을 만나면 끝낸다
            }

            if (b == map[x][y]) { // 이전 값과 같을 때
                ++a;
            } else { // 이전 값과 다를 때
                queue.offer(a);
                queue.offer(b); // 큐에 업데이트된 a, b를 저장한다
                a = 1; // 초기화
                b = map[x][y];
            }

            ++cnt;
            if (cnt == size) {
                d = (d + 1) % 4;
                if (d == 0 || d == 2) ++size;
                cnt = 0;
            }
        }

        // 2. 다시 한번 돌면서 큐에 저장된 a,b를 위치시킨다.
        x = shark[0]; y = shark[1];
        d = 0; size = 1; cnt = 0;
        while (x != 1 || y != 1) {
            x += dx[snail[d]];
            y += dy[snail[d]];

            if (!queue.isEmpty()) {
                map[x][y] = queue.poll();
            } else {
                map[x][y] = 0;
            }

            ++cnt;
            if (cnt == size) {
                d = (d + 1) % 4;
                if (d == 0 || d == 2) ++size;
                cnt = 0;
            }
        }
    }

    private static boolean bumb() {
        boolean result = false; // 구슬의 폭발 여부 체크
        Stack<int[]> stack = new Stack<>(); // 폭발한 구슬의 위치 저장하기 위해 스택 사용
        // 반시계 달팽이를 위한 변수
        int x = shark[0], y = shark[1] - 1;
        int d = 1, size = 1, cnt = 0;
        // 구슬 폭발 조건을 위한 변수
        int check = 1, prev = map[x][y];
        stack.push(new int[]{x, y});

        while (x != 1 || y != 1) {
            x += dx[snail[d]];
            y += dy[snail[d]];
            if (map[x][y] == 0) {
                break; // 0을 만나면 끝낸다
            }

            if (prev == map[x][y]) { // 이전 값과 같을 때
                ++check;
                stack.push(new int[]{x, y});
            } else { // 이전 값과 다를 때
                if (check >= 4) { // 4개 이상 연속하는 구슬이면
                    bumbCnt[prev] += check; // 폭발한 구슬의 개수를 업데이트한다
                    while (check-- > 0) {
                        int[] pop = stack.pop();
                        map[pop[0]][pop[1]] = 0; // 폭발시킨다
                    }
                    result = true; // 폭발한게 있으므로 체크
                }
                prev = map[x][y]; // 초기화
                check = 1;
                stack.push(new int[]{x, y});
            }

            ++cnt;
            if (cnt == size) {
                d = (d + 1) % 4;
                if (d == 0 || d == 2) ++size;
                cnt = 0;
            }
        }

        // 마지막에는 폭발 처리가 안되므로, 마지막으로 한번 더 해준다.
        if (check >= 4) {
            bumbCnt[prev] += check;
            while (check-- > 0) {
                int[] pop = stack.pop();
                map[pop[0]][pop[1]] = 0; // 폭발시킨다
            }
            result = true; // 폭발한게 있으므로 체크
        }
        return result;
    }

    private static void move() {
        // 1. 반시계 방향 달팽이를 돌면서 큐에 구슬을 넣는다.
        Queue<Integer> queue = new LinkedList<>();
        int x = shark[0], y = shark[1];
        int d = 0, size = 1, cnt = 0;
        while (x != 1 || y != 1) {
            x += dx[snail[d]];
            y += dy[snail[d]];
            if (map[x][y] != 0) {
                queue.offer(map[x][y]);
            }
            ++cnt;

            if (cnt == size) {
                d = (d + 1) % 4; // 방향 업데이트
                if (d == 0 || d == 2) ++size;
                cnt = 0;
            }
        }

        x = shark[0]; y = shark[1];
        d = 0; size = 1; cnt = 0;
        // 2. 다시 한번 돌면서 큐에 저장된 구슬을 위치시킨다.
        while (x != 1 || y != 1) {
            x += dx[snail[d]];
            y += dy[snail[d]];
            if (!queue.isEmpty()) {
                map[x][y] = queue.poll();
            } else {
                map[x][y] = 0;
            }
            ++cnt;

            if (cnt == size) {
                d = (d + 1) % 4; // 방향 업데이트
                if (d == 0 || d == 2) ++size;
                cnt = 0;
            }
        }
    }

    private static void magic(int d, int s) {
        int nx = shark[0], ny = shark[1];
        while (s-- > 0) {
            nx += dx[d];
            ny += dy[d];
            if (nx >= 1 && nx <= N && ny >= 1 && ny <= N) {
                map[nx][ny] = 0;
            } else {
                return;
            }
        }
    }
}

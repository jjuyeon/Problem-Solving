package BOJ;

import java.util.Scanner;

public class BOJ17822 {

    static int N, M;
    static int[][] circle;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int T = sc.nextInt();

        circle = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) { // 들어오는 숫자 시계방향으로 저장됨
            for (int j = 1; j <= M; j++) {
                circle[i][j] = sc.nextInt();
            }
        }

        // 회전
        for (int l = 1; l <= T; l++) {
            int x = sc.nextInt();
            int d = sc.nextInt();
            int k = sc.nextInt();

            // step1. 시계/반시계 나눠서 회전
            rotation(x, d, k);

            // step2. 원판에 숫자 없으면 해당 턴은 끝난다
            if (hasNoNumber()) continue;

            // step3. 원판 안에서 인접하면서 같은 수 제거
            boolean isUpdate = removeSameNumber();

            // step4. step2에서 지워진 수가 없으면
            // 1)원판에 적힌 수의 평균을 구함, 2) 평균보다 큰 수는 -1, 3) 평균보다 작은 수는 +1
            if (!isUpdate) {
                addDummyValue();
            }
        }
        // 결과
        System.out.print(getAnswer());
    }

    private static void addDummyValue() {
        double avg = getAvg(); // 1)원판에 적힌 수의 평균을 구함
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (circle[i][j] > 0) {
                    if (circle[i][j] > avg) { // 2) 평균보다 큰 수는 -1
                        --circle[i][j];
                    } else if (circle[i][j] < avg) { // 3) 평균보다 작은 수는 +1
                        ++circle[i][j];
                    }
                }
            }
        }
    }

    private static boolean removeSameNumber() {
        int[][] temp = new int[N + 1][M + 1]; // 한번에 업데이트 시켜야하므로, circle 배열과 동일한 값을 가진 temp 배열을 생성함
        copy(temp);

        boolean result = false;
        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= M; y++) {
                if (circle[x][y] == 0) continue; // 이미 숫자 사라짐 (계산 필요 없음)
                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (ny == 0) ny = M; // 로테이션 되도록 해야함(1 -> M -> M-1 ..)
                    else if (ny == M + 1) ny = 1; // 로테이션 되도록 해야함(M -> 1 -> 2 -> ..)
                    if (nx >= 1 && nx <= N && circle[nx][ny] > 0) {
                        if (circle[x][y] == circle[nx][ny]) { // 인접 + 동일한 수라면 숫자를 없애준다
                            temp[x][y] = 0;
                            temp[nx][ny] = 0;
                            result = true;
                        }
                    }
                }
            }
        }

        if (result) { // 바뀐게 있으면 temp 배열에 담긴 결과를 원래 배열(circle)에 담는다
            circle = temp;
        }
        return result;
    }

    private static void rotation(int x, int d, int k) {
        if (d == 0) { // 시계방향 회전
            // x의 배수인 원판은 다 회전시킨다
            for (int i = x; i <= N; i += x) {
                int K = k;
                while (K-- > 0) {
                    int temp = circle[i][M];
                    System.arraycopy(circle[i], 1, circle[i], 2, M - 1);
                    circle[i][1] = temp;
                }
            }
        } else if (d == 1) { // 반시계방향 회전
            for (int i = x; i <= N; i += x) {
                int K = k;
                while (K-- > 0) {
                    int temp = circle[i][1];
                    System.arraycopy(circle[i], 2, circle[i], 1, M - 1);
                    circle[i][M] = temp;
                }
            }
        }
    }

    private static boolean hasNoNumber() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (circle[i][j] > 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void copy(int[][] newCircle) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                newCircle[i][j] = circle[i][j];
            }
        }
    }

    private static double getAvg() {
        int sum = 0, cnt = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (circle[i][j] > 0) {
                    sum += circle[i][j];
                    ++cnt;
                }
            }
        }
        return (double) sum / cnt;
    }

    private static int getAnswer() {
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                sum += circle[i][j];
            }
        }
        return sum;
    }
}

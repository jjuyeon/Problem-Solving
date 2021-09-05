package BOJ;

import java.util.Scanner;

public class BOJ20055 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        boolean[] robot = new boolean[N]; //  로봇이 전체가 아닌 N까지만 돌아간다.
        int[] arr = new int[N * 2];
        for (int i = 0; i < N * 2; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = 0;
        while (true) {
            // 4. 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다.
            if (checkFinish(arr, K)) {
                System.out.println(ans);
                return;
            }
            // 1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
            rotation(arr, robot, N);
            // 2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다.
            moveRobot(arr, robot, N);
            // 3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
            if (arr[0] != 0 && !robot[0]) {
                --arr[0];
                robot[0] = true;
            }
            ++ans;
        }
    }

    private static boolean checkFinish(int[] arr, int K) {
        int cnt = 0;
        for (int i : arr) {
            if (i == 0) ++cnt;
        }
        return cnt >= K;
    }

    private static void rotation(int[] arr, boolean[] robot, int N) {
        int temp = arr[N * 2 - 1];
        for (int i = N * 2 - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = temp;

        for (int i = N - 1; i > 0; i--) {
            robot[i] = robot[i - 1];
        }
        robot[0] = false;
        if(robot[N-1])
            robot[N-1] = false;
    }

    private static void moveRobot(int[] arr, boolean[] robot, int N) {
        // 로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없어야 한다.
        // 그 칸의 내구도가 1 이상 남아 있어야 한다.
        for (int i = N - 2; i >= 0; i--) {
            if (robot[i] && !robot[i + 1] && arr[i + 1] != 0) {
                robot[i + 1] = true;
                robot[i] = false;
                --arr[i + 1];
            }
        }
        if(robot[N-1])
            robot[N-1] = false;
    }
}

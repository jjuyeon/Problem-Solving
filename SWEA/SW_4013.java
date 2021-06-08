package SWEA;

import java.util.Scanner;

public class SW_4013 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int K = sc.nextInt();
            int[][] gear = new int[5][8];
            for (int i = 1; i <= 4; i++) {
                for (int j = 0; j < 8; j++) {
                    gear[i][j] = sc.nextInt();
                }
            }

            int[][] rotation = new int[K][2];
            for (int i = 0; i < K; i++) {
                rotation[i][0] = sc.nextInt();
                rotation[i][1] = sc.nextInt();
            }

            simul(gear, rotation, K);
            System.out.println("#" + test_case + " " + getTotalScore(gear));
        }
    }

    private static void simul(int[][] gear, int[][] rotation, int K) {
        for (int i = 0; i < K; i++) {
            int gearNum = rotation[i][0];
            int dir = rotation[i][1];

            int[] turningGear = new int[5];
            turningGear[gearNum] = dir;

            int turnIdx = gearNum - 1, turnDir = -dir;
            // 왼쪽 검사
            while (turnIdx > 0) {
                if (gear[turnIdx][2] == gear[turnIdx + 1][6]) {
                    break;
                }
                turningGear[turnIdx] = turnDir;
                turnDir *= -1;
                --turnIdx;
            }
            // 오른쪽 검사
            turnIdx = gearNum + 1;
            turnDir = -dir;
            while (turnIdx <= 4) {
                if (gear[turnIdx - 1][2] == gear[turnIdx][6]) {
                    break;
                }
                turningGear[turnIdx] = turnDir;
                turnDir *= -1;
                ++turnIdx;
            }
            // 돌리기
            for (int j = 1; j <= 4; j++) {
                turn(j, turningGear[j], gear);
            }
        }
    }

    private static void turn(int gearNum, int dir, int[][] gear) {
        if (dir == 1) { // 시계방향
            int temp = gear[gearNum][7];
            System.arraycopy(gear[gearNum], 0, gear[gearNum], 1, 7);
            gear[gearNum][0] = temp;
        } else if (dir == -1) { // 반시계방향
            int temp = gear[gearNum][0];
            System.arraycopy(gear[gearNum], 1, gear[gearNum], 0, 7);
            gear[gearNum][7] = temp;

        }
    }

    private static int getTotalScore(int[][] gear) {
        int sum = 0;
        for (int i = 1; i <= 4; i++) {
            if (gear[i][0] == 1) {
                sum += Math.pow(2, (i - 1));
            }
        }
        return sum;
    }
}

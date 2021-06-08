package BOJ;

import java.util.Scanner;

public class BOJ20164 {
    static int max = 0;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        recursive(N, getOddCnt(N));
        System.out.print(min + " " + max);
    }

    private static void recursive(int N, int cnt) {
        if (N < 10) {
            max = Math.max(max, cnt);
            min = Math.min(min, cnt);
            return;
        }
        if (N < 100) {
            int newNum = N / 10 + N % 10;
            recursive(newNum, cnt + getOddCnt(newNum));
            return;
        }

        int len = String.valueOf(N).length();
        for (int firstLen = 1; firstLen <= len - 2; firstLen++) {
            for (int secondLen = 1; secondLen <= len - firstLen - 1; secondLen++) {
                int thirdLen = len - firstLen - secondLen;

                int secondPow = (int) Math.pow(10, secondLen);
                int thirdPow = (int) Math.pow(10, thirdLen);

                int first = N / secondPow / thirdPow;
                int second = (N / thirdPow) % secondPow;
                int third = N % thirdPow;
                int newNum = first + second + third;
                recursive(newNum, cnt + getOddCnt(newNum));
            }
        }
    }

    private static int getOddCnt(int num) {
        int cnt = 0;
        while (num > 0) {
            cnt += (num % 10) % 2;
            num /= 10;
        }
        return cnt;
    }
}

package BOJ;

import java.io.*;

public class BOJ16637 {

    static int n, ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = stoi(br.readLine());

        int[] operand = new int[n / 2 + 1];
        char[] operator = new char[n / 2];
        String str = br.readLine();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                operand[i / 2] = stoi(String.valueOf(str.charAt(i)));
            } else {
                operator[i / 2] = str.charAt(i);
            }
        }
        recursive(0, operand, operator); // 모든 경우 다 체크 -> 브루트포스
        System.out.print(ans);
    }

    private static void recursive(int idx, int[] operand, char[] operator) {
        if (idx >= n / 2) {
            int now = operand[0];
            for (int i = 1; i <= n / 2; i++) {
                now = cal(now, operand[i], operator[i - 1]);
            }
            ans = Math.max(ans, now);
            return;
        }

        // 괄호 추가하는 경우
        int a = operand[idx];
        int b = operand[idx + 1];
        char op = operator[idx];

        int result = cal(a, b, op);
        operand[idx] = result;
        operand[idx + 1] = 0;
        operator[idx] = '+';
        recursive(idx + 2, operand, operator);

        operand[idx] = a;
        operand[idx + 1] = b;
        operator[idx] = op;

        // 괄호 추가안하는 경우
        recursive(idx + 1, operand, operator);
    }

    private static int cal(int a, int b, char c) {
        int result = 0;
        switch (c) {
            case '+':
                result = a + b;
                break;
            case '*':
                result = a * b;
                break;
            case '-':
                result = a - b;
        }
        return result;
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}

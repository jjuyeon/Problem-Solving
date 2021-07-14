package Jungol;

import java.util.Scanner;
import java.util.Stack;

public class JO1221 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = Integer.parseInt(sc.next());

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < m; i++) {
            String cmd = sc.next();
            if(isOperator(cmd)) {
                int b = stack.pop();
                int a = stack.pop();
                int calc = calc(a, b, cmd);
                stack.push(calc);
            } else {
                stack.push(Integer.parseInt(cmd));
            }
        }
        System.out.print(stack.pop());
    }

    static boolean isOperator(String op) {
        return op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/");
    }
    static int calc(int a, int b, String op) {
        int result = 0;
        switch (op) {
            case "+":
                result = a+b;
                break;
            case "-":
                result = a-b;
                break;
            case "*":
                result = a*b;
                break;
            case "/":
                result = a/b;
        }
        return result;
    }
}

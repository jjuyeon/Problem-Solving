package BOJ;

import java.util.Scanner;
import java.util.Stack;

public class BOJ9012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();

        int N = Integer.parseInt(sc.next());
        for (int i = 0; i < N; i++) {
            boolean isOk = true;
            String str = sc.next();
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == ')') {
                    if (stack.size() == 0) {
                        isOk = false;
                        break;
                    }
                    stack.pop();
                } else {
                    stack.push('(');
                }
            }
            if (stack.size() > 0) isOk = false;

            if (!isOk) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
            stack.clear();
        }
    }
}
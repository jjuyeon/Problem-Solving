package BOJ;

import java.util.Scanner;
import java.util.Stack;

public class BOJ10773 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < k; i++) {
            int n = sc.nextInt();
            if(n == 0) {
                stack.pop();
            }
            else {
                stack.push(n);
            }
        }

        int ans = 0;
        while(!stack.isEmpty()) {
            ans += stack.pop();
        }
        System.out.println(ans);
    }
}

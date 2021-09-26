package BOJ;

import java.util.Scanner;
import java.util.Stack;

public class BOJ4949 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            String line = sc.nextLine();
            if(line.equals(".")) {
                break;
            }

            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < line.length(); i++) {
                char now = line.charAt(i);
                if(now == '(' || now == '[') {
                    stack.push(now);
                }
                else if(now == ')') {
                    if(!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    }
                    else {
                        stack.push(now);
                        break;
                    }
                }
                else if(now == ']') {
                    if(!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    }
                    else {
                        stack.push(now);
                        break;
                    }
                }
            }

            if(stack.isEmpty()) {
                System.out.println("yes");
            }
            else {
                System.out.println("no");
            }
        }
    }
}

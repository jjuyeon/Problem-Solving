package BOJ;

import java.util.Scanner;
import java.util.Stack;

public class BOJ4889 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = 1;
        while (true) {
            String line = sc.next();
            if (line.contains("-")) {
                break;
            }

            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < line.length(); i++) {
                if (stack.isEmpty()) {
                    stack.push(line.charAt(i));
                }
                else {
                    if (line.charAt(i) == '{') {
                        stack.push('{');
                    } else if (stack.peek() == '{') {
                        stack.pop();
                    } else {
                        stack.push('}');
                    }
                }
            }

            int result = 0;
            while(!stack.isEmpty()) {
                char ch1 = stack.pop();
                char ch2 = stack.pop();
                if(ch2 == '}' && ch1 == '{') {
                    result += 2;
                }
                else if(ch2 == '{' && ch1 == '{') {
                    result++;
                }
                else if(ch2 == '}' && ch1 == '}') {
                    result++;
                }
            }

            System.out.println(number + ". " + result);
            number++;
        }
    }
}

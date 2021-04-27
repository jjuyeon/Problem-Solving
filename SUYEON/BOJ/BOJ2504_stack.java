package BOJ;

import java.util.Scanner;
import java.util.Stack;

public class BOJ2504_stack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Stack<String> stack = new Stack<>();

        boolean isFalse = false;
        int temp, ans = 0;
        for (int i = 0; i < str.length(); i++) {
            String now = str.substring(i, i + 1);
            if (now.equals("("))
                stack.push(")");

            else if (now.equals("["))
                stack.push("]");

            else if (now.equals(")") || now.equals("]")) {
                temp = 0;
                try {
                    while (!stack.isEmpty()) {
                        String top = stack.pop();
                        if (top.equals(now)) { // 알맞는 괄호 찾으면
                            int result = top.equals(")") ? 2 : 3;
                            if (temp == 0) { // 숫자 계산이 한번도 안된 상황
                                stack.push(String.valueOf(result));
                            } else { // 숫자 계산된 값이 있는 상황
                                stack.push(String.valueOf(result * temp));
                            }
                            break; // 연산 후, 끝낸다
                        } else { // 숫자일 때 연산해준다
                            temp += Integer.parseInt(top);
                        }
                    }
                } catch (Exception e) { // 숫자가 아닌 경우 Exception이 발생하는데, 이는 잘못된 괄호이므로 답이 아니다
                    isFalse = true;
                    break;
                }
            } else { // (, ), [, ] 제외한 괄호 나오면 무조건 틀림
                isFalse = true;
                break;
            }
        }

        if (!isFalse) {
            try { // 스택에 숫자만 남아있어야한다
                while (!stack.isEmpty()) {
                    ans += Integer.parseInt(stack.pop());
                }
            } catch (Exception e) { // 숫자가 아닌 경우 Exception이 발생하는데, 이는 잘못된 괄호이므로 답이 아니다
                ans = 0;
            }
        }
        System.out.println(ans);
    }
}

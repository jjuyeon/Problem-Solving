package BOJ;

import java.util.Scanner;
import java.util.Stack;

public class BOJ1662 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        Stack<String> stack = new Stack<>();
        for (int i = 0, size = str.length(); i < size; i++) {
            String now = str.substring(i, i + 1);
            if (now.equals(")")) { // 닫는 괄호 만나면
                int len = 0;
                while (!stack.isEmpty()) {
                    String top = stack.pop();
                    if (top.equals("(")) { // 여는 괄호 만날 때까지 반복
                        break;
                    } else if(top.startsWith("len:")){ // 이전에 계산했던 문자열 길이면 이전에 저장한 길이 값을 사용한다(불필요한 계산을 줄인다)
                        len += Integer.parseInt(top.substring(top.indexOf(":")+1));
                    }
                    else { // 계속 문자열 길이 체크
                        ++len;
                    }
                }
                int cnt = Integer.parseInt(stack.pop()); // 여는 괄호 바로 다음에 나오는 숫자가 반복 횟수
                stack.push("len:"+len*cnt); // 계산 완료된 문자열 길이라고 구분하기 위해, 앞에 "len:"을 붙인다
            } else { // 닫는 괄호 만나기 전까진 계속 스택에 넣는다
                stack.push(now);
            }
        }

        int ans = 0;
        while(!stack.isEmpty()){ // 최종 문자열 길이를 구한다
            String top = stack.pop();
            if(top.startsWith("len:")){
                ans += Integer.parseInt(top.substring(top.indexOf(":")+1));
            }
            else {
                ++ans;
            }
        }
        System.out.println(ans);
    }
}

package SWEA;

import java.util.Scanner;
import java.util.Stack;

public class D4_1218 {
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int N = sc.nextInt();
            String str = sc.next();

            Stack<Character> stack = new Stack<>();
            for(int i=0; i<N; i++){
                char nowChar = str.charAt(i);
                if(nowChar == ')' && stack.peek() == '('){
                    stack.pop();
                }
                else if(nowChar == ']' && stack.peek() == '['){
                    stack.pop();
                }
                else if(nowChar == '}' && stack.peek() == '{'){
                    stack.pop();
                }
                else if(nowChar == '>' && stack.peek() == '<'){
                    stack.pop();
                }
                else{
                    stack.push(nowChar);
                }
            }
            sb.append("#").append(test_case).append(" ");
            if(stack.isEmpty()){
                sb.append(1);
            }else{
                sb.append(0);
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}

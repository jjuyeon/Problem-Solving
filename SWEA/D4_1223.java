package SWEA;

import java.util.Scanner;
import java.util.Stack;

public class D4_1223 {
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int len = sc.nextInt();
            char[] arr = sc.next().toCharArray();
            Stack<Integer> numbers = new Stack<>();
            Stack<Character> operators = new Stack<>();

            int result = 0;
            for(int i=0; i<len; i++){
                if(arr[i] == '+' || arr[i] == '-' || arr[i] == '*' || arr[i] == '/') { // 연산자 들어올 때
                    if (operators.isEmpty()) {
                        operators.push(arr[i]);
                        continue;
                    }
                    char top = operators.peek();
                    if (top == '*') {
                        result = (numbers.pop() * numbers.pop());
                        operators.pop();
                        numbers.push(result);
                    } else if (top == '/') {
                        result = (numbers.pop() / numbers.pop());
                        operators.pop();
                        numbers.push(result);
                    }

                    operators.push(arr[i]);
                }
                else{ // 숫자 들어올 때
                    numbers.push(arr[i] - '0');
                }
            }

            while(!operators.isEmpty()){
                char top = operators.pop();
                if (top == '+') {
                    result = (numbers.pop() + numbers.pop());
                }
                else if(top == '-'){
                    result = (numbers.pop() - numbers.pop());
                }
                else if(top == '*'){
                    result = (numbers.pop() * numbers.pop());
                }
                else if(top == '/'){
                    result = (numbers.pop() / numbers.pop());
                }
                numbers.push(result);
            }

            sb.append("#").append(test_case).append(" ").append(numbers.pop()).append("\n");
        }

        System.out.print(sb.toString());
    }
}

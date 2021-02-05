package BOJ;

import java.util.Scanner;
import java.util.Stack;

public class BOJ10799 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char[] line = sc.next().toCharArray();
        Stack<Character> stack = new Stack<>();
        int sum = 0;
        for(int i=0; i<line.length; i++){
            if(line[i] == '(' && line[i+1] == ')'){ // 레이저
                sum += stack.size();
                i++;
            }
            else if(line[i] == '('){
                stack.push(line[i]);
            }
            else{
                stack.pop();
                sum++; // 스택에 포함 안된 마지막 조각 더해줌
            }
        }

        System.out.print(sum);
    }
}

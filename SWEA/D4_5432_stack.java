package SWEA;

import java.util.*;

public class D4_5432_stack {
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            char[] line = sc.next().toCharArray();
            Stack<Character> stack = new Stack<>();
            int sum = 0;
            for(int i=0; i<line.length; i++){
                if(line[i] == '(' && line[i+1] == ')'){
                    sum += stack.size();
                    i++;
                }
                else{
                    if(line[i] == '('){
                        stack.push(line[i]);
                    }else{
                        stack.pop();
                        sum += 1;
                    }
                }
            }

            sb.append("#").append(test_case).append(" ").append(sum).append("\n");
        }

        System.out.print(sb.toString());
    }
}

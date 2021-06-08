package BOJ;

import java.util.*;

public class BOJ17413_stack {
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        boolean flag = false;
        for(int i=0; i<str.length(); i++){
            char now = str.charAt(i);
            if(now == '<'){
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                flag = true;
                sb.append(now);
            }
            else if(now == '>'){
                flag = false;
                sb.append(now);
            }
            else if(flag){
                sb.append(now);
            }
            else { // flag == false
                if(now == ' '){
                    while(!stack.isEmpty()){
                        sb.append(stack.pop());
                    }
                    sb.append(now);
                }
                else{
                    stack.push(now);
                }
            }
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.print(sb.toString());
    }
}

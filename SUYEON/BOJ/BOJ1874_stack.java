package BOJ;

import java.util.Scanner;
import java.util.Stack;

public class BOJ1874_stack {
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int idx = 0, num = 0;
        Stack<Integer> stack = new Stack<>();
        while(num < n){
            stack.push(++num);
            sb.append("+").append("\n");
            while(!stack.isEmpty() && idx<n && arr[idx] == stack.peek()){
                stack.pop();
                sb.append("-").append("\n");
                ++idx;
            }
        }

        if(stack.size() == 0) {
            System.out.print(sb.toString());
        }else{
            System.out.print("NO");
        }
    }
}

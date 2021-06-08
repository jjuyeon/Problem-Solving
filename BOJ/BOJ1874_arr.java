package BOJ;

import java.util.Scanner;

public class BOJ1874_arr {
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] stack = new int[n];
        int top = 0, idx = 1;
        while(n-- > 0){
            int input = sc.nextInt();
            while(idx <= input){
                stack[top++] = idx++;
                sb.append("+").append("\n");
            }
            if(stack[top-1] != input){
                sb.setLength(0);
                sb.append("NO");
                break;
            }
            top--;
            sb.append("-").append("\n");
        }

        System.out.print(sb.toString());
    }
}

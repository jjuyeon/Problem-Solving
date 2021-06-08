package SWEA;

import java.util.Scanner;

public class D4_5432_arr {
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int count = 0, result = 0;
            String str = sc.next();
            for(int i=0; i<str.length()-1; i++){
                if(str.charAt(i) == '(' && str.charAt(i+1) == ')'){ // 레이저
                    result += count;
                }
                else if(str.charAt(i) == ')' && str.charAt(i+1) == ')'){ // 막대가 다 조각남
                    count--;
                    result++;
                }
                else if(str.charAt(i) == '(' && str.charAt(i+1) == '('){ // 새로운 막대
                    count++;
                }
            }
            sb.append("#").append(test_case).append(" ").append(result).append("\n");
        }

        System.out.print(sb.toString());
    }
}

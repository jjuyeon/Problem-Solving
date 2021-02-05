package SWEA;

import java.util.*;

public class D3_3499 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            String[] arr = new String[n];
            for(int i=0; i<arr.length; i++){
                arr[i] = sc.next();
            }

            boolean isEven = (n % 2 == 0);
            int half = (isEven)? n/2 : n/2+1;
            String[] answer = new String[n];
            for(int i=0; i<half; i++){
                answer[i*2] = arr[i];
                if(isEven || i < half-1){ // n이 홀수인 경우 비대칭임(마지막에 하나 부족함)
                    answer[i*2+1] = arr[half+i];
                }
            }

            sb.append("#").append(test_case);
            for(String s : answer){
                sb.append(" ").append(s);
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}

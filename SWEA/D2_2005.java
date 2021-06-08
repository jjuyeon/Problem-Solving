package SWEA;

import java.util.*;

public class D2_2005 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        /**
         * TODO: 조합, 순열 JAVA 알고리즘 공부
         * reference: https://m.blog.naver.com/PostView.nhn?blogId=vollollov&logNo=220947452823&proxyReferer=https:%2F%2Fwww.google.com%2F
         */
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();

            System.out.printf("#%d%n", test_case);
            for(int i=0; i<n; i++){
                for(int j=0; j<=i; j++){
                    System.out.print(combination(i, j) + " ");
                }
                if(i!=n){
                    System.out.println();
                }
            }
        }
    }

    static int combination(int n, int r){
        if(r == n || r == 0){
            return 1;
        }
        return combination(n-1, r) + combination(n-1, r-1); // 하나의 원소를 무조건 뽑지 않는 경우 + 하나의 원소를 무조건 뽑는 경우
    }
}

package SWEA;

import java.util.Scanner;

public class D2_1989 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            String str = sc.next();
            int len = str.length();
            boolean isTrue = true;
            for(int i=0; i<len/2; i++){
                if(str.charAt(i) != str.charAt(len-i-1)){
                    isTrue = false;
                }
            }
            System.out.printf("#%d %d%n", test_case, isTrue? 1 : 0);
        }
    }
}

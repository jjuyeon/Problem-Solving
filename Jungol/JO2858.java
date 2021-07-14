package Jungol;

import java.util.Scanner;
import java.util.Stack;

public class JO2858 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int opener = 1, ans = 0;
        for (int i = 1; i < str.length(); i++) {
            char now = str.charAt(i);
            if(now == '(') {
                ++opener;
            }
            else if(now == ')'){
                --opener;

                if(str.charAt(i-1) == '(') { // 레이저
                    ans += opener;
                } else if(str.charAt(i-1) == ')') { // 막대
                    ans++;
                }
            }
        }

        System.out.print(ans);
    }
}

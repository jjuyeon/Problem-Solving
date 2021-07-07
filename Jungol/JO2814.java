package Jungol;

import java.util.Scanner;

public class JO2814 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int num = 0, cnt = 0;
        for (int i = str.length()-1; i>=0; i--) {
            if(str.charAt(i) == '1') {
                num += Math.pow(2, cnt);
            }
            cnt++;
        }

        System.out.print(num);
    }
}
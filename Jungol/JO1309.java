package Jungol;

import java.util.Scanner;

public class JO1309 {

    static long ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ans = n;
        fact(n);
        System.out.print(ans);
    }

    private static void fact(int n) {
        if(n == 1) {
            System.out.println(n+"! = "+n);
            return;
        }
        System.out.println(n+"! = "+n+" * "+(n-1)+"!");
        ans *= (n-1);
        fact(n-1);
    }
}

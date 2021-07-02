package Jungol;

import java.util.Scanner;

public class JO1658 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int gcd = gcd(a, b);
        int lcm = a*b / gcd;
        System.out.println(gcd);
        System.out.println(lcm);
    }

    private static int gcd(int a, int b){
        int ans = 0;
        for (int i = 1; i <= Math.min(a, b); i++) {
            if(a % i == 0 && b % i == 0){
                ans = i;
            }
        }
        return ans;
    }
}

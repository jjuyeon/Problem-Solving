package Jungol;

import java.util.Scanner;

public class JO1002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        long gcd = arr[0], lcm = arr[0];
        for (int i = 1; i < n; i++) {
            gcd = get_gcd(gcd, arr[i]);
            lcm = lcm * arr[i] / get_gcd(lcm, arr[i]);
        }

        System.out.printf("%s %s", gcd, lcm);
    }

    private static long get_gcd(long a, long b){
        long ans = 1;
        for (int i = 1; i <= Math.min(a, b); i++) {
            if(a % i == 0 && b % i == 0){
                ans = i;
            }
        }
        return ans;
    }
}

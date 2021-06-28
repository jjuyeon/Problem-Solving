package Jungol;

import java.util.Scanner;

public class JO1402 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if(n % i == 0){
                k--;
            }
            if(k == 0){
                ans = i;
                break;
            }
        }
        System.out.println(ans);
    }
}

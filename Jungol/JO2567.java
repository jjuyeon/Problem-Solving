package Jungol;

import java.util.Scanner;

public class JO2567 {

    static int[] check = new int[1001];
    static int n, p;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        p = sc.nextInt();

        recur((n*n) % p);
    }

    static void recur(int num) {
        if(check[num] == 2) {
            int ans = 0;
            for (int i = 0; i <= 1000; i++) {
                if(check[i] > 1) {
                    ++ans;
                }
            }
            System.out.print(ans);
            return;
        }
        check[num]++;
        recur((num * n) % p);
    }
}

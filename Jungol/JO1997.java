package Jungol;

import java.util.Scanner;

public class JO1997 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        int k = sc.nextInt();

        // f(n) = f(n-2) + f(n-1)
        // 1열: A, 2열: B
        int[][] fibo = new int[31][2];
        fibo[1][0] = 1;
        fibo[1][1] = 0;
        fibo[2][0] = 0;
        fibo[2][1] = 1;

        for (int i = 3; i < 31; i++) {
            fibo[i][0] = fibo[i-2][0] + fibo[i-1][0];
            fibo[i][1] = fibo[i-2][1] + fibo[i-1][1];
        }

        for (int a = 1; a <= k; a++) {
            for (int b = a; b <= k; b++) {
                if(fibo[d][0] * a + fibo[d][1] * b == k) {
                    System.out.println(a);
                    System.out.println(b);
                    return;
                }
            }
        }
    }
}

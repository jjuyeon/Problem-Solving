package Jungol;

import java.util.Scanner;

public class JO1740 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int min = 10000, sum = 0;
        for (int i = m; i <= n; i++) {
            boolean isPrime = true;
            if(i == 1) {
                isPrime = false;
            } else {
                for (int j = 2; j <= Math.sqrt(i); j++) {
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }
            if(isPrime){
                sum += i;
                min = Math.min(min, i);
            }
        }

        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}

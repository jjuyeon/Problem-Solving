package Jungol;

import java.util.Scanner;

public class JO1303 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 1; i <= n * m;) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%d ", i++);
            }
            System.out.println();
        }
    }
}

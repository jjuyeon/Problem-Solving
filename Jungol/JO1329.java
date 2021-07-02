package Jungol;

import java.util.Scanner;

public class JO1329 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(n<1 || n>100 || n%2==0) {
            System.out.println("INPUT ERROR!");
        } else {
            for (int i = 0; i <= n / 2; i++) {
                for (int j = 0; j < i; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < 1 + 2*i; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }

            for (int i = 0; i < n / 2; i++) {
                for (int j = n/2-1; j > i; j--) {
                    System.out.print(" ");
                }
                for (int j = 0; j < n-2*(i+1); j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }
}

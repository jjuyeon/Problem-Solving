package Jungol;

import java.util.Scanner;

public class JO1719 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        if(n<1 || n>100 || m<1 || m>4 || n%2 == 0){
            System.out.println("INPUT ERROR!");
        } else {
            switch (m){
                case 1 :
                    for (int i = 0; i <= n/2; i++) {
                        for (int j = 0; j <= i; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    for (int i = n/2+1; i < n; i++) {
                        for (int j = 0; j < n-i; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 2 :
                    for (int i = 0; i <= n/2; i++) {
                        for (int j = 0; j < n/2 - i; j++) {
                            System.out.print(" ");
                        }
                        for (int j = 0; j <= i; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    for (int i = n/2+1; i < n; i++) {
                        for (int j = n/2+1; j <= i; j++) {
                            System.out.print(" ");
                        }
                        for (int j = 0; j < n-i; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 3 :
                    for (int i = 0; i <= n/2; i++) {
                        for (int j = 0; j < i; j++) {
                            System.out.print(" ");
                        }
                        for (int j = 0; j < n-2*i; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    for (int i = 0; i < n/2; i++) {
                        for (int j = n/2-1; j > i; j--) {
                            System.out.print(" ");
                        }
                        for (int j = 0; j < 3 + 2*i; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 4 :
                    for (int i = 0; i <= n/2; i++) {
                        for (int j = 0; j < i; j++) {
                            System.out.print(" ");
                        }
                        for (int j = i; j <= n/2; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    for (int i = 0; i < n/2; i++) {
                        for (int j = 0; j < n / 2; j++) {
                            System.out.print(" ");
                        }
                        for (int j = 0; j < 2 + i; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
            }
        }
    }
}

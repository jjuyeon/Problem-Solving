package Jungol;

import java.util.Scanner;

public class JO1641 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        if(n<1 || n>100 || m<1 || m>3 || n%2==0){
            System.out.println("INPUT ERROR!");
        }else {
            switch (m){
                case 1:
                    int num = 1;
                    for (int i = 0; i < n; i++) {
                        if(i%2 == 0) {
                            for (int j = 0; j <= i; j++) {
                                System.out.printf("%d ", num++);
                            }
                        } else {
                            int[] arr = new int[i+1];
                            for (int j = i; j >= 0; j--) {
                                arr[j] = num++;
                            }
                            for (int j = 0; j <= i; j++) {
                                System.out.printf("%d ", arr[j]);
                            }
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < i; j++) {
                            System.out.print("  ");
                        }
                        for (int j = 2*n-1; j > 2*i; j--) {
                            System.out.printf("%d ", i);
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    for (int i = 0; i <= n / 2; i++) {
                        for (int j = 0; j <= i; j++) {
                            System.out.printf("%d ", j+1);
                        }
                        System.out.println();
                    }
                    for (int i = 0; i < n / 2; i++) {
                        for (int j = 0; j < n / 2 - i; j++) {
                            System.out.printf("%d ", j+1);
                        }
                        System.out.println();
                    }
            }
        }
    }
}

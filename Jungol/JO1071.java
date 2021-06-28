package Jungol;

import java.util.Scanner;

public class JO1071 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();

        int a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i] <= m && m % arr[i] == 0){
                a += arr[i];
            }
            if(arr[i] % m == 0){
                b += arr[i];
            }
        }

        System.out.println(a);
        System.out.println(b);
    }
}

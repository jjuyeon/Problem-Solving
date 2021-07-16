package Jungol;

import java.util.Scanner;

// https://shoark7.github.io/programming/algorithm/tower-of-hanoi
public class JO1161 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        hanoi(n, 1, 3, 2);
    }

    static void move(int n, int a, int c) {
        System.out.printf("%d : %d -> %d%n", n, a, c);
    }

    static void hanoi(int n, int a, int c, int b) {
        if(n == 1) {
            move(n, a, c);
            return;
        }
        hanoi(n-1, a, b, c);
        move(n, a, c);
        hanoi(n-1, b, c, a);
    }
}

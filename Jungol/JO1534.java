package Jungol;

import java.util.Scanner;

public class JO1534 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();

        switch (b){
            case 2:
                System.out.print(Integer.toBinaryString(n));
                break;
            case 8:
                System.out.print(Integer.toOctalString(n));
                break;
            case 16:
                String str = Integer.toHexString(n);
                System.out.print(str.toUpperCase());
        }
    }
}

package SWEA;

import java.util.Scanner;

public class D1_2058 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        int sum = 0;
        while(T != 0){
            sum += T%10;
            T /= 10;
        }
        System.out.println(sum);
    }
}

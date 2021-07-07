package Jungol;

import java.util.Scanner;

public class JO1009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int sum;
        boolean isFirst;

        while(n != 0){
            sum = 0; isFirst = true;
            while(n > 0){
                if(n%10 != 0 && isFirst){
                    isFirst = false;
                }
                if(!isFirst) {
                    System.out.print(n % 10);
                    sum += n%10;
                }
                n /= 10;
            }
            System.out.println(" " + sum);
            n = sc.nextInt();
        }
    }
}

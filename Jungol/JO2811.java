package Jungol;

import java.util.Scanner;

public class JO2811 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            int num = sc.nextInt();
            if(num == 1) {
                System.out.println("number one");
            } else {
                boolean isPrime = false;
                for (int j = 2; j <= Math.sqrt(num); j++) {
                    if(num % j == 0){
                        System.out.println("composite number");
                        isPrime = true;
                        break;
                    }
                }
                if(!isPrime){
                    System.out.println("prime number");
                }
            }
        }
    }
}

package Jungol;

import java.util.Scanner;

public class JO1901 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();

            int diff = 0, checkNum;
            boolean isPrime;
            int[] ans = new int[2];

            while((num + diff) <= 1000000 && (num - diff) > 0){
                isPrime = true;
                checkNum = num - diff;
                for (int j = 2; j <= Math.sqrt(checkNum); j++) {
                    if(checkNum % j == 0){
                        isPrime = false;
                        break;
                    }
                }
                if(isPrime){
                    ans[0] = checkNum;
                    if(diff == 0) break;
                }

                isPrime = true;
                checkNum = num + diff;
                for (int j = 2; j <= Math.sqrt(checkNum); j++) {
                    if(checkNum % j == 0){
                        isPrime = false;
                        break;
                    }
                }
                if(isPrime){
                    if(ans[0] != 0) ans[1] = checkNum;
                    else ans[0] = checkNum;
                }

                if(ans[0] != 0) break;
                diff++;
            }

            if(ans[0] != 0){
                if(ans[1] != 0){
                    System.out.println(ans[0] + " " + ans[1]);
                }
                else{
                    System.out.println(ans[0]);
                }
            }
        }
    }
}

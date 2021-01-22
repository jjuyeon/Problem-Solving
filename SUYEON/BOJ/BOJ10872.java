package BOJ;

import java.util.*;

public class BOJ10872 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(factorial(n));
    }

    static int factorial(int n){
        if(n==0)
            return 1;
        return n * factorial(n-1);
    }
}

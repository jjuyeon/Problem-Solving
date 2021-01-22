package BOJ;

import java.util.*;

public class BOJ10870 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(n <= 1){
            System.out.println(n);
        }else{
            System.out.println(fibo(n));
        }
    }

    static int fibo(int n){
        if(n<=1){
            return n;
        }
        return fibo(n-1) + fibo(n-2);
    }
}

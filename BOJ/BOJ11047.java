package BOJ;

import java.util.*;

public class BOJ11047 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] money = new int[n];
        for(int i=0; i<n; i++){
            money[i] = sc.nextInt();
        }

        int ans = 0;
        int idx = n-1;
        while(k>0){
            if(k/money[idx] > 0){
                ans += k/money[idx];
                k %= money[idx];
            }
            --idx;
        }
        System.out.print(ans);
    }
}

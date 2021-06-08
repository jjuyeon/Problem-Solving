package BOJ;

import java.util.Scanner;

public class BOJ2231 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int ans = 0;
        for(int i=1; i<n; i++){
            int temp = i, sum = i;
            while(temp>0){
                sum+=temp%10;
                temp/=10;
            }
            if(sum == n){
                ans = i;
                break;
            }
        }

        System.out.print(ans);
    }
}

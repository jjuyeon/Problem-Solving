package BOJ;

import java.util.Scanner;

public class BOJ13458 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int b = sc.nextInt();
        int c = sc.nextInt();

        long ans = 0;
        for(int i=0; i<n; i++){
            int a = arr[i];

            // 총감독관이 한 시험장에서 감시할 수 있는 응시자의 수 처리
            a -= b;
            ++ans;

            // 부감독관이 한 시험장에서 감시할 수 있는 응시자의 수 처리
            if(a>0) { // 총감독관이 처리할 수 있는 응시자 수가 현재 시험장에 있는 응시자의 수보다 클 때 예외처리도 필요함
                ans += (a / c);
                if (a % c != 0) ++ans;
            }
        }

        System.out.print(ans);
    }
}

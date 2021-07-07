package Jungol;

import java.util.Scanner;

public class JO2813 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[] arr = new int[n+1];
        arr[0] = arr[1] = 1;
        for (int i = 2; i*i <= n; i++) {
                if(arr[i] == 0){
                for (int j = i*i; j <= n; j+=i) {
                    arr[j] = 1;
                }
            }
        }

        int cnt = 0;
        for (int i = m; i <= n; i++) {
            if(arr[i] == 0)
                cnt++;
        }
        System.out.println(cnt);
    }
}

package BOJ;

import java.util.Scanner;
import java.util.Arrays;

public class BOJ11399 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] times = new int[N];
        for(int i=0; i<N; i++){
            times[i] = sc.nextInt();
        }

        Arrays.sort(times); // 오름차순
        int ans = 0;
        for(int i=0; i<N; i++){
            ans += times[i] * (N-i);
        }

        System.out.print(ans);
    }
}

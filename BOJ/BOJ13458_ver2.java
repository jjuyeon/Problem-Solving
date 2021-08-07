package BOJ;

import java.util.Scanner;

public class BOJ13458_ver2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int b = sc.nextInt(); // 감독관
        int c = sc.nextInt(); // 부감독관

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ++ans;
            int num = arr[i] - b;
            if(num < 0) continue;
            while(true) {
                int now = num / c;
                if(now == 0) {
                    if(num > 0) {
                        ++ans;
                    }
                    break;
                }
                ans += now;
                num %= c;
            }
        }
        System.out.println(ans);
    }
}

package Jungol;

import java.util.Scanner;

public class JO3427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        char[] arr = sc.next().toCharArray();

        int min, cnt = 0;
        boolean isConnect = true;
        for (int i = 0; i < n; i++) {
            if(isConnect && arr[i] != 'R') {
                isConnect = false;
            } if(!isConnect && arr[i] == 'R') {
                ++cnt;
            }
        }
        min = cnt;

        cnt = 0;
        isConnect = true;
        for (int i = n-1; i >= 0; i--) {
            if(isConnect && arr[i] != 'R') {
                isConnect = false;
            } else if (!isConnect && arr[i] == 'R') {
                ++cnt;
            }
        }
        min = Math.min(min, cnt);

        cnt = 0;
        isConnect = true;
        for (int i = 0; i < n; i++) {
            if(isConnect && arr[i] != 'B') {
                isConnect = false;
            } if(!isConnect && arr[i] == 'B') {
                ++cnt;
            }
        }
        min = Math.min(min, cnt);

        cnt = 0;
        isConnect = true;
        for (int i = n-1; i >= 0; i--) {
            if(isConnect && arr[i] != 'B') {
                isConnect = false;
            } else if (!isConnect && arr[i] == 'B') {
                ++cnt;
            }
        }
        min = Math.min(min, cnt);

        System.out.print(min);
    }
}

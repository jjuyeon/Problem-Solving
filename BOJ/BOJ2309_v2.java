package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2309_v2 {

    static boolean isFinish = false;
    static int[] arr = new int[9];
    static int[] ans = new int[7];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        recur(0, 0,0);
    }

    static void recur(int sum, int start, int idx) {
        if(isFinish){
            return;
        }

        if(idx == 7) {
            if (sum == 100) {
                for (int i = 0; i < 7; i++) {
                    System.out.println(ans[i]);
                }
                isFinish = true;
            }
            return;
        }

        for (int i = start; i < 9; i++) {
            if(sum + arr[i] <= 100) {
                ans[idx] = arr[i];
                recur(sum + arr[i], i+1, idx+1);
            }
        }
    }
}

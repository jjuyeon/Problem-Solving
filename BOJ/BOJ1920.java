package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            boolean isContain = false;
            int pivot, left = 0, right = arr.length - 1;
            int num = sc.nextInt();

            while(left <= right) {
                pivot = (left + right + 1) / 2;

                if(arr[pivot] == num) {
                    isContain = true;
                    break;
                }
                else if(arr[pivot] < num) {
                    left = pivot + 1;
                }
                else if(arr[pivot] > num) {
                    right = pivot - 1;
                }
            }

            if(isContain) {
                System.out.println(1);
            }
            else {
                System.out.println(0);
            }
        }
    }
}

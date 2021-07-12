package Jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JO1836 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int ans = 0, sum = 0;
        String[] arr = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            sum += Integer.parseInt(arr[i]);
            if(sum < 0) sum = 0;
            if(ans < sum) ans = sum;
        }


        System.out.print(ans);
    }
}

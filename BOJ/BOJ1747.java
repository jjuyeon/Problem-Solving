package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1747 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] prime = new boolean[1004001];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i * i <= 1004000; i++) {
            for (int j = i * i; j <= 1004000; j += i) {
                prime[j] = false;
            }
        }

        for (int i = n; i <= 1004000; i++) {
            if (prime[i] && check(i)) {
                System.out.println(i);
                return;
            }
        }
    }

    static boolean check(int num) {
        String str = String.valueOf(num);
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}

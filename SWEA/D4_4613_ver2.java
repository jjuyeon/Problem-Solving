package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class D4_4613_ver2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = Integer.parseInt(sc.next());

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(sc.next());
            int M = Integer.parseInt(sc.next());
            char[][] arr = new char[N][M];
            for (int i = 0; i < N; i++) {
                String line = sc.next();
                for (int j = 0; j < M; j++) {
                    arr[i][j] = line.charAt(j);
                }
            }

            int ans = N*M;
            for (int white = 1; white <= N-2; white++) {
                for (int blue = white + 1; blue <= N-1; blue++) {
                    ans = Math.min(ans, calChangeColor(white, blue, N, M, arr));
                }
            }

            System.out.println("#" + test_case + " " + ans);
        }
    }

    private static int calChangeColor(int white, int blue, int N, int M, char[][] arr) {
        int result = 0;

        for (int i = 0; i < white; i++) { // 흰색
            for (int j = 0; j < M; j++) {
                if(arr[i][j] != 'W') {
                    ++result;
                }
            }
        }
        for (int i=white; i < blue; i++) { // 파란색
            for (int j = 0; j < M; j++) {
                if(arr[i][j] != 'B') {
                    ++result;
                }
            }
        }
        for(int i=blue; i<N; i++) { // 빨간색
            for (int j = 0; j < M; j++) {
                if(arr[i][j] != 'R') {
                    ++result;
                }
            }
        }

        return result;
    }
}

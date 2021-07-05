package Jungol;

import java.util.Scanner;

public class JO1331 {

    static char[][] arr;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new char[2*n][2*n];
        for (int i = 1; i < 2*n; i++) {
            for (int j = 1; j < 2*n; j++) {
                arr[i][j] = ' ';
            }
        }

        int[] dx = {1,1,-1,-1};
        int[] dy = {-1,1,1,-1};
        int x = 1, y = n, loop = n-1;
        char alpha = 'B';
        arr[1][n] = 'A';
        while(loop != 0){
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < loop; j++) {
                    if(i == 3 && j == loop-1) {
                        y -= 1;
                    }
                    else {
                        x += dx[i];
                        y += dy[i];
                    }
                    arr[x][y] = alpha++;
                    if(alpha > 'Z') alpha = 'A';
                }
            }
            loop--;
        }

        for (int i = 1; i < 2*n; i++) {
            for (int j = 1; j < 2*n; j++) {
                // printf 는 실행속도가 느리다..! 그냥 귀찮더라도 print(ln)을 사용하잣 .. !!!
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}

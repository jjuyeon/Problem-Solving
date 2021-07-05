package Jungol;

import java.util.Arrays;
import java.util.Scanner;

public class JO1337 {

    static int[] dx = {1, 0, -1};
    static int[] dy = {1, -1, 0};
    static int[][] arr;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n =sc.nextInt();
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(arr[i], -1);
        }

        int x = 0, y = 0, num = 1, dir = 0, nx, ny;
        boolean isTwice = false;
        arr[0][0] = 0;
        while(true){
            nx = x + dx[dir];
            ny = y + dy[dir];

            if(isImpossible(nx, ny)){
                if(isTwice) break;

                dir = (dir + 1) % 3;
                isTwice = true;
                continue;
            }

            if(isTwice) isTwice = false;

            x = nx; y = ny;
            arr[x][y] = num;
            num = (num + 1) % 10;
        }

        for (int i = 0; i < n; i++) {
            for(int j=0; j <= i; j++){
                System.out.printf("%d ", arr[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean isImpossible(int x, int y){
        if(x < 0 || x >= n || y < 0 || y >= n || arr[x][y] >= 0){
            return true;
        }
        return false;
    }
}

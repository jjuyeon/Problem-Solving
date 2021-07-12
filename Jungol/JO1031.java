package Jungol;

import java.util.Scanner;

public class JO1031 {

    static int[][] arr =  new int[6][6];
    static boolean[][] game = new boolean[6][6];
    static int[] dx = {-1, 1, 0, 0, 1, -1, -1, 1};
    static int[] dy = {0, 0, -1, 1, 1, -1, 1, -1};
    static int bingoCnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <= 25; i++) {
            int[] loc = findNumber(sc.nextInt());
            bingoCnt += isBingo(loc);
            if(bingoCnt >= 3){
                System.out.print(i);
                return;
            }
        }
    }

    private static int[] findNumber(int num) {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                if(arr[i][j] == num){
                    game[i][j] = true;
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    private static boolean isPossible(int x, int y) {
        if(x<1 || x>5 || y<1 || y>5 || !game[x][y])
            return false;

        return true;
    }

    private static int countContinue(int[] loc, int start, int end) {
        int cnt = 1;
        for (int i = start; i < end; i++) {
            int nx = loc[0] + dx[i], ny = loc[1] + dy[i];
            while(isPossible(nx, ny)){
                ++cnt;
                nx += dx[i];
                ny += dy[i];
            }
        }
        return cnt;
    }

    private static int isBingo(int[] loc) {
        int cnt = 0;
        for (int i = 0; i < 8; i+=2) {
            if(countContinue(loc, i, i+2) == 5)
                ++cnt;
        }
        return cnt;
    }
}

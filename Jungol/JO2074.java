package Jungol;

import java.util.Scanner;

public class JO2074 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n+1][n+1];

        /*
        1. 첫 번째 숫자인 1을 넣는 위치는 첫 번째 행 가운데이다.
        2. 숫자가 N의 배수이면 바로 아래의 행으로 이동하여 다음의 수를 넣고
        3. 그렇지 않으면 왼쪽 위로 이동하여 다음의 숫자를 넣는다.
        만약 행이 첫 번째를 벗어나면 마지막 행으로 이동하고, 열이 첫 번째를 벗어나면 마지막 열로 이동한다.
         */
        int x = 1, y = n/2+1, num = 1;
        while(num <= n*n){
            arr[x][y] = num;

            if(num % n == 0) {
                x++;
                if(x > n) x = 1;
            } else {
                x--;
                y--;
                if(x == 0) x = n;
                else if(x > n) x = 1;
                if(y == 0) y = n;
                else if(y > n) y = 1;
            }

            num++;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}

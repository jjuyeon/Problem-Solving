package BOJ;

import java.util.Scanner;

public class BOJ2999 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.next().toCharArray();
        int len = arr.length;
        int R = findR(len);
        int C = len/R;

        int arrIdx = 0;
        char[][] matrix = new char[R][C];
        for(int j=0; j<C; j++){
            for(int i=0; i<R; i++){
                matrix[i][j] = arr[arrIdx++];
            }
        }

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                System.out.print(matrix[i][j]);
            }
        }
    }

    static int findR(int n){
        int result = 0;
        for(int i=1; i<n; i++){
            if(n%i == 0){
                if(i > n/i){
                    break;
                }
                result = Math.max(result, i);
            }
        }
        return result;
    }
}

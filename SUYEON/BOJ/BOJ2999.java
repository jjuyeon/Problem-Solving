package BOJ;

import java.util.Scanner;

public class BOJ2999 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.next().toCharArray();
        int len = arr.length;

        // 구해보니 방법1 이나 방법2나 시간은 비슷했음;;

        // 방법 1 (앞에서부터 탐색)
//        int R = findR(len);
//        int C = len/R;

        // 방법2 (뒤에서부터 탐색 - 왜? R이 최대인 값을 구해야하므로)
        int R = 1, C = len;
        for(int i=(int)Math.sqrt(len); i>0; i--){ // R은 C보다 같거나 작으므로 Math.sqrt(제곱근)값을 넘지 못함
            if(len%i == 0){
                R = i;
                C = len/i;
                break;
            }
        }

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

    // 방법1
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

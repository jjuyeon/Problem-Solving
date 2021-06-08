package BOJ;

import java.io.*;
import java.util.*;

public class BOJ16927 {

    static int n, m;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = stoi(st.nextToken());
        m = stoi(st.nextToken());
        int r = stoi(st.nextToken());

        arr = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = stoi(st.nextToken());
            }
        }

        int startRow = 0, endRow = n, startColumn = 0, endColumn = m;
        while(true){
            if(startRow == endRow || startColumn == endColumn){
                break;
            }

            int rotationCnt = 2*(endRow-startRow + endColumn-startColumn) - 4;
            rotation(startRow, endRow, startColumn, endColumn, r % rotationCnt);
            startRow++;
            endRow--;
            startColumn++;
            endColumn--;
        }

        printResult();
    }

    static void rotation(int startRow, int endRow, int startColumn, int endColumn, int r){
        for(int l=0; l<r; l++){
            int temp = arr[startRow][startColumn];

            // 왼쪽
            for(int i=startColumn; i<endColumn-1; i++){
                arr[startRow][i] = arr[startRow][i+1];
            }
            // 위
            for(int i=startRow; i<endRow-1; i++){
                arr[i][endColumn-1] = arr[i+1][endColumn-1];
            }
            // 오른쪽
            for(int i=endColumn-1; i>startColumn; i--){
                arr[endRow-1][i] = arr[endRow-1][i-1];
            }
            // 아래
            for(int i=endRow-1; i>startRow; i--){
                arr[i][startColumn] = arr[i-1][startColumn];
            }

            arr[startRow+1][startColumn] = temp;
        }
    }

    static void printResult(){
        for(int[] array : arr){
            for(int i : array){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}

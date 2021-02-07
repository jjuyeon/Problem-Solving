package BOJ;

import java.io.*;
import java.util.*;

public class BOJ16926 {

    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = stoi(st.nextToken());
        int m = stoi(st.nextToken());
        int r = stoi(st.nextToken());

        arr = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = stoi(st.nextToken());
            }
        }

        for(int i=0; i<r; i++){
            rotation(0, n, 0, m, new int[n][m]);
        }
        printResult();
    }

    static void rotation(int sx, int ex, int sy, int ey, int[][] result){
        if(sx==ex || sy==ey){ // 기저조건
            arr = result;
            return;
        }

        // 아래
        for(int i=sx; i<ex-1; i++){
            result[i+1][sy] = arr[i][sy];
        }
        // 오른쪽
        for(int i=sy; i<ey-1; i++){
            result[ex-1][i+1] = arr[ex-1][i];
        }
        // 위
        for(int i=ex-1; i>sx; i--){
            result[i-1][ey-1] = arr[i][ey-1];
        }
        // 왼쪽
        for(int i=ey-1; i>sy; i--){
            result[sx][i-1] = arr[sx][i];
        }

        rotation(sx+1, ex-1, sy+1, ey-1, result);
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

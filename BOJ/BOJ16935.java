package BOJ;

import java.io.*;
import java.util.*;

public class BOJ16935 {

    static String[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken());
        int M = stoi(st.nextToken());
        int R = stoi(st.nextToken());

        arr = new String[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = st.nextToken();
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<R; i++){
            int selectN = stoi(st.nextToken());

            switch(selectN){
                case 1:
                    upDown();
                    break;
                case 2:
                    leftRight();
                    break;
                case 3:
                    right90();
                    break;
                case 4:
                    left90();
                    break;
                case 5:
                    rotationClock();
                    break;
                case 6:
                    rotationReverse();
            }
        }
        printResult();
    }

    static void upDown(){
        for(int c = 0; c < arr[0].length; c++){
            for(int i=0, j=arr.length-1; i<j; i++, j--){
                String temp = arr[i][c];
                arr[i][c] = arr[j][c];
                arr[j][c] =temp;
            }
        }
    }

    static void leftRight(){
        for(int c = 0; c< arr.length; c++){
            for(int i=0, j=arr[0].length-1; i<j; i++, j--){
                String temp = arr[c][i];
                arr[c][i] = arr[c][j];
                arr[c][j] = temp;
            }
        }
    }

    static void right90(){
        String[][] result = new String[arr[0].length][arr.length];
        for(int j=0; j<arr.length; j++){
            for(int i=0; i<arr[0].length; i++){
                result[i][arr.length-j-1] = arr[j][i];
            }
        }

        arr = result;
    }

    static void left90(){
        String[][] result = new String[arr[0].length][arr.length];
        for(int j=0; j<arr.length; j++){
            for(int i=0; i<arr[0].length; i++){
                result[arr[0].length-i-1][j] = arr[j][i];
            }
        }

        arr = result;
    }

    static void rotationClock(){
        String[][] result = new String[arr.length][arr[0].length];
        int xSize = arr.length;
        int ySize = arr[0].length;

        // 1->2
        for(int i=0; i<xSize/2; i++){
            for(int j=0; j<ySize/2; j++){
                result[i][j + ySize/2] = arr[i][j];
            }
        }
        // 2->3
        for(int i=0; i<xSize/2; i++){
            for(int j=ySize/2; j<ySize; j++){
                result[i + xSize/2][j] = arr[i][j];
            }
        }
        // 3->4
        for(int i=xSize/2; i<xSize; i++){
            for(int j=ySize/2; j<ySize; j++){
                result[i][j - ySize/2] = arr[i][j];
            }
        }
        // 4->1
        for(int i=xSize/2; i<xSize; i++){
            for(int j=0; j<ySize/2; j++){
                result[i - xSize/2][j] = arr[i][j];
            }
        }

        arr = result;
    }
    static void rotationReverse(){
        String[][] result = new String[arr.length][arr[0].length];
        int xSize = arr.length;
        int ySize = arr[0].length;

        // 1->4
        for(int i=0; i<xSize/2; i++){
            for(int j=0; j<ySize/2; j++){
                result[i + xSize/2][j] = arr[i][j];
            }
        }
        // 4->3
        for(int i=xSize/2; i<xSize; i++){
            for(int j=0; j<ySize/2; j++){
                result[i][j + ySize/2] = arr[i][j];
            }
        }
        // 3->2
        for(int i=xSize/2; i<xSize; i++){
            for(int j=ySize/2; j<ySize; j++){
                result[i - xSize/2][j] = arr[i][j];
            }
        }
        // 2->1
        for(int i=0; i<xSize/2; i++){
            for(int j=ySize/2; j<ySize; j++){
                result[i][j - ySize/2] = arr[i][j];
            }
        }

        arr = result;
    }

    static void printResult(){
        StringBuilder sb = new StringBuilder();
        for(String[] ar : arr){
            for(String str : ar){
                sb.append(str).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    static int stoi(String str){
        return Integer.parseInt(str);
    }
}

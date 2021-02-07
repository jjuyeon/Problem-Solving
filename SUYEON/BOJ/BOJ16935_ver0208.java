package BOJ;

import java.io.*;
import java.util.*;

public class BOJ16935_ver0208 {

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
                    one();
                    break;
                case 2:
                    two();
                    break;
                case 3:
                    three();
                    break;
                case 4:
                    four();
                    break;
                case 5:
                    five();
                    break;
                case 6:
                    six();
            }
        }

        for(String[] s : arr){
            for(String str : s){
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }

    static void one(){
        int row = arr.length;
        int col = arr[0].length;

        for(int i=0; i<row/2; i++){
            for(int j=0; j<col; j++){
                String temp = arr[i][j];
                arr[i][j] = arr[row-1-i][j];
                arr[row-1-i][j] = temp;
            }
        }
    }

    static void two(){
        int row = arr.length;
        int col = arr[0].length;

        for(int j=0; j<col/2; j++){
            for(int i=0; i<row; i++){
                String temp = arr[i][j];
                arr[i][j] = arr[i][col-1-j];
                arr[i][col-1-j] = temp;
            }
        }
    }

    static void three(){
        String[][] temp = new String[arr[0].length][arr.length];
        for(int j=0; j<arr.length; j++){
            for(int i=0; i<arr[0].length; i++){
                temp[i][arr.length-1-j] = arr[j][i];
            }
        }

        arr = temp;
    }

    static void four(){
        String[][] temp = new String[arr[0].length][arr.length];
        for(int j=0; j<arr.length; j++){
            for(int i=0; i<arr[0].length; i++){
                temp[arr[0].length-1-i][j] = arr[j][i];
            }
        }

        arr = temp;
    }

    static void five(){
        String[][] temp = new String[arr.length][arr[0].length];
        // 1->2
        for(int i=0; i<arr.length/2; i++){
            for(int j=0; j<arr[0].length/2; j++){
                temp[i][arr[0].length/2+j] = arr[i][j];
            }
        }
        // 2->3
        for(int i=0; i<arr.length/2; i++){
            for(int j=arr[0].length/2; j<arr[0].length; j++){
                temp[arr.length/2+i][j] = arr[i][j];
            }
        }
        // 3->4
        for(int i=arr.length/2; i<arr.length; i++){
            for(int j=arr[0].length/2; j<arr[0].length; j++){
                temp[i][j-arr[0].length/2] = arr[i][j];
            }
        }
        // 4->1
        for(int i=arr.length/2; i<arr.length; i++){
            for(int j=0; j<arr[0].length/2; j++){
                temp[i-arr.length/2][j] = arr[i][j];
            }
        }

        arr = temp;
    }

    static void six(){
        String[][] temp = new String[arr.length][arr[0].length];
        // 1->4
        for(int i=0; i<arr.length/2; i++) {
            for (int j=0; j<arr[0].length/2; j++) {
                temp[i+arr.length/2][j] = arr[i][j];
            }
        }
        // 4->3
        for(int i=arr.length/2; i<arr.length; i++){
            for(int j=0; j<arr[0].length/2; j++){
                temp[i][j+arr[0].length/2] = arr[i][j];
            }
        }
        // 3->2
        for(int i=arr.length/2; i<arr.length; i++){
            for(int j=arr[0].length/2; j<arr[0].length; j++){
                temp[i-arr.length/2][j] = arr[i][j];
            }
        }
        // 2->1
        for(int i=0; i<arr.length/2; i++){
            for(int j=arr[0].length/2; j<arr[0].length; j++){
                temp[i][j-arr[0].length/2] = arr[i][j];
            }
        }
        arr = temp;
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}

package BOJ;

import java.util.*;
import java.io.*;

public class BOJ2167 {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi(st.nextToken());
        int m = stoi(st.nextToken());
        int[][] matrix = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                matrix[i][j] = stoi(st.nextToken());
            }
        }

        int k = stoi(br.readLine());
        while(k > 0){
            st = new StringTokenizer(br.readLine());
            int i = stoi(st.nextToken());
            int j = stoi(st.nextToken());
            int x = stoi(st.nextToken());
            int y = stoi(st.nextToken());

            int sum = 0;
            for(int row = i-1; row<x; row++){
                for(int col = j-1; col<y; col++)
                    sum += matrix[row][col];
            }
            sb.append(sum).append("\n");

            k--;
        }

        System.out.print(sb.toString());
    }

    static int stoi(String str){
        return Integer.parseInt(str);
    }
}

package BOJ;

import java.io.*;
import java.util.*;

public class BOJ17406 {

    static int n, m, k, ans;
    static int[][] matrix;
    static Point[] orders;

    static class Point{
        int sr, sc, er, ec;
        Point(int sr, int sc, int er, int ec){
            this.sr = sr;
            this.sc = sc;
            this.er = er;
            this.ec = ec;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = stoi(st.nextToken());
        m = stoi(st.nextToken());
        k = stoi(st.nextToken());
        matrix = new int[n+1][m+1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=m; j++){
                matrix[i][j] = stoi(st.nextToken());
            }
        }

        orders = new Point[k];
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int r = stoi(st.nextToken());
            int c = stoi(st.nextToken());
            int s = stoi(st.nextToken());
            orders[i] = new Point(r-s, c-s, r+s, c+s);
        }

        ans = Integer.MAX_VALUE;
        permutation(0, new boolean[k]);
        System.out.print(ans);
    }

    private static void permutation(int idx, boolean[] visited){
        if(idx == k){
            ans = Math.min(ans, findMinVal()); // 한 턴이 끝나면 최소값 업데이트
            return;
        }

        for(int i=0; i<k; i++){
            if(!visited[i]){
                // 한 턴 시작
                visited[i] = true;
                rotation(orders[i].sr, orders[i].sc, orders[i].er, orders[i].ec); // 1회전(시계방향)
                permutation(idx+1, visited);
                // 한 턴 끝
                visited[i] = false; // 방문했던 곳 -> 다시 방문 취소
                backRotation(orders[i].sr, orders[i].sc, orders[i].er, orders[i].ec); // 시계방향으로 회전했던 만큼 다시 되돌린다(반시계방향)
            }
        }
    }

    private static void rotation(int startRow, int startCol, int endRow, int endCol){ // 시계방향
        if(startRow == endRow || startCol == endCol){
            return;
        }

        // 시계방향
        int temp = matrix[startRow][startCol];
        // 위
        for(int i=startRow; i<endRow; i++){
            matrix[i][startCol] = matrix[i+1][startCol];
        }
        // 왼쪽
        for(int j=startCol; j<endCol; j++){
            matrix[endRow][j] = matrix[endRow][j+1];
        }
        // 아래
        for(int i=endRow; i>startRow; i--){
            matrix[i][endCol] = matrix[i-1][endCol];
        }
        // 오른쪽
        for(int j=endCol; j>startCol; j--){
            matrix[startRow][j] = matrix[startRow][j-1];
        }

        matrix[startRow][startCol+1] = temp;
        rotation(startRow+1, startCol+1, endRow-1, endCol-1);
    }

    static void backRotation(int startRow, int startCol, int endRow, int endCol){ // 반시계방향
        if(startRow == endRow || startCol == endCol){
            return;
        }

        int temp = matrix[startRow][startCol];

        // 왼쪽
        for(int i=startCol; i<endCol; i++){
            matrix[startRow][i] = matrix[startRow][i+1];
        }
        // 위
        for(int i=startRow; i<endRow; i++){
            matrix[i][endCol] = matrix[i+1][endCol];
        }
        // 오른쪽
        for(int i=endCol; i>startCol; i--){
            matrix[endRow][i] = matrix[endRow][i-1];
        }
        // 아래
        for(int i=endRow; i>startRow; i--){
            matrix[i][startCol] = matrix[i-1][startCol];
        }

        matrix[startRow+1][startCol] = temp;
        backRotation(startRow+1, startCol+1, endRow-1, endCol-1);
    }

    private static int findMinVal(){
        int min = Integer.MAX_VALUE;
        for(int i=1; i<=n; i++){
            int now = 0;
            for(int j=1; j<=m; j++){
                now += matrix[i][j];
            }
            min = Math.min(min, now);
        }
        return min;
    }

    private static int stoi(String s){
        return Integer.parseInt(s);
    }
}

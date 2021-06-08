package BOJ;

/**
 * 체스판의 칸 하나 하나를 모든 규칙에 비교한다는 점에서 브루트 포스 알고리즘 문제였다
 * 내가 간과한 점: 체스판의 시작이 무엇이든 두 가지 규칙과 비교해야함(하나는 맨 왼쪽 위 칸이 흰색인 경우, 하나는 검은색인 경우)
 */

import java.io.*;
import java.util.*;

public class BOJ1018 {
    static char[][] matrix;
    static int n, m;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrix = new char[n][m];
        for(int i=0; i<n; i++){
            String line = br.readLine();
            for(int j=0; j<m; j++){
                matrix[i][j] = line.charAt(j);
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<=n-8; i++){
            for(int j=0; j<=m-8; j++){
                min = Math.min(min, getChangeTile(i,j,'W'));
                min = Math.min(min, getChangeTile(i,j,'B'));
            }
        }
        System.out.println(min);
    }

    static int getChangeTile(int x, int y, char startTile){
        int count = 0;

        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                int nx = x + i;
                int ny = y + j;
                if(i%2 == 0){ // 같은 모양
                    if(j%2 == 0){
                        if(matrix[nx][ny] != startTile)
                            count++;
                    }
                    else{
                        if(matrix[nx][ny] == startTile)
                            count++;
                    }
                }
                else{ // 다른 모양
                    if(j%2 == 0){
                        if(matrix[nx][ny] == startTile)
                            count++;
                    }
                    else{
                        if(matrix[nx][ny] != startTile)
                            count++;
                    }
                }
            }
        }
        return count;
    }
}

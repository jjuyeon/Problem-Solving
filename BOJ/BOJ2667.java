package BOJ;

import java.io.*;
import java.util.*;

/**
 * 내가 부족한 점: 연결된 부분을 찾는 문제 -> 그래프/트리 문제아닐까 라는 insight가 아직 부족, 재귀 cycle 이해 부족
 * 이 문제에서 고생한 점: 인덱싱을 잘못함 (nx = i + dx[i]; -> nx = x + dx[i];) // 노답.. 실전이었으면 시간 다 까먹었음
 */
public class BOJ2667 {
    static int n, count;
    static int[][] matrix;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        visited = new boolean[n][n];
        matrix = new int[n][n];
        for(int i=0; i<n; i++){
            String line = br.readLine();
            for(int j=0; j<n; j++)
                matrix[i][j] = line.charAt(j) - '0';
        }

        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 1 && !visited[i][j]){
                    count = 1;
                    dfs(i,j);
                    result.add(count);
                }
            }
        }
        Collections.sort(result);

        System.out.println(result.size());
        for(int c : result)
            System.out.println(c);
    }

    static void dfs(int x, int y){
        visited[x][y] = true;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<n){
                if(matrix[nx][ny] == 1 && !visited[nx][ny]){
                    count++;
                    dfs(nx,ny);
                }
            }
        }
    }
}

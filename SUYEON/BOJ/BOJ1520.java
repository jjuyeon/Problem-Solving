package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1520 {

    static int n, m;
    static int[][] map, memoization;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = stoi(st.nextToken());
        m = stoi(st.nextToken());

        memoization = new int[n][m];
        map = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = stoi(st.nextToken());
                memoization[i][j] = -1;
            }
        }

        // (0,0) -> (n-1,m-1)까지 이동하는 경우의 수
        System.out.print(dfs(0, 0));
    }

    private static int dfs(int r, int c){
        if(memoization[r][c] != -1){ // 업데이트된 값이면 다시 계산하지 않고 계산해둔 값을 리턴
            return memoization[r][c];
        }

        if(r==n-1 && c==m-1){ // 기저조건(도착점에 도달했따!)
            return 1;
        }

        memoization[r][c] = 0; // 방문했음을 체크

        for(int i=0; i<4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr<0 || nr>=n || nc<0 || nc>=m) continue;

            // 내리막일 경우,
            // (nr, nc)에서 끝점까지 도달하는 경로의 개수를 더한다.
            if(map[r][c] > map[nr][nc]) memoization[r][c] += dfs(nr, nc);
        }
        return memoization[r][c]; // 완성된 경우의 수 출력
    }

    private static int stoi(String str){
        return Integer.parseInt(str);
    }
}

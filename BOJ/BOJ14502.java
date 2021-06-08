package BOJ;

import java.io.*;
import java.util.*;

public class BOJ14502 {

    static int n, m, ans;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = stoi(st.nextToken());
        m = stoi(st.nextToken());
        map = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = stoi(st.nextToken());
            }
        }

        dfs(0);
        System.out.print(ans);
    }

    private static void dfs(int cnt){
        if(cnt == 3){ // 벽을 3개 만들었을 때
            int[][] temp = new int[n][m]; // map과 똑같은 배열을 하나 생성한다
            for(int i=0; i<n; i++){
                System.arraycopy(map[i], 0, temp[i], 0, m);
            }

            spreadVirus(temp); // 확산될 수 있는 공간에 바이러스가 확산된다
            ans = Math.max(ans, getBlankArea(temp)); // 바이러스가 확산되지 못한 공간 수를 구해 최대 값을 구한다
            return;
        }
        for(int i=0; i<n; i++){ // 완탐
            for(int j=0; j<m; j++){
                if(map[i][j] == 0){
                    map[i][j] = 1; // 벽 하나 추가
                    dfs(cnt+1); // 추가했으므로 인자값 +1
                    map[i][j] = 0; // 다음 턴에는 해당 벽은 무너지므로 다시 되돌려둔다
                }
            }
        }
    }

    private static void spreadVirus(int[][] temp){
        int[] dr = {-1, 1, 0, 0}; // 상하좌우
        int[] dc = {0, 0, -1, 1};
        boolean flag = true;
        while(flag) {
            flag = false;
            for (int i = 0; i < n; i++) { // 완탐
                for (int j = 0; j < m; j++) {
                    if (temp[i][j] == 2) { // 바이러스 위치
                        for (int k = 0; k < 4; k++) {
                            int nr = i + dr[k];
                            int nc = j + dc[k];
                            if (nr >= 0 && nr < n && nc >= 0 && nc < m && temp[nr][nc] == 0) { // 빈칸이라면
                                flag = true; // 다음 턴에 바이러스가 또 확산될 수 있는 가능성이 있다
                                temp[nr][nc] = 2; // 해당 빈칸은 바이러스에 감염된다
                            }
                        }
                    }
                }
            }

            if(!flag){ // 다음턴에 바이러스가 확산될 가능성이 없으므로(모든 위치를 다 돌았을 때, 빈칸->바이러스로 변한 공간이 없다)
                break; // 끝냄
            }
        }
    }

    private static int getBlankArea(int[][] temp){ // 빈칸(0)을 구한다
        int result = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(temp[i][j] == 0){
                    ++result;
                }
            }
        }
        return result;
    }

    private static int stoi(String s){
        return Integer.parseInt(s);
    }
}

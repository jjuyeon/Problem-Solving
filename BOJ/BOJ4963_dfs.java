package BOJ;

import java.io.*;
import java.util.*;

public class BOJ4963_dfs {

    static int w, h;
    static int[][] map;
    static boolean[][] v;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            w = stoi(st.nextToken());
            h = stoi(st.nextToken());

            if(w==0 && h==0){ // 프로그램 종료
                break;
            }

            v = new boolean[h][w];
            map = new int[h][w];
            for(int i=0; i<h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++){
                    map[i][j] = stoi(st.nextToken());
                }
            }

            int cnt = 0;
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(!v[i][j] && map[i][j]==1){
                        cnt++;
                        dfs(i, j);
                    }
                }
            }
            sb.append(cnt).append("\n");
        }

        System.out.print(sb.toString());
    }

    static int[] dr = {-1,1,0,0,-1,-1,1,1}; // 8방검색
    static int[] dc = {0,0,-1,1,-1,1,-1,1};

    private static void dfs(int r, int c){
        for(int i=0; i<8; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr<0 || nr>=h || nc<0 || nc>=w || v[nr][nc] || map[nr][nc]!=1){
                continue;
            }
            v[nr][nc] = true;
            dfs(nr, nc);
        }
    }

    private static int stoi(String s){
        return Integer.parseInt(s);
    }
}

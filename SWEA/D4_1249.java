package SWEA;

import java.io.*;
import java.util.*;

public class D4_1249 {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Pos implements Comparable<Pos> {
        int r, c, time;
        Pos(int r, int c, int time){
            this.r = r;
            this.c = c;
            this.time = time;
        }

        @Override
        public int compareTo(Pos o){
            return Integer.compare(this.time, o.time);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = stoi(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = stoi(br.readLine());
            int[][] map = new int[n][n];
            for(int i=0; i<n; i++){
                String str = br.readLine();
                for(int j=0; j<n; j++){
                    map[i][j] = stoi(String.valueOf(str.charAt(j)));
                }
            }

            int[][] minValue = new int[n][n];
            for(int i=0; i<n; i++){
                Arrays.fill(minValue[i], Integer.MAX_VALUE);
            }
            System.out.println("#"+test_case+" "+bfs(map, n, new boolean[n][n], minValue));
        }
    }

    private static int bfs(int[][] map, int n, boolean[][] visited, int[][] minValue){
        PriorityQueue<Pos> queue = new PriorityQueue<>();
        queue.offer(new Pos(0, 0, 0));
        visited[0][0] = true;
        minValue[0][0] = 0;

        int min = 0;
        while(!queue.isEmpty()){
            Pos now = queue.poll();
            int r = now.r;
            int c = now.c;
            int time = now.time;

            if(r == n-1 && c == n-1){ // 종료조건
                min = time;
                break;
            }

            for(int i=0; i<4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr<0 || nr>=n || nc<0 || nc>=n) continue;

                int ntime = time + map[nr][nc];
                if(!visited[nr][nc] || ntime < minValue[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.offer(new Pos(nr, nc, ntime));
                    minValue[nr][nc] = ntime;
                }
            }
        }

        return min;
    }

    private static int stoi(String s){
        return Integer.parseInt(s);
    }
}

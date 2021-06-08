package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1261 {

    static int n, m;
    static char[][] maze;
    static class Pos implements Comparable<Pos>{
        int r, c, crush;
        Pos(int r, int c, int crush){
            this.r = r;
            this.c = c;
            this.crush = crush;
        }

        @Override
        public int compareTo(Pos o){
            return Integer.compare(this.crush, o.crush);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        maze = new char[n+1][m+1];
        for(int i=1; i<=n; i++){
            String str = br.readLine();
            for(int j=1; j<=m; j++){
                maze[i][j] = str.charAt(j-1);
            }
        }

        bfs();
    }


    private static void bfs(){
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        boolean[][][] visited = new boolean[n+1][m+1][n*m];
        PriorityQueue<Pos> queue = new PriorityQueue<>();
        visited[1][1][0] = true;
        queue.offer(new Pos(1, 1, 0));

        int ans = 0;
        while(!queue.isEmpty()){
            Pos now = queue.poll();
            int r = now.r;
            int c = now.c;
            int crush = now.crush;

            if(r == n && c == m) { // 종료조건
                ans = crush;
                break; // 제일 처음 종료 위치에 도달한 것은 우선순위 큐에 의해서 벽을 제일 적게 부순 경로이다
            }

            for(int i=0; i<4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                int ncrush = crush;

                if(nr<1 || nr>n || nc<1 || nc>m) continue; // 범위를 벗어남

                if(maze[nr][nc] == '1'){ // 벽일 경우
                    ++ncrush; // 벽을 부순 횟수 +1
                }

                if(!visited[nr][nc][ncrush]){ // 현재 경로에서 방문하지 않은 위치라면 큐에 추가
                    queue.offer(new Pos(nr, nc, ncrush));
                    visited[nr][nc][ncrush] = true;
                }
            }
        }
        System.out.print(ans);
    }
}

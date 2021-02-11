package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2206_3DimensionArr {

    static int n, m, ans;
    static char[][] map;
    static boolean[][][] visited;

    static class Point{
        int x, y, cnt, drill;
        Point(int x, int y, int cnt, int drill){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.drill = drill;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m][2];
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = str.charAt(j);
            }
        }

        ans = -1;
        bfs();
        System.out.print(ans);
    }

    static int[] dr = {-1,1,0,0}; // 상하좌우
    static int[] dc = {0,0,-1,1};

    static void bfs(){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0,0, 1, 0)); // start 입력
        visited[0][0][0] = true; // 벽을 안부신 경우
        visited[0][0][1] = true; // 벽을 부신 경우

        while(!queue.isEmpty()){
            Point nowPos = queue.poll();

            if(nowPos.x == n-1 && nowPos.y == m-1){ // 도착!
                ans = nowPos.cnt;
                return;
            }

            for(int i=0; i<4; i++){
                int nr = nowPos.x + dr[i];
                int nc = nowPos.y + dc[i];
                int nCnt = nowPos.cnt + 1;
                int nDrill = nowPos.drill;

                if(nr>=0 && nr<n && nc>=0 && nc<m){
                    if(map[nr][nc] == '0'){ // 벽X
                        if(!visited[nr][nc][nDrill]) { // 방문한 적 없으면 (drill이 0이든 1이든 상관없음)
                            queue.offer(new Point(nr, nc, nCnt, nDrill));
                            visited[nr][nc][nDrill] = true;
                        }
                    }
                    else{ // 벽
                        if(nDrill == 0 && !visited[nr][nc][1]){ // 벽을 뚫지 않은 상황 && 다음 좌표를 방문한 적 없을 때
                            queue.offer(new Point(nr, nc, nCnt, nDrill+1));
                            visited[nr][nc][1] = true;
                        }
                    }
                }
            }
        }
    }
}

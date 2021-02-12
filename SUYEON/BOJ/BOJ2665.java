package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2665 {

    static int n;
    static char[][] map;
    static int[][] visit;

    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visit = new int[n][n];
        map = new char[n][n];
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<n; j++){
                map[i][j] = str.charAt(j);
                visit[i][j] = Integer.MAX_VALUE; // 최소값을 구하기 위해 최대로 초기화
            }
        }

        int ans = bfs();
        System.out.println(ans);
    }

    static int[] dr = {-1,1,0,0}; // 4방탐색
    static int[] dc = {0,0,-1,1};

    private static int bfs(){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0,0));
        visit[0][0] = 0;

        while(!queue.isEmpty()){
            Point nowPos = queue.poll();

            for(int i=0; i<4; i++){
                int nr = nowPos.x + dr[i];
                int nc = nowPos.y + dc[i];

                if(nr<0 || nr>=n || nc<0 || nc>=n){
                    continue;
                }

                if(map[nr][nc] == '0'){ // 검은방
                    // 현재 위치(검은방)를 흰방으로 바꾼 횟수가 더 작으면
                    if(visit[nr][nc] > visit[nowPos.x][nowPos.y]+1){
                        visit[nr][nc] = visit[nowPos.x][nowPos.y]+1;
                        queue.offer(new Point(nr, nc));
                    }
                }
                else{ // 흰방
                    if(visit[nr][nc] > visit[nowPos.x][nowPos.y]){
                        visit[nr][nc] = visit[nowPos.x][nowPos.y];
                        queue.offer(new Point(nr, nc));
                    }
                }
            }
        }

        return visit[n-1][n-1];
    }
}

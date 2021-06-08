package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1600 {

    static class Pos {
        int r, c, jump, cnt;
        Pos(int r, int c, int jump, int cnt){
            this.r = r;
            this.c = c;
            this.jump = jump;
            this.cnt = cnt;
        }
    }

    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int k = stoi(br.readLine());
        st = new StringTokenizer(br.readLine());
        int w = stoi(st.nextToken());
        int h = stoi(st.nextToken());

        map = new int[h][w]; // 0, 0 에서 h-1, w-1까지 최소 거리 구하기
        for(int i=0; i<h; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<w; j++){
                map[i][j] = stoi(st.nextToken());
            }
        }

        bfs(h, w, k);
    }

    private static void bfs(int h, int w, int k){
        int[][] dir_k = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}}; // 말처럼 뛰기
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 4방탐색

        boolean[][][] visited = new boolean[h][w][k+1]; // (말처럼 뛸 때 / 그냥 뛸 때)를 모두 탐색하기 위해서 3차원 배열을 사용
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(new Pos(0,0,0,0));
        visited[0][0][0] = true;

        int ans = -1;
        while(!queue.isEmpty()){
            Pos now = queue.poll();
            int r = now.r;
            int c = now.c;
            int jump = now.jump;
            int cnt = now.cnt;

            if(r==h-1 && c==w-1){ // 도착점에 도달
                ans = cnt;
                break;
            }

            // 현재 위치에서 갈 수 있는 원숭이 위치를 다 구해보자
            if(jump < k){ // k가 남았을 때 말처럼 움직이는 경우로 원숭이 위치를 옮기자
                for(int i=0; i<8; i++){
                    int nr = r + dir_k[i][0];
                    int nc = c + dir_k[i][1];

                    // 장애물이 있는 곳으로는 이동할 수 없다. but, 장애물을 뛰어넘을 수 있다.
                    if(nr<0 || nr>=h || nc<0 || nc>=w || visited[nr][nc][jump+1] || map[nr][nc] == 1) continue;

                    queue.offer(new Pos(nr, nc, jump+1, cnt+1));
                    visited[nr][nc][jump+1] = true;
                }
            }

            // 4방탐색으로 원숭이 위치를 옮기자
            for(int i=0; i<4; i++){
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];

                // 장애물이 있는 곳으로는 이동할 수 없다.
                if(nr<0 || nr>=h || nc<0 || nc>=w || visited[nr][nc][jump] || map[nr][nc] == 1) continue;

                queue.offer(new Pos(nr, nc, jump, cnt+1));
                visited[nr][nc][jump] = true;
            }
        }

        System.out.print(ans);
    }

    private static int stoi(String str){
        return Integer.parseInt(str);
    }
}

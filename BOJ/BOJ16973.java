package BOJ;

import java.util.*;

public class BOJ16973 {

    static class Pos {
        int r, c, cnt;
        Pos(int r, int c, int cnt){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    static int n, m;
    static int[][] map;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n+1][m+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                map[i][j] = sc.nextInt();
            }
        }

        int h = sc.nextInt();
        int w = sc.nextInt();

        int sx = sc.nextInt();
        int sy = sc.nextInt();

        int dx = sc.nextInt();
        int dy = sc.nextInt();


        bfs(sx, sy, dx, dy, w, h);
    }

    private static void bfs(int source_x, int source_y, int destination_x, int destination_y, int w, int h){
        // 1. queue에서 poll한 후, 도착 위치와 일치하는지 체크
        // 2. 상하좌우로 직사각형 시작 좌표를 옮겨본다
        // 3. 1) 직사각형 시작 위치 범위가 벗어나지 않는지 체크
        // 4. 2) 격자 판 안에 직사각형이 존재하는지 체크
        // 5. 3) 직사각형 범위 안에 벽이 존재하진 않는지 체크 -> 하나씩 이동하므로 계속 누적됨, 그때그때의 경계선에 대해서만 확인하면 됨(누적합)
        // 6. 4) 이미 방문한 곳은 아닌지 체크
        // 7. 모두 만족하면 queue에 넣고 방문배열 체크
        // 8. 다 돌았는데 도착 위치에 방문하지 못했다면 -1

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        boolean[][] visited = new boolean[n+1][m+1];
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(new Pos(source_x, source_y, 0));
        visited[source_x][source_y] = true;

        int ans = -1;
        while(!queue.isEmpty()){
            Pos now = queue.poll();
            int r = now.r;
            int c = now.c;
            int cnt = now.cnt;

            if(r == destination_x && c == destination_y){
                ans = cnt;
                break;
            }

            for(int i=0; i<4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(checkAvailableArea(nr, nc, w, h, i) && !visited[nr][nc]) {
                    queue.offer(new Pos(nr, nc, cnt + 1));
                    visited[nr][nc] = true;
                }
            }
        }

        System.out.print(ans);
    }

    private static boolean checkAvailableArea(int x, int y, int width, int height, int d){
        if(x<1 || x>n || y<1 || y>m) return false;

        if(x+height-1 > n) return false;
        if(y+width-1 > m) return false;

        if(d == 0){ // 상
            for(int j=y; j<y+width; j++)
                if(map[x][j] == 1) return false;
        }
        else if(d == 1){ // 하
            for(int j=y; j<y+width; j++)
                if(map[x+height-1][j] == 1) return false;
        }
        else if(d == 2){ // 좌
            for(int i=x; i<x+height; i++)
                if(map[i][y] == 1) return false;
        }
        else if(d == 3){ // 우
            for(int i=x; i<x+height; i++)
                if(map[i][y+width-1] == 1) return false;
        }

        return true;
    }
}

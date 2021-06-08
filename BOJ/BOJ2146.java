package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2146 {

    static int[][] map;
    static int n, ans;

    static class Pos{
        int x, y, cnt;
        Pos(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = stoi(br.readLine());
        map = new int[n][n];
        for(int i=0; i<n; i++){ // 맵 만들기
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = stoi(st.nextToken());
            }
        }

        makeLankMarking(); // 이어지는 하나의 섬에 번호 붙여주기

        ans = 10000; // 최대값
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j]>1){ // 섬인 위치 모두 검사한다 (다른 섬으로 가는 최소 다리)
                    bfs(i, j, map[i][j]); // 최소 거리 구하는 것이므로 bfs를 사용한다
                }
            }
        }

        System.out.print(ans);
    }

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    private static void bfs(int r, int c, int num){
        boolean[][] v = new boolean[n][n];
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(new Pos(r, c, 0));
        v[r][c] = true;

        while(!queue.isEmpty()){
            Pos now = queue.poll();
            for(int i=0; i<4; i++){
                int nr = now.x + dr[i];
                int nc = now.y + dc[i];
                if(nr<0 || nr>=n || nc<0 || nc>=n || v[nr][nc] || map[nr][nc]==num){ // 범위 벗어나거나, 똑같은 섬일 때는 패쓰
                    continue;
                }

                if(map[nr][nc] == 0){ // 바다면 다리를 놓을 수 있음
                    queue.offer(new Pos(nr, nc, now.cnt+1)); // 다리를 하나 놓았으므로 count를 1 증가시킴
                    v[nr][nc] = true;
                }
                else if(map[nr][nc] > 1){ // 똑같은 섬일 때는 위에서 처리해줬으므로, 다른 섬을 만났을 때를 뜻함
                    ans = Math.min(ans, now.cnt);
                    break; // 최소 거리를 찾았으므로 끝냄
                }
            }
        }
    }

    private static void makeLankMarking(){
        int num =1;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if( map[i][j] == 1){
                    map[i][j] = ++num; // 탐색을 시작하는 처음 위치부터 마킹
                    dfs(i, j, num);
                }
            }
        }
    }

    private static void dfs(int r, int c, int num){
        for(int i=0; i<4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr<0 || nr>=n || nc<0 || nc>=n || map[nr][nc]!=1){ // 범위가 벗어나거나 해변 or 다른 섬일 때
                continue;
            }
            map[nr][nc] = num; // 섬 번호를 마킹해준다
            dfs(nr, nc, num); // 4방 탐색
        }
    }

    private static int stoi(String s){
        return Integer.parseInt(s);
    }
}

package BOJ;

import java.io.*;
import java.util.*;

public class BOJ15686_bfs {

    static int n, m, allHomeCnt, ans;
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Pos> chicken;

    static class Pos {
        int x,y, cnt;
        Pos(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = stoi(st.nextToken());
        m = stoi(st.nextToken());
        allHomeCnt = 0;
        map = new int[n+1][n+1];
        chicken = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = stoi(st.nextToken());
                if(map[i][j] == 1) ++allHomeCnt; // 전체 집의 개수 저장
                else if (map[i][j] == 2) chicken.add(new Pos(i, j, 0)); // 치킨집의 위치 저장
            }
        }

        visited = new boolean[n+1][n+1]; // 방문배열
        ans = Integer.MAX_VALUE;
        combination(0, 0, new Pos[m]); // 조합으로 치킨집을 m개 뽑은 후-> bfs
        System.out.print(ans);
    }

    private static void combination(int start, int idx, Pos[] selected){
        if(idx == m){
            for(int i=1; i<=n; i++) { // 초기화
                Arrays.fill(visited[i], false);
            }
            bfs(selected); // 최적의 경로 탐색
            return;
        }

        for(int i=start; i<chicken.size(); i++){ // 조합
            selected[idx] = chicken.get(i);
            combination(i+1, idx+1, selected);
        }
    }

    private static void bfs(Pos[] selected){
        Queue<Pos> queue = new LinkedList<>();
        for(int i=0; i<m; i++){ // 치킨집 위치를 queue에 넣는다
            queue.add(selected[i]);
            visited[selected[i].x][selected[i].y] = true; // 방문했음을 체크
        }

        int sum = 0, homeCnt = 0;
        int[] dx = {-1,1,0,0}; // 4방탐색
        int[] dy = {0,0,-1,1};

        while(!queue.isEmpty()){
            Pos now = queue.poll();
            if(map[now.x][now.y] == 1){ // 집에 도달하면
                sum += now.cnt; // 집에 오기까지 걸린 거리 업데이트
                visited[now.x][now.y] = true; // 집도 방문했음을 체크
                ++homeCnt;
                if(homeCnt == allHomeCnt){ // 탐색 끝
                    break;
                }
            }

            for(int i=0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                int nc = now.cnt + 1;
                if(nx<1 || nx>n || ny<1 || ny>n || visited[nx][ny]){ // 범위를 벗어나거나 방문했던 곳은 넘긴다
                    continue;
                }

                queue.offer(new Pos(nx, ny, nc)); // 다음 위치를 방문하고
                visited[nx][ny] = true; // 방문했다고 체크
            }
        }

        ans = Math.min(ans, sum); // 한 경우의 수가 끝나면 답을 업데이트한다
    }

    private static int stoi(String s){
        return Integer.parseInt(s);
    }
}

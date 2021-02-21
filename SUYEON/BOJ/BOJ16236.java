package BOJ;

import java.io.*;
import java.util.*;

public class BOJ16236 {

    static int n, fishCnt, time;
    static int[][] map;
    static boolean[][] v;
    static ArrayList<Pos> fishList;

    static class Pos implements Comparable<Pos>{
        int x, y, size, dist;

        Pos(int x, int y, int size, int dist){
            this.x = x;
            this.y = y;
            this.size = size;
            this.dist = dist;
        }

        @Override
        public int compareTo(Pos o){
            if(this.dist == o.dist){
                if(this.x == o.x){
                    return this.y-o.y;
                }
                return this.x-o.x;
            }
            return this.dist-o.dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        Pos baby = null;
        map = new int[n][n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9) { // 가장 처음에 아기 상어의 크기는 2
                    baby = new Pos(i, j, 2, 0);
                    map[i][j] = 0;
                }
            }
        }

        time = 0;
        fishCnt = 0;
        if(baby != null) {
            solve(baby);
        }
        System.out.print(time);
    }

    static void solve(Pos start){
        fishList = new ArrayList<>(); // 초기화부분(한 턴을 시작하므로 초기화해준다)
        v = new boolean[n][n];

        bfs(start); // start 위치를 기준으로 먹을 수 있는 물고기의 정보를 다 fishList에 저장

        if(fishList.size() != 0){ // 먹을 수 있는 물고기가 있을 때만 체크하면 됨(없으면 더이상 먹을 물고기가 없는 것이므로 엄마 상어에게 요청)
            Collections.sort(fishList); // 우선순위 정렬

            Pos eatFish = fishList.get(0);
            ++fishCnt; // 먹은 물고기 개수 증가
            time += eatFish.dist; // 먹은 물고기로 가기 위한 경로까지 업데이트
            map[eatFish.x][eatFish.y] = 0; // 먹었으니까 0으로 바꿈

            if(fishCnt == eatFish.size){ // 아기 상어는 자신의 크기와 같은 수의 물고기를 먹을 때 마다 크기가 1 증가한다.
                fishCnt=0;
                eatFish.size += 1;
            }
            solve(new Pos(eatFish.x, eatFish.y, eatFish.size, 0)); // 해당 위치부터 다시 bfs 시작
        }
    }

    static int[] dx = {-1,0,0,1}; // 상좌우하
    static int[] dy = {0,-1,1,0};
    private static void bfs(Pos start){
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(start);
        v[start.x][start.y] = true;

        while(!queue.isEmpty()){
            Pos now = queue.poll();

            for(int i=0; i<4; i++){ // 4방탐색
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx<0 || nx>=n || ny<0 || ny>=n || v[nx][ny] || map[nx][ny]>now.size){
                    continue;
                }

                int nSize = now.size;
                int nDist = now.dist+1;
                if(map[nx][ny]!=0 && map[nx][ny] < nSize){ // 냠냠(자신의 크기보다 작은 물고기만 먹을 수 있다.)
                    fishList.add(new Pos(nx, ny, nSize, nDist));
                }

                queue.offer(new Pos(nx, ny, nSize, nDist)); // just 이동
                v[nx][ny] = true;
            }
        }
    }

}

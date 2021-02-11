package BOJ;

import java.io.*;
import java.util.*;

/**
 * <해당 유형은 말만 바꿔서 많이 나오는 편!!>
 * 1. Class 선언 시 내가 필요한 변수들을 만들어서 함께 가지고 다니기
 * 2. 방문 배열을 boolean이 아닌 int로 만들고 무한대로 초기화 시켜두기
 * 3. BFS 안에서 상하좌우로 이동하면 , 결국 똑같은 위치 여러번 탐색하게 됨 -->
 * 벽을 부수기 전에 방문한 곳은 벽을 방문한 다음에도 방문할 이유가 없다. 이 중복을 막기 위해, 방문 배열의 최소 값을 사용하는 걸 잊지말자!
 * https://kim6394.tistory.com/201
 * https://pangtrue.tistory.com/259
 */

public class BOJ2206_intArr {

    static int n, m, ans;
    static char[][] map;
    static int[][] visited;

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
        visited = new int[n][m]; // boolean 대신 int를 써서 벽을 몇 번 부순 상태에서 방문 했는지 저장
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = str.charAt(j);
                visited[i][j] = Integer.MAX_VALUE; // 벽을 부순 횟수를 저장하는 visited 배열을 큰 값으로 초기화
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
        visited[0][0] = 0; // 처음 공사 횟수

        while(!queue.isEmpty()){
            Point nowPos = queue.poll();

            if(nowPos.x == n-1 && nowPos.y == m-1){ // 도착!
                ans = nowPos.cnt;
                return;
            }

            for(int i=0; i<4; i++){
                int nr = nowPos.x + dr[i];
                int nc = nowPos.y + dc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m){
                    if(visited[nr][nc] <= nowPos.drill){ // 좌표를 다시 방문했을 때, 더 적은 횟수로 벽을 부수고 온 적이 있다면 pass
                        continue; // 탐색할 필요 없음
                    }
                    if(map[nr][nc] == '0'){
                        visited[nr][nc] = nowPos.drill;
                        queue.offer(new Point(nr, nc, nowPos.cnt+1, nowPos.drill));
                    }
                    else{
                        if(nowPos.drill == 0){ // 한 번도 벽을 뚫은 적이 없을 때
                            visited[nr][nc] = nowPos.drill + 1;
                            queue.offer(new Point(nr, nc, nowPos.cnt+1, nowPos.drill+1));
                        }
                    }
                }
            }
        }
    }
}

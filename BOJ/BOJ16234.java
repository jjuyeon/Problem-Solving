package BOJ;

import java.io.*;
import java.util.*;

public class BOJ16234 {

    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi(st.nextToken());
        int l = stoi(st.nextToken());
        int r = stoi(st.nextToken());

        map = new int[n][n]; // 각 나라 인구수 저장
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = stoi(st.nextToken());
            }
        }

        int answer = 0;

        while(true){
            boolean flag = false; // 인구이동 발생여부
            visited = new boolean[n][n]; // 방문 배열 초기화 = 연합을 해체하고, 모든 국경선을 닫는다.
            for(int i=0; i<n; i++){ // 한 턴에 모든 위치를 탐색
                for(int j=0; j<n; j++){
                    if (!visited[i][j]){ // 방문하지 않은 곳만
                        boolean check = bfs(i ,j, n, l, r); // 방문해서 인구이동이 일어나는지 체크
                        if(check) flag = true;
                    }
                }
            }
            if(!flag) break; // 인구이동이 발생하지 않으면 이후에도 인구이동 발생할 수 없음
            else ++answer; // 한턴이 끝났으므로 카운트해준다
        }

        System.out.print(answer);
    }

    private static boolean bfs(int x, int y, int n, int l, int r){
        Queue<int[]> queue = new LinkedList<>(); // bfs
        ArrayList<int[]> nowVisitedList = new ArrayList<>(); // 현재 턴에서 각 나라 인구수를 업데이트하기 위함

        queue.offer(new int[]{x, y}); // 현재 턴에서 맨 처음 방문하는 위치
        visited[x][y] = true;
        nowVisitedList.add(new int[]{x, y});

        int moveSum = 0, moveCnt = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            x = now[0];
            y = now[1];
            moveSum += map[x][y];
            ++moveCnt;

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0 || nx>=n || ny<0 || ny>=n || visited[nx][ny]) continue;
                int val = Math.abs(map[x][y]-map[nx][ny]); // 차이가
                if(val>=l && val<=r){ // l이상 r이하일 때만 국경선을 연다
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    nowVisitedList.add(new int[]{nx, ny});
                }
            }
        }

        if(moveCnt==1) return false; // 연합을 못하는 경우(자기 자신만 방문한 경우)

        // 연합을 하는 경우, 인구이동 업데이트
        int avg = moveSum/moveCnt; // 연합을 이루고 있는 각 칸의 인구수는 (연합의 인구수) / (연합을 이루고 있는 칸의 개수)가 된다.
        for(int[] arr : nowVisitedList){
            map[arr[0]][arr[1]] = avg;
        }

        return true;
    }

    private static int stoi(String str){
        return Integer.parseInt(str);
    }
}

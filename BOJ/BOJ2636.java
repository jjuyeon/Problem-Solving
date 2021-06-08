package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2636 {

    final static int CHEESE = 1;
    final static int BLANK = 2;
    final static int BOUNDARY = 3;

    static int n, m;
    static int[][] map;
    static int[] dr = {-1, 1, 0 ,0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0, prevCheese = 0;
        while(true){
            int nowCheese = getCheeseCnt(); // 현재 치즈 갯수 구하기
            if(nowCheese == 0){
                break;
            }

            makeSet(); // 치즈 외 공간(BLANK) 업데이트
            findMeltBoundary(); // 치즈의 경계선 파악하기
            melt(); // 파악한 경계선을 녹이기

            ++time; // 1초마다 위의 3개 일이 이루어짐
            prevCheese = nowCheese; // 이전 치즈 개수 저장
        }

        System.out.println(time);
        System.out.println(prevCheese);
    }

    private static int getCheeseCnt(){ // 치즈 갯수 구하기
        int cnt = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == CHEESE){
                    ++cnt;
                }
            }
        }
        return cnt;
    }

    private static void makeSet(){ // 치즈 외의 공간(BLANK) 파악하기
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>(); // 치즈가 아닌 공간을 담아 bfs 돌린다
        visited[0][0] = true;
        queue.offer(new int[]{0, 0});

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int r = now[0];
            int c = now[1];
            map[r][c] = BLANK;

            for(int i=0; i<4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr>=0 && nr<n && nc>=0 && nc<m && !visited[nr][nc] && map[nr][nc]!=CHEESE){
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }

    private static void findMeltBoundary(){ // 치즈의 경계선 파악하기
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == CHEESE){ // 치즈 경계선이 될 수 있는 가능성 있음
                    for(int k=0; k<4; k++){
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        if(nr>=0 && nr<n && nc>=0 && nc<m && map[nr][nc]==BLANK){ // 상하좌우로 외부 공간하고 맞닿아있으면
                            map[i][j] = BOUNDARY; // 그 곳이 경계선이다
                            break;
                        }
                    }
                }
            }
        }
    }

    private static void melt(){ // 파악한 치즈 경계선 녹여주기
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if (map[i][j] == BOUNDARY) { // 경계선을 녹인다
                    map[i][j] = BLANK; // 녹이면 빈칸됨
                }
            }
        }
    }
}

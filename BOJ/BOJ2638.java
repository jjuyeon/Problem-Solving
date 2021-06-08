package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2638 {

    final static int CHEESE = 1;
    final static int BLANK = 2;
    final static int BOUNDARY = 3;

    static int R, C;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        map = new int[R][C];
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                map[i][j] = sc.nextInt();
            }
        }

        simul();
    }

    private static void simul(){
        // 1. bfs로 치즈 외 공간 파악
        // 2. 4방탐색하면서 경계선 파악
        // 3. 경계선 2변 이상이 외부공기와 접촉하면 지우기
        // 4. 치즈가 다 없어지는데 걸리는 시간 체크해서 출력
        int time = 0;
        while(!checkFinish()){
            makeSet();
            makeBoundary();
            melt();
            ++time;
        }

        System.out.print(time);
    }

    private static void makeSet(){ // 치즈 공간(치즈 안에 빈 공간은 0)과 외부 공간(2) 구분하기
        boolean[][] visited = new boolean[R][C];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0}); // 맨 가장자리에는 치즈가 놓이지 않음
        visited[0][0] = true;

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int r = now[0];
            int c = now[1];
            map[r][c] = BLANK;

            for(int i=0; i<4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr>=0 && nr<R && nc>=0 && nc<C && !visited[nr][nc] && map[nr][nc]!=CHEESE){
                    queue.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }
    }

    private static void makeBoundary(){ // 치즈 중에서 녹아지는 경게선 체크
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j] == CHEESE){
                    int cnt = 0;
                    for(int d=0; d<4; d++){
                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        // 치즈의 4변 중 2변 이상이 외부공기(BLANK)와 접촉해야 경계선이 되어 지워질 수 있다
                        if(nr>=0 && nr<R && nc>=0 && nc<C && map[nr][nc]==BLANK){
                            ++cnt;
                            if(cnt>=2) break;
                        }
                    }
                    if(cnt>=2) map[i][j] = BOUNDARY;
                }
            }
        }
    }

    private static void melt(){ // 치즈 지우기
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j] == BOUNDARY) map[i][j] = BLANK;
            }
        }
    }

    private static boolean checkFinish(){
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j] == CHEESE) return false;
            }
        }
        return true;
    }
}

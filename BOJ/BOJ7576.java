package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ7576 {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] box;
    static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();

        // 1: 익은 토마토, 0: 익지 않은 토마토, -1: 토마토가 들어있지 않음
        box = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                box[i][j] = sc.nextInt();
            }
        }

        System.out.print(getTomatoTime());
    }

    private static int getTomatoTime() {
        int day = 0;

        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(box[i][j] == 1){
                    queue.offer(new int[]{i, j, 0});
                }
            }
        }
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int r = now[0];
            int c = now[1];
            day = now[2];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M || box[nr][nc] != 0) continue;
                queue.offer(new int[]{nr, nc, now[2]+1});
                box[nr][nc] = 1;
            }
        }
        if(!isComplete()) day = -1;

        return day;
    }

    private static boolean isComplete(){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(box[i][j] == 0) return false;
            }
        }
        return true;
    }
}

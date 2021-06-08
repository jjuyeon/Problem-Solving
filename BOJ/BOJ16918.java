package BOJ;

import java.io.*;
import java.util.*;

public class BOJ16918 {

    static int R, C;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        // 가장 처음에 봄버맨은 일부 칸에 폭탄을 설치해 놓는다. 모든 폭탄이 설치된 시간은 같다.
        // 다음 1초 동안 봄버맨은 아무것도 하지 않는다. (즉, 0~1초 구현)
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                if (str.charAt(j) == 'O') map[i][j] = 1; // 현재 폭탄이 존재하면 1 저장
                else map[i][j] = 0; // 폭탄이 존재하지 않으면 0 저장
            }
        }

        bombaman(N); // 봄버맨 스타트!
        printMap(); // 최종 결과 출력
    }

    private static void bombaman(int time) {
        for (int t = 2; t <= time; t++) {
            // 다음 1초 동안 폭탄이 설치되어 있지 않은 모든 칸에 폭탄을 설치한다. 즉, 모든 칸은 폭탄을 가지고 있게 된다.
            if (t % 2 == 0) {
                addBomb();
            }
            // 1초가 지난 후에 t-2초 전에 설치된 폭탄이 모두 폭발한다.
            else {
                booom();
            }
        }
    }

    private static void addBomb() { // bomb 시간 초 더해주기
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                ++map[i][j];
            }
        }
    }

    private static void booom() {
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j]>=2){ // bomb time
                    queue.offer(new int[]{i,j});
                    map[i][j] = 0;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int d = 0; d < 4; d++) { // 인접한 4방 위치도 bomb
                int nr = now[0] + dr[d];
                int nc = now[1] + dc[d];
                if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != 0) {
                    map[nr][nc] = 0;
                }
            }
        }
    }

    private static void printMap() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 0) {
                    System.out.print('.');
                } else {
                    System.out.print('O');
                }
            }
            System.out.println();
        }
    }

}

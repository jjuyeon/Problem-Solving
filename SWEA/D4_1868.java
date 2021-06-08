package SWEA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class D4_1868 {

    static int[] dr = {1, -1, 0, 0, -1, 1, 1, -1};
    static int[] dc = {0, 0, -1, 1, -1, -1, 1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(sc.next());
            char[][] map = new char[N][N];
            for (int i = 0; i < N; i++) {
                String str = sc.next();
                for (int j = 0; j < N; j++) {
                    map[i][j] = str.charAt(j);
                }
            }

            int[][] charToInt = new int[N][N];
            search(charToInt, map, N);
            System.out.println("#" + test_case + " " + bfs(charToInt, N));
        }
    }

    private static int bfs(int[][] charToInt, int N) {
        int ans = 0;
        Queue<int[]> queue = new LinkedList<>();
        while(true) {
            boolean isEnd = true;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (charToInt[i][j] == 0) {
                        isEnd = false;
                        charToInt[i][j] = -1;
                        queue.offer(new int[]{i, j});
                        break;
                    }
                }
                if(!isEnd) break;
            }
            if(isEnd) break;

            int r, c, nr, nc;
            int[] now;
            while (!queue.isEmpty()) {
                now = queue.poll();
                r = now[0];
                c = now[1];

                for (int i = 0; i < 8; i++) {
                    nr = r + dr[i];
                    nc = c + dc[i];
                    if (nr >= 0 && nr < N && nc >= 0 && nc < N && charToInt[nr][nc] != -1) {
                        if (charToInt[nr][nc] == 0) {
                            queue.offer(new int[]{nr, nc});
                        }
                        charToInt[nr][nc] = -1;
                    }
                }
            }
            ++ans;
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(charToInt[i][j] > 0) ++ans;
            }
        }
        return ans;
    }

    private static void search(int[][] charToInt, char[][] map, int N) {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c] == '*') {
                    charToInt[r][c] = -1;
                } else if (map[r][c] == '.') {
                    int nr, nc, cnt = 0;
                    for (int i = 0; i < 8; i++) {
                        nr = r + dr[i];
                        nc = c + dc[i];
                        if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == '*') {
                            ++cnt;
                        }
                    }
                    charToInt[r][c] = cnt;
                }
            }
        }
    }
}

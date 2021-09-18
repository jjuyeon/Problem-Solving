package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ4179 {

    static int R, C;
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = Integer.parseInt(sc.next());
        C = Integer.parseInt(sc.next());

        Queue<int[]> fq = new LinkedList<>();
        Queue<int[]> jq = new LinkedList<>();
        arr = new int[R][C];
        for (int i = 0; i < R; i++) {
            String line = sc.next();
            for (int j = 0; j < C; j++) {
                char ch = line.charAt(j);
                if(ch == '#') {
                    arr[i][j] = -2;
                }
                else if(ch == 'F') {
                    arr[i][j] = -1;
                    fq.offer(new int[]{i, j});
                }
                else if(ch == 'J') {
                    arr[i][j] = 1;
                    jq.offer(new int[]{i, j});
                }
                else if(ch == '.') {
                    arr[i][j] = 0;
                }
            }
        }

        bfs(fq, jq);
    }

    private static void bfs(Queue<int[]> fq, Queue<int[]> jq) {
        int answer = 1;

        while(true) {
            int fs = fq.size();
            while(fs-- > 0) {
                int[] now = fq.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = now[0] + dx[i];
                    int ny = now[1] + dy[i];
                    if(nx >= 0 && nx < R && ny >=0 && ny < C && arr[nx][ny] >= 0) {
                        fq.offer(new int[]{nx, ny});
                        arr[nx][ny] = -1;
                    }
                }
            }

            int js = jq.size();
            while(js-- > 0) {
                int[] now = jq.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = now[0] + dx[i];
                    int ny = now[1] + dy[i];

                    if(nx < 0 || nx >= R || ny < 0 || ny >= C) {
                        System.out.println(answer);
                        return;
                    }

                    if(arr[nx][ny] == 0) {
                        jq.offer(new int[]{nx, ny});
                        arr[nx][ny] = 1;
                    }
                }
            }

            if(jq.isEmpty()) {
                System.out.println("IMPOSSIBLE");
                return;
            }

            answer++;
        }
    }
}

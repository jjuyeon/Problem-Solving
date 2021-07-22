package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2667_v2 {

    static int n;
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        visited = new boolean[n][n];
        ArrayList<Integer> ansList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] != '0' && !visited[i][j]) {
                    ansList.add(bfs(i, j));
                }
            }
        }

        Collections.sort(ansList);

        System.out.println(ansList.size());
        for (int size : ansList) {
            System.out.println(size);
        }
    }

    static int bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;

        int cnt = 1;
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = now[0] + dr[k];
                int ny = now[1] + dc[k];
                if(nx>=0 && nx<n && ny>=0 && ny<n && !visited[nx][ny] && map[nx][ny] == '1') {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    ++cnt;
                }
            }
        }
        return cnt;
    }
}

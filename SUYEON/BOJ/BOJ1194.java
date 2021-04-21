package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 메모리 제한이 128MB이므로 3차원 배열 선언하면 메모리 초과..
public class BOJ1194 {

    static class Node {
        int r, c, key, time;

        Node(int r, int c, int key, int time) {
            this.r = r;
            this.c = c;
            this.key = key;
            this.time = time;
        }
    }

    static int N, M;
    static char[][] maze;
    static boolean[][][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.next());
        M = Integer.parseInt(sc.next());
        visited = new boolean[N][M][1 << 6];
        maze = new char[N][M];
        int startRow = 0, startCol = 0;
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < M; j++) {
                maze[i][j] = str.charAt(j);
                if (maze[i][j] == '0') {
                    startRow = i;
                    startCol = j;
                }
            }
        }
        bfs(startRow, startCol);
    }

    private static void bfs(int startRow, int startCol) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(startRow, startCol, 0, 0));
        visited[startRow][startCol][0] = true;

        int r, c, nr, nc, nKey, ans = -1;
        Node now;
        while (!queue.isEmpty()) {
            now = queue.poll();
            r = now.r;
            c = now.c;

            if (maze[r][c] == '1') {
                ans = now.time;
                break;
            }

            for (int i = 0; i < 4; i++) {
                nr = r + dr[i];
                nc = c + dc[i];
                nKey = now.key;
                if (nr < 0 || nr >= N || nc < 0 || nc >= M || maze[nr][nc] == '#' || visited[nr][nc][nKey]) continue;
                char next = maze[nr][nc];
                if ('a' <= next && next <= 'f') { // 열쇠
                    nKey = getNewKey(nKey, next - 'a');
                } else if ('A' <= next && next <= 'F') { // 문
                    if (noKey(nKey, next - 'A')) { // 키 없으면 이동 불가
                        continue;
                    }
                }
                visited[nr][nc][nKey] = true;
                queue.offer(new Node(nr, nc, nKey, now.time + 1));
            }
        }

        System.out.print(ans);
    }

    private static boolean noKey(int originalKey, int newKey) {
        return (originalKey & (1 << newKey)) == 0;
    }

    private static int getNewKey(int originalKey, int newKey) {
        return originalKey | (1 << newKey);
    }
}

package BOJ;

import java.util.*;

public class BOJ21609 {

    static class Block {
        int x, y, rCnt, size;
        String points;

        public Block(int x, int y, int rCnt, int size, String points) {
            this.x = x;
            this.y = y;
            this.rCnt = rCnt;
            this.size = size;
            this.points = points;
        }

        public Block(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    static final int BLANK = 6;
    static int N, M, answer;
    static int[][] arr;
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};
    static boolean[][] visited;
    static PriorityQueue<Block> pq;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        if (N == 1) {
            System.out.print("0");
            return;
        }

        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        pq = new PriorityQueue<>(new Comparator<Block>() {
            @Override
            public int compare(Block o1, Block o2) {
                if (o1.size == o2.size) {
                    if (o1.rCnt == o2.rCnt) {
                        if (o1.x == o2.x) return o2.y - o1.y;
                        return o2.x - o1.x;
                    }
                    return o2.rCnt - o1.rCnt;
                }
                return o2.size - o1.size;
            }
        });

        find();

        while (!pq.isEmpty()) {
            // 1. 크기가 가장 큰 블록 그룹을 찾는다.
            // 크기 > 무지개 블록 수 > 큰 행 > 큰 열
            Block cur = pq.poll();
            StringTokenizer st = new StringTokenizer(cur.points);
            while (st.hasMoreTokens()) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x][y] = BLANK; // 2. 블록 그룹의 모든 블록 제거
            }

            // 3. 제거된 블록만큼 점수를 업데이트한다.
            answer += (cur.size * cur.size);

            gravity(); // 4. 격자에 중력이 작용한다.
            rotation(); // 5. 90도 반시계 회전한다.
            gravity(); // 6. 격자에 중력이 작용한다.
            pq.clear();

            find();
        }
        System.out.println(answer);
    }

    static void find() {
        visited = new boolean[N][N];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (!visited[i][j]) {
                    if (arr[i][j] > 0 && arr[i][j] <= M) {
                        visited[i][j] = true;
                        makeBlock(i, j);
                    }
                }
            }
        }
    }

    static void makeBlock(int x, int y) {
        int size = 1;
        int r_cnt = 0;
        int color = arr[x][y];
        StringBuilder sb = new StringBuilder(x + " " + y);
        StringBuilder rainbow = new StringBuilder();
        Queue<Block> q = new LinkedList<>();
        q.add(new Block(x, y, 0, 0, ""));

        while (!q.isEmpty()) {
            Block cur = q.poll();
            for (int dir = 0; dir < 4; ++dir) {
                int mx = cur.x + dr[dir];
                int my = cur.y + dc[dir];

                if (mx < 0 || mx >= N || my < 0 || my >= N || visited[mx][my] || arr[mx][my] == BLANK) continue;
                if (arr[mx][my] == 0) {
                    q.add(new Block(mx, my));
                    rainbow.append(mx + " " + my + " ");
                    r_cnt++;
                } else if (arr[mx][my] == color) q.add(new Block(mx, my));
                else continue;
                visited[mx][my] = true;
                size++;
                sb.append(" " + mx + " " + my);
            }
            if (q.isEmpty()) {
                if (size >= 2) {
                    pq.add(new Block(x, y, r_cnt, size, sb.toString()));
                    if (r_cnt > 0) {
                        StringTokenizer st = new StringTokenizer(rainbow.toString());
                        while (st.hasMoreTokens()) {
                            int fst = Integer.parseInt(st.nextToken());
                            int sec = Integer.parseInt(st.nextToken());
                            visited[fst][sec] = false;
                        }
                    }
                }
            }
        }

    }

    static void rotation() {
        int[][] temp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                temp[i][j] = arr[j][N - i - 1];
            }
        }
        arr = temp;
    }

    static void gravity() {
        for (int j = 0; j < N; j++) {
            for (int i = N - 2; i >= 0; i--) {
                if (arr[i][j] >= 0 && arr[i][j] <= M) {
                    int idx = i + 1;
                    while (idx < N && arr[idx][j] == BLANK) {
                        idx++;
                    }
                    if (arr[idx - 1][j] == BLANK) {
                        arr[idx - 1][j] = arr[i][j];
                        arr[i][j] = BLANK;
                    }
                }
            }
        }
    }
}

package BOJ;

import java.util.*;

public class BOJ16236_ver2 {

    static int N, eatFishCnt = 0, sharkMoveTime = 0;
    static int[][] arr;

    static class Fish implements Comparable<Fish>{
        int r, c;
        int time, sharkSize;

        Fish(int r, int c, int time, int size) {
            this.r = r;
            this.c = c;
            this.time = time;
            this.sharkSize = size;
        }

        @Override
        public int compareTo(Fish o) {
            if(this.time == o.time) {
                if(this.r == o.r) {
                    return this.c - o.c;
                }
                return this.r - o.r;
            }
            return this.time - o.time;
        }
    }

    private static List<Fish> fishList;
    private static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Fish shark = null;
        N = sc.nextInt();
        arr = new int[N][N];

        int val;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                val = sc.nextInt();
                if (val == 9) {
                    shark = new Fish(i, j, 0, 2);
                } else {
                    arr[i][j] = val;
                }
            }
        }

        move(shark);
        System.out.println(sharkMoveTime);
    }

    private static void move(Fish shark) {
        if(checkFinishTime()) return;

        fishList = new ArrayList<>();
        visited = new boolean[N][N];

        bfs(shark);

        if(!fishList.isEmpty()) {
            Collections.sort(fishList);
            Fish priorityFish = fishList.get(0);
            ++eatFishCnt;
            sharkMoveTime += priorityFish.time;
            if(eatFishCnt == priorityFish.sharkSize) {
                eatFishCnt = 0;
                priorityFish.sharkSize++;
            }
            arr[priorityFish.r][priorityFish.c] = 0;
            move(new Fish(priorityFish.r, priorityFish.c, 0, priorityFish.sharkSize));
        }
    }

    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};

    private static void bfs(Fish shark) {
        Queue<Fish> queue = new LinkedList<>();
        queue.offer(shark);
        visited[shark.r][shark.c] = true;

        int nr, nc, nTime, sharkSize;
        while(!queue.isEmpty()) {
            Fish now = queue.poll();
            for (int i = 0; i < 4; i++) {
                nr = now.r + dr[i];
                nc = now.c + dc[i];
                sharkSize = now.sharkSize;
                if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc] && arr[nr][nc] <= sharkSize) {
                    nTime = now.time + 1;
                    Fish next = new Fish(nr, nc, nTime, sharkSize);
                    if(arr[nr][nc] > 0 && arr[nr][nc] < sharkSize) {
                        fishList.add(next);
                    }
                    queue.offer(next);
                    visited[nr][nc] = true;
                }
            }
        }
    }

    private static boolean checkFinishTime() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] > 0 && arr[i][j] < 9) {
                    return false;
                }
            }
        }
        return true;
    }
}

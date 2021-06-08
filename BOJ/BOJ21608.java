package BOJ;

import java.util.Scanner;

public class BOJ21608 {
    static int N;
    static int[][] like, map;
    static int[] dr = new int[]{-1, 1, 0, 0};
    static int[] dc = new int[]{0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        like = new int[N*N + 1][4];
        map = new int[N + 1][N + 1];

        for (int l = 0; l < N * N; l++) {
            // 입력 부분
            int student = sc.nextInt();
            for (int j = 0; j < 4; j++)
                like[student][j] = sc.nextInt();

            // 3. 2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.
            // 1,1부터 완탐을 하므로, 행, 열이 작은 칸부터 업데이트된다 -> 3번 조건은 자동 만족됨
            int row = 0, col = 0, blankCnt, likeCnt, blankMax = -1, likeMax = -1;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (map[i][j] != 0) continue; // 학생은 0인 곳에만 위치할 수 있다

                    blankCnt = 0; likeCnt = 0;
                    for (int d = 0; d < 4; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        if (nr >= 1 && nr <= N && nc >= 1 && nc <= N) {
                            if(map[nr][nc] == 0) blankCnt++; // 인접한 칸 중 빈칸 체크
                            else if (isLikeFriend(map[nr][nc], student)) likeCnt++; // 인접한 칸 중 좋아하는 학생 체크
                        }
                    }
                    // 1. 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
                    if (likeMax < likeCnt) {
                        row = i;
                        col = j;
                        likeMax = likeCnt;
                        blankMax = blankCnt; // 이후에 좋아하는 학생 수가 일치할 때, 현재 위치의 빈칸 수와 비교해야하므로, 빈칸도 업데이트한다
                    } else if (likeMax == likeCnt) {
                        // 2. 1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
                        if (blankMax < blankCnt) {
                            row = i;
                            col = j;
                            blankMax = blankCnt;
                        }
                    }
                }
            }
            map[row][col] = student;
        }

        int ans = 0;
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(map[i][j] != 0){
                    int cnt = 0;
                    for(int d=0; d<4; d++){
                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        if(nr>=1 && nr<=N && nc>=1 && nc<=N && isLikeFriend(map[nr][nc], map[i][j]))
                            cnt++;
                    }
                    if(cnt>0){
                        ans += Math.pow(10, cnt-1);
                    }
                }
            }
        }
        System.out.println(ans);
    }

    private static boolean isLikeFriend(int friend, int student) {
        for (int j = 0; j < 4; j++) {
            if (like[student][j] == friend) {
                return true;
            }
        }
        return false;
    }
}

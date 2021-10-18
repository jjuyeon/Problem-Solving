package BOJ;

import java.util.*;

public class BOJ21608_ver2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][N];
        Set<Integer>[] likes = new HashSet[N * N + 1];
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int d = 0; d < N * N; d++) {
            int num = sc.nextInt();
            likes[num] = new HashSet<>();
            for (int i = 0; i < 4; i++) {
                likes[num].add(sc.nextInt());
            }

            // [check] !!!! 좋아하는 학생도 없고, 비어있는 칸도 없을 때를 대비해서 -1로 세팅해야한다 !!!!
            int r = 0, c = 0, likeCnt = -1, blankCnt = -1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] == 0) {
                        // 좋아하는 학생 인접 칸, 비어있는 칸 구하기
                        int nowLikeCnt = 0, nowBlankCnt = 0;
                        for (int k = 0; k < 4; k++) {
                            int nr = i + dr[k];
                            int nc = j + dc[k];
                            if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                                if (arr[nr][nc] == 0) {
                                    ++nowBlankCnt;
                                } else if (likes[num].contains(arr[nr][nc])) {
                                    ++nowLikeCnt;
                                }
                            }
                        }

                        if (nowLikeCnt > likeCnt) {
                            r = i;
                            c = j;
                            likeCnt = nowLikeCnt;
                            blankCnt = nowBlankCnt;
                        }
                        // 행, 열 작은 순으로 빈칸이 가장 많은 칸부터 처리
                        else if (nowLikeCnt == likeCnt && nowBlankCnt > blankCnt) {
                            r = i;
                            c = j;
                            blankCnt = nowBlankCnt;
                        }
                    }
                }
            }
            arr[r][c] = num;
        }

        // 최종 만족도 총합
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int cnt = 0;
                for (int k = 0; k < 4; k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];
                    if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                        if(likes[arr[i][j]].contains(arr[nr][nc])) {
                            ++cnt;
                        }
                    }
                }
                if(cnt > 0) {
                    answer += Math.pow(10, cnt-1);
                }
            }
        }
        System.out.println(answer);
    }
}

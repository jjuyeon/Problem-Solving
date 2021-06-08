package BOJ;

import java.util.Scanner;

public class BOJ21278 {
    public static void main(String[] args) {
        final int MAX_VALUE = 100 * 99 / 2;

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] minDist = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    minDist[i][j] = 0;
                    continue;
                }
                minDist[i][j] = MAX_VALUE;
            }
        }

        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            // 양방향
            minDist[from][to] = 1;
            minDist[to][from] = 1;
        }

        // "모든 건물에서 가장 가까운 치킨집까지 왕복하는 최단 시간의 총합" : floyd 알고리즘
        for (int k = 1; k <= N; k++) { // 경
            for (int i = 1; i <= N; i++) { // 출
                for (int j = 1; j <= N; j++) { // 도
                    if (i != j) { // 출발지와 도착지가 같으면 안해도 됨
                        minDist[i][j] = Math.min(minDist[i][j], minDist[i][k] + minDist[k][j]);
                    }
                }
            }
        }

        // 두 개의 치킨집 위치를 뽑아서 비교
        // "건물 조합이 다양하게 가능하면, 작은 번호가 더 작은 것을, 작은 번호가 같다면 큰 번호가 더 작은 걸 출력한다."
        // 치킨집 위치를 작은 것부터 비교하므로, 위의 조건은 만족된다
        int n1 = 0, n2 = 0, min_oneWay = MAX_VALUE;
        for (int i = 1; i <= N; i++) { // 치킨집1
            for (int j = 1; j <= N; j++) { // 치킨집2
                int sum = 0;
                for (int l = 1; l <= N; l++) { // 선택된 치킨집 위치 2개에 대한 최소비용 탐색
                    if (l != i && l != j) {
                        sum += Math.min(minDist[i][l], minDist[j][l]); // 두 위치 중 더 최소인 비용을 택한다
                    }
                }
                if (min_oneWay > sum) { // 최소비용 업데이트
                    n1 = i;
                    n2 = j;
                    min_oneWay = sum;
                }
            }
        }
        System.out.print(n1 + " " + n2 + " " + min_oneWay*2);
    }
}

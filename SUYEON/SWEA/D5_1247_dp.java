package SWEA;

import java.util.Arrays;
import java.util.Scanner;

/**
 * TSP(Traveling Salesman Problem), 비트 마스킹 방법을 이용
 * 외판원 순회(TSP: Traveling Salesperson Problem) : 도시들이 있고 특정 도시에서 도시로 이동할 때 드는 비용이 주어졌을 때
 * 불특정한 도시에서 출발해서 모든 도시를 돌고 다시 출발 도시로 돌아왔을 때 드는 최소 비용을 구하는 문제
 * https://withhamit.tistory.com/246
 * https://hoho325.tistory.com/115
 */

public class D5_1247_dp {

    static int n;
    static int[][] dp, distance;

    static class Point{
        int x, y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            n = sc.nextInt();

            Point[] customers = new Point[n+2]; // index 1~n은 customer의 정보
            customers[0] = new Point(sc.nextInt(), sc.nextInt()); // company
            customers[n+1] = new Point(sc.nextInt(), sc.nextInt()); // home
            for(int i=1; i<=n; i++){ // 고객의 집 좌표 저장
                customers[i] = new Point(sc.nextInt(), sc.nextInt());
            }

            // 두 좌표의 계산된 거리 정보 저장
            distance = new int[n+2][n+2];
            for(int i=0; i<n+2; i++){
                for(int j=0; j<n+2; j++){
                    if(i != j){
                        distance[i][j] = getDistance(customers[i].x, customers[i].y, customers[j].x, customers[j].y);
                    }
                }
            }

            // 1<<(n+1) : 방문여부 체크(오른쪽에서 부터 i번째 수가 1이면 i번째 도시를 방문했음을, 0이면 방문하지 않았음을 의미)
            //                      (예를 들어  5개의 도시가 있고 1,2,3번 도시를 방문했다면 00111로 표현)
            // n+1 : 현재 방문하고 있는 위치
            dp = new int[1<<(n+1)][n+1];
            for(int i=0; i<1<<(n+1); i++){ // 최소 거리를 구할 때 제대로 계산하기 위해 초기화해준다
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }

            int ans = tsp(0, 0); // 방문은 0번째 인덱스(회사)부터 시작
            sb.append("#").append(test_case).append(" ").append(ans).append("\n");
        }
        System.out.print(sb.toString());
    }

    private static int tsp(int visit, int nowPos){
        // 현재 방문하고 있는 위치 저장( | 연산자 사용)
        visit |= (1<<nowPos);

        // 집에 도착하기 전 모든 고객들을 다 방문했다면, 현재 위치~집까지의 위치만 구하면 됨 (-1하는 이유: 회사가 맨 오른쪽이므로)
        if(visit == (1<<(n+1))-1) return distance[nowPos][n+1];
        // 지금까지 계산된 거리 값이 있다면 그 값을 리턴해주고 중복 계산을 피한다
        if(dp[visit][nowPos] != Integer.MAX_VALUE) return dp[visit][nowPos];

        for(int i=1; i<=n; i++){
            // 지금 방문하려는 고객 위치가 아니고 방문한 점이 아니면 업데이트
            if(i!=nowPos && (visit & (1<<i)) == 0){
                int update = tsp(visit, i) + distance[nowPos][i];
                if(dp[visit][nowPos] > update) dp[visit][nowPos] = update;
            }
        }

        return dp[visit][nowPos];
    }

    private static int getDistance(int x, int y, int x2, int y2){
        return Math.abs(x-x2) + Math.abs(y-y2);
    }
}

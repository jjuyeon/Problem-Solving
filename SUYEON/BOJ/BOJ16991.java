package BOJ;

import java.io.*;
import java.util.*;

public class BOJ16991 {

    static final int INF = Integer.MAX_VALUE;
    static int n;
    static Point[] city;
    static double[][] distance, dp;

    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = stoi(br.readLine());

        city = new Point[n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            city[i] = new Point(stoi(st.nextToken()), stoi(st.nextToken()));
        }

        distance = new double[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i!=j){
                    distance[i][j] = Math.sqrt(Math.pow((city[j].x-city[i].x), 2) + Math.pow((city[j].y-city[i].y), 2));
                }
            }
        }

        dp = new double[1<<n][n];
        for(int i=0; i<(1<<n); i++){
            Arrays.fill(dp[i], INF);
        }

        double ans = tsp(0, 0);
        System.out.print(ans);
    }

    private static double tsp(int visit, int nowPos){
        visit |= (1<<nowPos); // 현재 방문하는 위치 업데이트

        // 모든 위치 다 방문
        if(visit == (1<<n)-1){
            return distance[nowPos][0];
        }

        // 이전에 계산된 값이 있다면 중복을 피함
        if(dp[visit][nowPos] != INF){
            return dp[visit][nowPos];
        }

        for(int i=0; i<n; i++){
            if(i!=nowPos && (visit&(1<<i))==0){
                dp[visit][nowPos] = Math.min(dp[visit][nowPos], tsp(visit, i) + distance[nowPos][i]);
            }
        }

        return dp[visit][nowPos];
    }

    private static int stoi(String str){
        return Integer.parseInt(str);
    }
}

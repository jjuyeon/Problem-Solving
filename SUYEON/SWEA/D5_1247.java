package SWEA;

import java.util.Scanner;

/**
 * 재귀 문제 O(n!)
 */

public class D5_1247 {

    static int n, ans;
    static Point[] orders;
    static Point company, home;

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
            company = new Point(sc.nextInt(), sc.nextInt());
            home = new Point(sc.nextInt(), sc.nextInt());

            orders = new Point[n];
            for(int i=0; i<n; i++){
                orders[i] = new Point(sc.nextInt(), sc.nextInt());
            }

            ans = Integer.MAX_VALUE;
            for(int i=0; i<n; i++){
                Point[] selected = new Point[n]; selected[0] = orders[i];
                boolean[] visited = new boolean[n]; visited[i] = true;
                permutation(i, 1, selected, visited);
            }
            sb.append("#").append(test_case).append(" ").append(ans).append("\n");
        }
        System.out.print(sb.toString());
    }

    private static void permutation(int startIdx, int idx, Point[] selected, boolean[] visited){
        if(idx == n){
            int routeCnt = Math.abs(company.x-selected[0].x) + Math.abs(company.y-selected[0].y);
            for(int i=1; i<n; i++){
                routeCnt += Math.abs(selected[i-1].x-selected[i].x) + Math.abs(selected[i-1].y-selected[i].y);
            }
            routeCnt += Math.abs(selected[n-1].x-home.x) + Math.abs(selected[n-1].y-home.y);

            ans = Math.min(ans, routeCnt);
            return;
        }

        for(int i=0; i<n; i++){
            if(i == startIdx){
                continue;
            }
            if(!visited[i]){
                visited[i] = true;
                selected[idx] = orders[i];
                permutation(startIdx, idx+1, selected, visited);
                visited[i] = false;
            }
        }
    }


}

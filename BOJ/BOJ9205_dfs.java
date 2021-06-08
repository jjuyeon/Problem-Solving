package BOJ;

import java.util.*;

public class BOJ9205_dfs {

    static class Pos {
        int x, y;
        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int n;
    static boolean flag;
    static Pos[] map;
    static int[][] dist;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case=1; test_case<=T; test_case++){
            n = sc.nextInt();
            map = new Pos[n+2];
            for(int i=0; i<n+2; i++){
                map[i] = new Pos(sc.nextInt(), sc.nextInt());
            }

            dist = new int[n+2][n+2];
            for(int i=0; i<n+2; i++){
                for(int j=0; j<n+2; j++){
                    if(i!=j){
                        dist[i][j] = Math.abs(map[i].x-map[j].x) + Math.abs(map[i].y-map[j].y);
                    }
                }
            }

            boolean[] v = new boolean[n+2];
            v[0] = true;
            flag = false;
            dfs(0, v);
            if(flag){
                System.out.println("happy");
            }
            else{
                System.out.println("sad");
            }
        }
    }

    private static void dfs(int i, boolean[] v){
        if(i == n+1){
            flag = true;
            return;
        }

        for(int j=0; j<n+2; j++){
            if(!v[j] && dist[i][j] <= 1000){
                v[j] = true;
                dfs(j, v);
            }
        }
    }
}

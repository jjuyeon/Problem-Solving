package BOJ;

import java.util.*;

public class BOJ9205_bfs {

    static class Pos {
        int x, y;
        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int n;
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
                    if(i!=j) {
                        dist[i][j] = Math.abs(map[i].x - map[j].x) + Math.abs(map[i].y - map[j].y);
                    }
                }
            }

            bfs();
        }
    }

    private static void bfs(){
        boolean[] visited = new boolean[n+2];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;

        while(!queue.isEmpty()){
            int nowIdx = queue.poll();
            if(nowIdx == n+1){ // festival 도착
                System.out.println("happy");
                return;
            }
            for(int j=0; j<n+2; j++){
                if(!visited[j] && dist[nowIdx][j] <= 1000){
                    visited[j] = true;
                    queue.offer(j);
                }
            }
        }

        System.out.println("sad");
    }
}

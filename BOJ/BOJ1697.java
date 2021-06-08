package BOJ;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class BOJ1697 {

    static class Time {
        int dist, time;
        Time(int dist, int time){
            this.dist = dist;
            this.time = time;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int answer = bfs(n, k);
        System.out.print(answer);
    }

    private static int bfs(int n, int k){
        Queue<Time> queue = new LinkedList<>();
        boolean[] visited = new boolean[100001];

        queue.offer(new Time(n, 0));
        visited[n] = true;

        int ans = 0;
        while(!queue.isEmpty()){
            Time now = queue.poll();

            if(now.dist == k){
                ans = now.time;
                break;
            }

            if(now.dist*2<=100000 && !visited[now.dist*2]){
                queue.offer(new Time(now.dist*2, now.time+1));
                visited[now.dist*2] = true;
            }
            if(now.dist-1>=0 && !visited[now.dist-1]){
                queue.offer(new Time(now.dist-1, now.time+1));
                visited[now.dist-1] = true;
            }
            if(now.dist+1<=100000 && !visited[now.dist+1]){
                queue.offer(new Time(now.dist+1, now.time+1));
                visited[now.dist+1] = true;
            }
        }
        return ans;
    }

}

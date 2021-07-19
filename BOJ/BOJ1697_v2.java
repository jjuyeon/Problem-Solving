package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1697_v2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        boolean[] visited = new boolean[100001];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{n, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int num = now[0];
            int cnt = now[1];
            if(num == k) {
                System.out.println(cnt);
                return;
            }

            if(num*2 <= 100000 && !visited[num*2]) {
                visited[num*2] = true;
                queue.offer(new int[]{num*2, cnt+1});
            }
            if(num+1 <= 100000 && !visited[num+1]) {
                visited[num+1] = true;
                queue.offer(new int[]{num+1, cnt+1});
            }
            if(num >= 1 && !visited[num-1]) {
                visited[num-1] = true;
                queue.offer(new int[]{num-1, cnt+1});
            }
        }
    }
}

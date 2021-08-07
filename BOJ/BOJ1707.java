package BOJ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1707 {

    static int[] color;
    static ArrayList<Integer>[] edgeList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int v, e;
        for (int test_case = 1; test_case <= k; test_case++) {
            v = sc.nextInt();
            e = sc.nextInt();
            color = new int[v + 1];
            edgeList = new ArrayList[v + 1];
            for (int i = 1; i <= v; i++) {
                edgeList[i] = new ArrayList<>();
            }

            for (int i = 0; i < e; i ++) {
                int v1 = sc.nextInt();
                int v2 = sc.nextInt();
                edgeList[v1].add(v2);
                edgeList[v2].add(v1);
            }
            for (int i = 1; i <= v; i++) {
                bfs(i);
            }

            boolean isFinish = false;
            for (int i = 1; i <= v; i++) {
                int standard = color[i];
                for (int now : edgeList[i]) {
                    if(standard == color[now]) {
                        System.out.println("NO");
                        isFinish = true;
                        break;
                    }
                }
                if(isFinish) break;
            }
            if(!isFinish)  System.out.println("YES");
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        if(color[start] == 0)  color[start] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            int nowColor = color[now];

            for (int next : edgeList[now]) {
                if (color[next] == 0) {
                    if (nowColor == 1) {
                        color[next] = -1;
                    } else if (nowColor == -1) {
                        color[next] = 1;
                    }
                    queue.offer(next);
                }
            }
        }
    }
}

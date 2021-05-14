package BOJ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ15591 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        ArrayList<int[]>[] adjList = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            adjList[i] = new ArrayList<>();
        }
        for(int i=0; i<n-1; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int w = sc.nextInt();
            adjList[a].add(new int[]{b, w});
            adjList[b].add(new int[]{a, w});
        }

        for(int i=0; i<q; i++){
            System.out.println(getUSADO(sc.nextInt(), sc.nextInt(), adjList, n));
        }
    }
    // https://girawhale.tistory.com/53
    private static int getUSADO(int k, int v, ArrayList<int[]>[]adjList, int n){
        // bfs
        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();

        int ans = 0;
        visited[v] = true; // v번 동영상에서 인접한 동영상 체크
        for(int[] info : adjList[v]){
            if(info[1] >= k){ // 인접한 동영상의 usado가 k이상이면
                queue.offer(info[0]); // 연관동영상임
                ++ans; // 답 업데이트
            }
        }
        while(!queue.isEmpty()){
            int now = queue.poll();
            visited[now] = true;

            for (int[] info : adjList[now]) { // 이어져 있는 동영상도
                if (!visited[info[0]] && info[1] >= k) { // 아직 체크하지 않았고 & usado가 k이상이면
                    queue.offer(info[0]); // 연관동영상임
                    ++ans; // 답 업데이트
                }
            }
        }

        return ans;
    }
}

import java.io.*;
import java.util.*;

public class BOJ13913 {
    // 수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
    static int[] time = new int[100001];
    static int[] parent = new int[100001];

    static void bfs(int n){
        Queue<Integer> queue = new LinkedList<>(); // queue는 자체 자료구조로 구현x --> linkedList를 사용하여 구현되어 있음
        queue.offer(n); // add와 같은 역할 -> 삽입에 실패했을 때, add는 예외를 발생시키는 반면, offer은 false를 반환
        time[n] = 0; // 시작하므로 시간은 0으로 초기화

        while(!queue.isEmpty()){
            int now = queue.poll(); // remove와 같은 역할 -> 삭제에 실패했을 때, remove는 예외를 발생시키는 반면, poll은 false를 반환
            for(int i=0; i<3; i++){
                int next;
                if(i==0) next = now-1;
                else if(i==1) next = now+1;
                else next = now*2;

                if(next<0 || next>100000) continue; // 오류 처리
                if(time[next] == -1){ // 방문하지 않은 위치라면 업데이트
                    queue.add(next);
                    time[next] = time[now] + 1;
                    parent[next] = now;
                }
            }
        }
    }

    static void printShortestPath(int n, int k){
        if(k != n){
            printShortestPath(n, parent[k]);
        }
        System.out.print(k + " ");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Arrays.fill(parent, -1); // 모든 원소 값을 -1로 초기화
        Arrays.fill(time, -1);

        bfs(n); // 모든 경로의 경우의 수 구하기

        System.out.println(time[k]); // 최단 시간 출력
        printShortestPath(n, k); // 최단 경로 출력
    }
}
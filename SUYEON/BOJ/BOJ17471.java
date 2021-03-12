package BOJ;

/**
 * 삼성 코테 기출
 */

import java.io.*;
import java.util.*;

public class BOJ17471 {

    static int[] peopleArr;
    static ArrayList<Integer>[] adjList;
    static int n, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = stoi(br.readLine()); // 구역의 개수

        StringTokenizer st = new StringTokenizer(br.readLine());
        peopleArr = new int[n+1]; // 인덱스 구역의 인구 수를 저장
        adjList = new ArrayList[n+1]; // 인접해있는 구역의 넘버를 저장
        for(int i=1; i<=n; i++){
            peopleArr[i] = stoi(st.nextToken());
            adjList[i] = new ArrayList<>();
        }

        for(int i=1; i<=n; i++){ // 인접 구역 넘버 저장 (간선 느낌)
            st = new StringTokenizer(br.readLine());
            int m = stoi(st.nextToken());
            for(int j=0; j<m; j++){
                adjList[i].add(stoi(st.nextToken()));
            }
        }

        // todo
        // 1. 2개의 지역구로 나눌수 있는 부분집합 구하기 - powerSet
        // 2. 지역구가 정상적으로 나눠졌는지 확인하기 - dfs/bfs(완탐)
        // 3. 정상적인 경우 지역구 별 인구수 차이를 구한 후 최솟값 갱신하기 - 빡구현

        answer = 2000;
        powerSet(1, 0, new boolean[n+1]); // index 1~n까지 부분집합을 구한다

        if(answer == 2000) answer = -1; // 구간을 나눌 수 없는 경우라는 뜻
        System.out.print(answer);
    }

    private static void powerSet(int idx, int subCnt, boolean[] selected){
        if(idx == n+1){
            if(subCnt>0 && subCnt<n){ // 집합의 true개수가 0/n이면 한 구역이 전체 구역을 차지하므로 그 경우를 제외시킨다
                boolean a = bfs(selected, true); // bfs를 사용하여 true인 값들이 모두 연결되어 있는지 확인
                boolean b = bfs(selected, false); // 위와 같음
                if(a && b){ // a,b구역 둘다 간선이 모두 연결되어 있다는 뜻이므로
                    int nowCal = getPeopleDiff(selected); // 인구차를 구해
                    answer = Math.min(answer, nowCal); // 최소값을 업데이트한다
                }
            }
            return;
        }

        // 기본 powerSet 형태
        selected[idx] = true;
        powerSet(idx+1, subCnt+1, selected);
        selected[idx] = false;
        powerSet(idx+1, subCnt, selected);
    }

    private static boolean bfs(boolean[] selected, boolean val){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];

        for(int i=1; i<=n; i++){
            if(selected[i] == val) { // 초기값 찾기
                visited[i] = true;
                queue.offer(i);
                break;
            }
        }

        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int i : adjList[now]){
                // selected[i] == val: 현재 검사하고자 하는 영역
                // !visited[i]: 방문했음을 체크하기 위함(아직 방문 안한 곳만 방문 체크하면 됨)
                if(selected[i] == val && !visited[i]){
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }

        for(int i=1; i<=n; i++){
            if(selected[i] == val && !visited[i]){ // 완탐하면서 현재 검사하고자 하는 영역이 아직까지 방문 안한 곳이 있다면
                return false; // 영역이 제대로 나눠지지 않은 것임
            }
        }
        return true;
    }

    private static int getPeopleDiff(boolean[] selected){
        int sa = 0, sb = 0;
        for(int i=1; i<=n; i++){
            if(selected[i]){
                sa += peopleArr[i];
            }
            else{
                sb += peopleArr[i];
            }
        }

        return Math.abs(sa-sb);
    }

    private static int stoi(String s){
        return Integer.parseInt(s);
    }
}

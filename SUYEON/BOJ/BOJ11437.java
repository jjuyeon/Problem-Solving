import java.util.*;
import java.io.*;

// 트리를 직접 구현해서 부모 찾는 문제 아님 -> 타임아웃 에러 뜸
// LCA(Lowest Common Ancestor) 알고리즘 사용하는 문제
// 1. 각 노드의 깊이와 바로 윗 부모를 배열에 저장한다.
// 2. 두 노드의 깊이를 맞춰준다.
// 3. 두 노드를 동시에 하나씩 올리면서 비교한다.
// 4. 같아지는 순간 종료 -> LCA
// https://hoho325.tistory.com/103

public class BOJ11437 {
    static ArrayList<ArrayList<Integer>> tree;
    static ArrayList<Integer> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tree = new ArrayList<>();
        answer = new ArrayList<>();

        // 정점과 간선 입력 받음
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<=N; i++){
            tree.add(new ArrayList<Integer>());
        }

        // 주어진 정점, 간선들로 트리 만들기
        for(int i=0; i<N-1; i++){
            String[] str = br.readLine().split(" ");
            int start = Integer.parseInt(str[0]);
            int end = Integer.parseInt(str[1]);

            tree.get(start).add(end);
            tree.get(end).add(start);
        }

        // 노드의 깊이와 해당 노드의 부모 저장
        int[] depth = new int[N+1];
        int[] parent = new int[N+1];
        dfs(depth, parent, 1, 1);

        // LCA 구하기
        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++){
            String[] str = br.readLine().split(" ");
            int compare1 = Integer.parseInt(str[0]);
            int compare2 = Integer.parseInt(str[1]);
            solve(depth, parent, compare1, compare2);
        }

        // 정답 출력
        for(int i=0; i<answer.size(); i++){
            System.out.println(answer.get(i));
        }

        br.close();
    }

    static void dfs(int[] depth, int[] parent, int root, int count){
        depth[root] = count++;
        for(int value : tree.get(root)) {
            if(depth[value] == 0){
                dfs(depth, parent, value, count);
                parent[value] = root;
            }
        }
    }

    static void solve(int[] depth, int[] parent, int v1, int v2){
        while(true){
            if(depth[v1] == depth[v2]){ // depth 일치
                if(v1 == v2){
                    answer.add(v1);
                    return;
                }
                else if(parent[v1] == parent[v2]){ // 부모 일치(공통 부모 찾음 -> LCA)
                    answer.add(parent[v1]);
                    return;
                }
                else{
                    v1 = parent[v1];
                    v2 = parent[v2];
                }
            }
            else{ // depth 불일치
                if(depth[v1]>depth[v2]){
                    v1 = parent[v1];
                }else{
                    v2 = parent[v2];
                }
            }
        }
    }
}
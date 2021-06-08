import java.io.*;
import java.util.*;

// https://blog.naver.com/whtrb_study/220787774510
// https://velog.io/@imfksh/%EB%B0%B1%EC%A4%80-11438-Java

public class BOJ11438 { // LCA dp version
    static ArrayList<ArrayList<Integer>> tree;
    static ArrayList<Integer> answer;

    static int [] depth;
    static int [][] parent;

    static int N;
    static int maxDepth;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tree = new ArrayList<>();
        answer = new ArrayList<>();

        // 정점과 간선 입력 받음
        N = Integer.parseInt(br.readLine());
        for (int i=0; i<=N; i++) {
            tree.add(new ArrayList<Integer>());
        }

        for (int i = 0; i<N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            tree.get(start).add(end);
            tree.get(end).add(start);
        }

        // 만들어진 트리의 최대 깊이 구하기 (이해 불가)
        int temp = 1;
        maxDepth = 0;
        while (temp <=N ) {
            temp<<=1;
            maxDepth++;
        }

        // 노드의 깊이와 해당 노드의 부모 저장
        depth  = new int [N+1];
        parent = new int [N+1][maxDepth]; //  parent 크기: parent[N][log(N)+1]
        dfs(1,1);

        fillParent();

        // LCA 구하기
        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            solve(a, b);
        }

        // 정답 출력
        for(int i=0; i<answer.size(); i++){
            System.out.println(answer.get(i));
        }

        br.close();
    }

    static void solve(int a, int b) { // (이해 불가)
        if (depth[a] < depth[b]) { // b의 깊이가 a보다 깊으므로 -> b의 깊이가 a보다 더 작도록 바꿈
            int temp = b;
            b = a;
            a = temp;
        }

        // 같은 깊이로 맞춰주기
        for (int i = maxDepth-1; i>=0; i--) {
            if(depth[b] <= depth[parent[a][i]]){
                a = parent[a][i];
            }
        }

        // a와 b가 같으면 return;
        if (a==b){
            answer.add(a);
            return;
        }

        for (int i = maxDepth-1; i>=0; i--) { // 높이까지 맞췄는데 a와 b가 다르면
            if (parent[a][i] != parent[b][i]) { // 같이 깊이를 올려간다
                a = parent[a][i];
                b = parent[b][i];
            }
        }
        answer.add(parent[a][0]);
    }

    static void fillParent() { // (이해 불가)
        for (int i = 1; i<maxDepth; i++) {
            for (int j = 1; j<=N; j++) {
                parent[j][i] = parent[parent[j][i-1]][i-1]; // dp 점화식
            }
        }
    }

    static void dfs(int node, int count){
        depth[node] = count++;
        for(int value : tree.get(node)) {
            if(depth[value] == 0){
                dfs(value, count);
                parent[value][0] = node;
            }
        }
    }
}

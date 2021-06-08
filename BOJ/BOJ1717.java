import java.io.*;
import java.util.*;

public class BOJ1717 {
    static int n;
    static int m;
    static int[] parent;
    static int[] depth;

    static void makeSet(){
        parent = new int[n+1]; // 0부터 n 까지의 자연수이므로 크기는 n+1 (0을 간과해서 계속 런타임 에러남)
        depth = new int[n+1];

        for(int i=0; i<=n; i++) {
            parent[i] = i;
            depth[i] = 0;
        }
    }

    static void union(int a, int b) { // union-by-rank 사용(높은 트리 밑에 낮은 트리를 합친다)
        a = find(a);
        b = find(b);

        if (a == b) // 트리의 루트가 같으면 이미 같은 트리에 있는 것(한 집합에 속해있다)
            return;

        if (depth[a] < depth[b]) { // b가 a보다 큰 트리
            parent[a] = b; // a의 parent를 b로 바꿈
        } else { // a가 b보다 큰 트리
            parent[b] = a;
            if (depth[a] == depth[b]) // a와 b의 깊이가 똑같을 때(a가 b보다 큰 트리라고 가정 -> a의 밑에 b를 합친다)
                depth[a]++;
        }
    }

    static int find(int a){
        if(parent[a] == a){ // 최고 root 노드
            return a;
        }
        return find(parent[a]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine()); // 공백 기준은 따로 선언 안해줘도 ㄱㅊ
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        makeSet();

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine()); // 공백 기준은 따로 선언 안해줘도 ㄱㅊ
            String check = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (check.equals("0"))
                union(a, b);
            else if (check.equals("1")) {
                if(find(a) == find(b))
                    sb.append("YES");
                else
                    sb.append("NO");

                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}

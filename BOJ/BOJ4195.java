import java.io.*;
import java.util.*;

public class BOJ4195 {
    // 어떤 사이트의 친구 관계가 생긴 순서대로 주어졌을 때, 두 사람의 친구 네트워크에 몇 명이 있는지 구하는 프로그램을 작성하시오.
    // 친구 네트워크란 친구 관계만으로 이동할 수 있는 사이를 말한다.
    static HashMap<String, Integer> list;
    static int idx = 0;
    static int[] parent;
    static int[] rank;
    static int[] count;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            int f = Integer.parseInt(br.readLine());
            makeSet(2*f);
            for(int j=0; j<f; j++){
                st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                if(!list.containsKey(a)){
                    list.put(a, idx);
                    parent[idx] = idx++;
                }
                if(!list.containsKey(b)){
                    list.put(b, idx);
                    parent[idx] = idx++;
                }

                union(list.get(a) , list.get(b));
                sb.append(count[find(list.get(a))] + "\n");
            }
        }

        System.out.print(sb.toString());
        br.close();
    }

    static void makeSet(int f){ // initial setting
        idx = 0;
        list = new HashMap<>();
        parent = new int[f];
        rank = new int[f];
        count = new int[f];
        Arrays.fill(count, 1);
    }


    static void union(int a, int b) { // union-by-rank 사용(높은 트리 밑에 낮은 트리를 합친다)
        a = find(a);
        b = find(b);

        if (a == b) // 트리의 루트가 같으면 이미 같은 트리에 있는 것(한 집합에 속해있다)
            return;

        if(rank[a] > rank[b]){ // 항상 b가 a보다 큰 트리로 만들기 위해
            int temp = a;
            a = b;
            b = temp;
        }
        parent[a] = b; // a의 parent를 b로 바꿈(b가 a보다 큰 트리이므로 a를 b로 합쳐줌)
        count[b] += count[a];
        count[a] = 1;
        if (rank[a] == rank[b]) // a와 b의 깊이가 똑같을 때(a가 b보다 큰 트리라고 가정 -> a의 밑에 b를 합친다)
            rank[a]++;
    }

    static int find(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}

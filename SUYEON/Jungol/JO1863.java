package Jungol;

import java.io.*;
import java.util.*;

public class JO1863 {

    static int n;
    static int[] parents, rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = stoi(st.nextToken());
        int m = stoi(st.nextToken());

        makeSet();

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());

            union(a, b);
        }

        int result = 0;
        for(int i=1; i<=n; i++){
            if(parents[i] == i){
                ++result;
            }
        }
        System.out.print(result);
    }

    private static void makeSet(){
        parents = new int[n+1];
        rank = new int[n+1];
        for(int i=1; i<=n; i++){
            parents[i] = i;
            rank[i] = 0;
        }
    }

    private static int findSet(int a){
        if(parents[a] == a){
            return a;
        }

        return findSet(parents[a]);
    }

    private static boolean union(int a, int b){
        a = findSet(a);
        b = findSet(b);

        if(a == b) return false;

        if(rank[a] < rank[b]) {
            parents[a] = b; // 어차피 이제 부모만으로 체크를 할 것이기 때문에 rank도 업데이트해주는건 의미 없음
        }
        else { // 같은 경우 여기서 포함
            parents[b] = a;
        }

        if(rank[a] == rank[b]) { // 그러므로, a집합으로 흡수됨
            ++rank[a];
        }

        return true;
    }

    private static int stoi(String s){
        return Integer.parseInt(s);
    }
}

package SWEA;

import java.util.Scanner;

public class D4_7465 {

    static int[] parent, rank;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();

            makeSet(n);
            for(int i=0; i<m; i++) {
                union(sc.nextInt(), sc.nextInt());
            }

            System.out.println("#"+test_case+" "+getDisjointCnt(n));
        }
    }

    private static void makeSet(int n){
        parent = new int[n+1];
        rank = new int[n+1];
        for(int i=1; i<=n; i++){
            parent[i] = i;
            rank[i] = 0;
        }
    }

    private static int find(int a){
        if(parent[a] == a){
            return a;
        }
        return find(parent[a]);
    }

    private static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a == b){
            return;
        }

        if(rank[a] > rank[b]){ // a에 합침
            parent[b] = a;
        }
        else{ // b에 합침
            parent[a] = b;
        }
        if(rank[a] == rank[b]){
            ++rank[b];
        }
    }

    private static int getDisjointCnt(int n){
        int ans = 0;
        for(int i=1; i<=n; i++){
            if(parent[i] == i) ++ans;
        }
        return ans;
    }
}

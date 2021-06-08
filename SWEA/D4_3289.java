package SWEA;

import java.util.Scanner;

public class D4_3289 {

    static int[] parent, rank;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringBuilder sb = new StringBuilder();
            int n = sc.nextInt();
            int m = sc.nextInt();

            makeSet(n);
            for(int i=0; i<m; i++){
                int operator = sc.nextInt();
                if(operator == 0){
                    union(sc.nextInt(), sc.nextInt());
                }
                else if(operator == 1){
                    if(checkSameParent(sc.nextInt(), sc.nextInt())){
                        sb.append(1);
                    }
                    else{
                        sb.append(0);
                    }
                }
            }
            System.out.println("#"+test_case+" "+sb.toString());
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

        if(a == b) return;

        if(rank[a] > rank[b]) {
            parent[b] = a;
        }
        else {
            parent[a] = b;
        }
        if(rank[a] == rank[b]){
            ++rank[b];
        }
    }

    private static boolean checkSameParent(int a, int b){
        a = find(a);
        b = find(b);

        return a==b;
    }
}

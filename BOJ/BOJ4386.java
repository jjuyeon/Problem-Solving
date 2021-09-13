package BOJ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ4386 {

    static class Edge implements Comparable<Edge> {
        int from, to;
        double weight;
        Edge(int from, int to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            if(this.weight > o.weight)
                return 1;

            else if(this.weight == o.weight)
                return 0;

            return -1;
        }
    }

    static double[][] star;
    static ArrayList<Edge> edgeList;
    static int[] parent;
    static int[] rank;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        star = new double[n][2];
        for(int i=0; i<n; i++) {
            star[i][0] = sc.nextDouble();
            star[i][1] = sc.nextDouble();
        }

        parent = new int[n];
        rank = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        edgeList = new ArrayList<>();
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                double weight = calDistance(i, j);
                edgeList.add(new Edge(i, j, weight));
            }
        }

        Collections.sort(edgeList);

        double ans = 0;
        for(Edge edge : edgeList) {
            if(!isSameParent(edge.from, edge.to)) {
                ans += edge.weight;
                union(edge.from, edge.to);
            }
        }
        System.out.printf("%.2f", ans);
    }

    private static boolean isSameParent(int v1, int v2) {
        return find(v1) == find(v2);
    }

    private static void union(int v1, int v2) {
        v1 = find(v1);
        v2 = find(v2);

        if(v1 == v2) return;

        if(rank[v1] < rank[v2]) {
            parent[v1] = v2;
        } else {
            parent[v2] = v1;
            if(rank[v1] == rank[v2]) {
                ++rank[v1];
            }
        }
    }

    private static int find(int v) {
        if(parent[v] == v) return v;
        return parent[v] = find(parent[v]);
    }

    private static double calDistance(int v1, int v2) {
        return Math.sqrt(Math.pow((star[v1][0] - star[v2][0]), 2) + Math.pow((star[v1][1] - star[v2][1]), 2));
    }
}

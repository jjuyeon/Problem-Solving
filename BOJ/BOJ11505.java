import java.util.*;
import java.io.*;

public class BOJ11505 {
    final static int MOD = 1000000007;
    static long[] data, tree;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        data = new long[n+1];
        tree = new long[n*4];
        for(int i=1; i<=n; i++)
            data[i] = Long.parseLong(br.readLine());

        init(1,1,n); // initialize segment tree

        for(int i=0; i<m+k; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a==1){ // update
                update(1,1,n,b,c);
                data[b] = c;
            }
            else if(a==2){ // multiply
                sb.append(mul(1,1,n,b,c)).append("\n");
            }
        }

        System.out.print(sb.toString());
    }

    static long init(int node, int start, int end){
        if(start == end) return tree[node] = data[start];
        int mid = (start+end)/2;
        return tree[node] = (init(node*2, start, mid) * init(node*2+1, mid+1, end)) % MOD;
    }

    static long update(int node, int start, int end, int idx, long change){ // tree 만들 때처럼 리프노드부터 만들어서 올라가면서 업데이트(0을 곱하는 것 때문에 이전 값을 통해서 update 불가능)
        if(!(start<=idx && idx<=end)) return tree[node];

        if(start == end) return tree[node] = change;

        int mid = (start+end)/2;
        return tree[node] = (update(node*2, start, mid, idx, change) * update(node*2+1, mid+1, end, idx, change)) % MOD;
    }

    static long mul(int node, int start, int end, int left, int right){
        if(right<start || end<left) return 1;
        if(left<=start && end<=right) return tree[node];

        int mid = (start+end) / 2;
        return (mul(node*2, start, mid, left, right) * mul(node*2+1, mid+1, end, left, right)) % MOD;
    }
}

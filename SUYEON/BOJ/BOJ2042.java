import java.io.*;
import java.util.*;

public class BOJ2042 { // segment tree
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
        tree = new long[n*4]; // https://www.crocus.co.kr/648
        for(int i=1; i<=n; i++) { // 노드 번호를 1부터 시작하는 이유: left, right 자식을 구해야하는데 0으로 하면 공식 적용이 안됨.
            data[i] = Integer.parseInt(br.readLine());
        }
        init(1,1, n); // initialize segment tree

        for(int i=0; i<m+k; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == 1){ // update segment tree
                long diff = c-data[b]; // 바꾸려는 값과 원래 값의 차이
                data[b] = c;
                update(1, 1, n, b, diff);
            }
            else if(a == 2){ // summarize partial part
                sb.append(sum(1, 1, n, b, c)).append("\n");
            }
        }
        System.out.print(sb.toString());
        br.close();
    }

    public static long init(int node, int start, int end){ // segment tree 만드는 함수
        if(start == end) return tree[node] = data[start]; // 리프노드
        int mid = (start+end)/2;
        // 각 노드의 왼쪽 자식과 오른쪽 자식으로 분리하여 리프노드에 data 배열의 값을 넣은 후, 부모 노드에 그 합을 저장
        return tree[node] = init(2*node, start, mid) + init(2*node+1, mid+1, end);
    }

    public static void update(int node, int start, int end, int idx, long diff){ // 업데이트 함수(루트 노드부터 내려가면서 업데이트)
        if(!(start <= idx && idx <= end)) return; // 바꾸려고 하는 위치가 start와 end 사이에 없다면 그냥 끝낸다.

        tree[node] += diff; // 차이가 나는 값만큼 tree 값 업데이트

        if(start != end){
            int mid = (start + end) / 2;
            update(2*node, start, mid, idx, diff); // left에 idx가 영향을 끼치는 노드 있는지 확인
            update(2*node+1, mid+1, end, idx, diff); // right에 idx가 영향을 끼치는 노드 있는지 확인
        }
    }

    public static long sum(int node, int start, int end, int left, int right){ // left~right까지의 합을 구하는 함수
        if(left > end || right < start) return 0; // [left~right]구간이 [start~end]구간과 겹치지 않음
        if(left <= start && end <= right) return tree[node]; // [left~right]구간이 [start~end]구간을 완전히 포함할 경우

        int mid = (start + end) / 2;
        return sum(2*node, start, mid, left, right) + sum(2*node+1, mid+1, end, left, right);
    }
}
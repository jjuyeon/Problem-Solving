import java.util.*;
import java.io.*;

public class BOJ6549_segmentTree {
    // 참고 : https://blog.naver.com/occidere/221057769152
    // https://steady-coding.tistory.com/129

    static int[] height;
    static int[] tree;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(true){
            String readLine = br.readLine();
            if(readLine.equals("0"))
                break;

            st = new StringTokenizer(readLine);
            int n = stoi(st.nextToken());
            height = new int[n+1];
            tree = new int[n*4];
            for(int i=1; i<=n; i++){
                height[i] = stoi(st.nextToken());
            }

            init(1, 1, n); // segment tree 만들기

            sb.append(getMaxWidth(1, n, n)).append("\n");
        }

        System.out.print(sb.toString());
    }

    static int init(int node, int start, int end){
        if(start == end) // 리프노드
            return tree[node] = start;

        int mid = (start+end) / 2;

        int left = init(2*node, start, mid); // node를 기준으로 왼쪽 탐색
        int right = init(2*node+1, mid+1, end); // node를 기준으로 오른쪽 탐색

        return tree[node] = (height[left] < height[right]) ? left : right;
    }

    /* 최대 넓이를 찾는 함수
     * 우선 최소 높이의 인덱스(minIndex)를 찾아서 최대 넓이(maxWidth)를 계산한다.
     * 이후 minIndex의 왼쪽(left ~ minIndex-1)과 오른쪽(minIndex+1 ~ right)로 쪼개서
     * 재귀 탐색을 한다.
     * 최종적으로 가장 큰 maxWidth를 반환한다.
     */
    static long getMaxWidth(int left, int right, int N){
        long maxWidth, tmpWidth;
        int minIndex = query(1, 1, N, left, right);

        // minIndex를 통해 최소 높이를 구할 수 있으므로, 이를 바탕으로 넓이 계산
        maxWidth = (long) (right - left + 1) * height[minIndex];

        // minIndex 기준으로 왼쪽에 다른 막대가 존재하는지 확인
        if(left <= minIndex -1){
            tmpWidth = getMaxWidth(left, minIndex-1, N);
            maxWidth = Math.max(maxWidth, tmpWidth);
        }
        // minIndex 기준으로 오른쪽에 다른 막대가 존재하는지 확인
        if(minIndex+1 <= right){
            tmpWidth = getMaxWidth(minIndex+1, right, N);
            maxWidth = Math.max(maxWidth, tmpWidth);
        }
        return maxWidth;
    }

    // 특정 구간 내의[left ~ right] 최소 높이의 인덱스를 구하는 함수
    static int query(int node, int start, int end, int left, int right){
        if (right < start || end < left) { // [left ~ right]구간이 [start ~ end]구간과 겹치지 않음
            return -1;
        }

        if (left <= start && end <= right) { // [left ~ right]구간이 [start ~ end]구간을 완전히 포함할 경우
            return tree[node];
        }

        int mid = (start + end) / 2;
        int m_left = query(2*node, start, mid, left, right); // 왼쪽 탐색
        int m_right = query(2*node+1, mid+1, end, left, right); // 오른쪽 탐색

        if(m_left == -1){
            return m_right;
        }else if(m_right == -1){
            return m_left;
        }else{
            return (height[m_left] < height[m_right]) ? m_left : m_right;
        }
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}
import java.util.*;
import java.io.*;
/**
 * @author HEESOO
 *
 */
class Main {
	static long[] input, tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		
		tree=new long[N*4];
		input=new long[N+1]; // 인덱스 1부터 사용
		for(int i=1;i<=N;i++) 
			input[i]=Long.parseLong(br.readLine());
		init(1, 1, N); // 세그먼트 트리 생성
		
		for(int i=0;i<M+K;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			if(a==1) { // b번째를 c로 변경
				int b=Integer.parseInt(st.nextToken());
				long c=Long.parseLong(st.nextToken());
				long diff=c-input[b];
				input[b]=c;
				update(1, 1, N, b, diff);
			}
			else { // b~c 합 출력
				int b=Integer.parseInt(st.nextToken());
				int c=Integer.parseInt(st.nextToken());
				System.out.println(sum(1, 1, N, b, c));
			}
		}
		
	}
	
	 public static long init(int node, int left, int right) {
		 if(left==right) return tree[node]=input[left]; // 리프노드
		 
		 int mid=(left+right)/2;
		 // (node)번째 노드 합=왼쪽 자식(2*node) 합+오른쪽 자식(2*node+1) 합
		 return tree[node]=init(2*node, left, mid)+init(2*node+1, mid+1, right);
	 }
	 
	 public static void update(int now, int left, int right, int idx, long diff) {
		 // now: 현재 노드 위치,  left right: 현재 노드의 합 범위, idx: 바꾸고자 하는 노드 인덱스, diff: 더할 값
		 if(idx<left || idx>right) return; // 현재 범위에 idx가 포함되지 않는다면 종료
		 
		 // 현재 범위(left~right)에 idx가 포함되는 경우임
		 tree[now]+=diff;
		 if(left!=right) { // 아직 탐색할 수 있는 범위가 더 있다면
			 int mid=(left+right)/2;
			 update(2*now, left, mid, idx, diff);
			 update(2*now+1, mid+1, right, idx, diff);
		 }
	 }
	 
	 public static long sum(int now, int left, int right, int rangeA, int rangeB) {
		 // now: 현재 노드 위치, left right: 현재 노드의 합 범위, rangeA rangeB: 찾아야 할 범위
		 if(right<rangeA || left>rangeB) return 0; // 찾아야 할 범위를 벗어나면
		 if(rangeA<=left && right<=rangeB) return tree[now]; // 찾아야 할 범위 안에 들어왔다면 현재 위치의 구간 합 리턴
		 
		 // 걸쳐 있을 경우
		 int mid=(left+right)/2;
		 return sum(2*now, left, mid, rangeA, rangeB)+sum(2*now+1, mid+1, right, rangeA, rangeB);
	 }
}
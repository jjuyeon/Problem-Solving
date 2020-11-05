import java.io.*;
import java.util.*;
/*
 * MST?
 * int[] parent, 초기화
 * Node 클래스 생성하고, 우선순위 큐에 다 넣어
 * 부모가 같으면 패스, 다르면 union하고 sum+=weight*/

class Main {
	static PriorityQueue<Node> pq;
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n=Integer.parseInt(br.readLine());
		int m=Integer.parseInt(br.readLine());
		pq=new PriorityQueue<>();
		parent=new int[n+1];
		for(int i=1;i<=n;i++) parent[i]=i;
		
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			pq.offer(new Node(a, b, c));
		}
		
		System.out.println(solve());
	}
	
	public static int solve() {
		int sum=0;
		
		while(!pq.isEmpty()) {
			Node node=pq.poll();
			int parentS=find(node.start);
			int parentE=find(node.end);
			if(parentS==parentE) continue;
			union(parentS, parentE);
			sum+=node.weight;
		}
		
		return sum;
	}
	
	public static int find(int x) {
		if(x==parent[x]) return x;
		else return parent[x]=find(parent[x]);
	}
	
	public static void union(int a, int b) {
		parent[a]=b;
	}

}

class Node implements Comparable<Node>{
	int start;
	int end;
	int weight;
	
	public Node(int s, int e, int w) {
		this.start=s;
		this.end=e;
		this.weight=w;
	}
	
	@Override
	public int compareTo(Node n) {
		return this.weight-n.weight;
	}
}

import java.io.*;
import java.util.*;

class Main {
	static PriorityQueue<Node> pq;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		pq=new PriorityQueue<>();
		int v=Integer.parseInt(st.nextToken());
		int e=Integer.parseInt(st.nextToken());
		parent=new int[v+1];
		for(int i=1;i<=v;i++) parent[i]=i;
		
		for(int i=0;i<e;i++) {
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
			if(parentS!=parentE) {
				union(parentS, parentE);
				sum+=node.weight;
			}
		}
		
		return sum;
	}
	
	public static int find(int x) {
		if(parent[x]==x) return x;
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
import java.io.*;
import java.util.*;

class Main {	
	static int[] dist;
	static ArrayList<ArrayList<Node>> list;
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc=Integer.parseInt(br.readLine());
		
		while(tc-->0) {
			st=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			
			dist=new int[n+1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			list=new ArrayList<>();
			for(int i=0;i<=n;i++) 
				list.add(new ArrayList<>());
			cnt=1;
			
			PriorityQueue<Node> pq=new PriorityQueue<>();
			pq.offer(new Node(c, 0));
			dist[c]=0;
			
			for(int i=0;i<d;i++) {
				st=new StringTokenizer(br.readLine());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				int s=Integer.parseInt(st.nextToken());				
				list.get(b).add(new Node(a, s));
			}

			solve(pq);
			int[] result=Arrays.stream(dist).filter(k->k!=Integer.MAX_VALUE).toArray();
			Arrays.sort(result);
			System.out.println(cnt+" "+result[result.length-1]);
		}
		
	}
	
	public static void solve(PriorityQueue<Node> pq) {
		while(!pq.isEmpty()) {
			Node node=pq.poll();
			if(node.weight>dist[node.idx]) continue;
			
			for(Node n:list.get(node.idx)) {
				if(dist[n.idx]>dist[node.idx]+n.weight) {
					if(dist[n.idx]==Integer.MAX_VALUE) cnt++;
					dist[n.idx]=dist[node.idx]+n.weight;
					pq.offer(new Node(n.idx, dist[n.idx]));
				}
				
			}
		}
	}
	
}
class Node implements Comparable<Node>{
	int idx;
	int weight;
	
	public Node(int i, int w) {
		this.idx=i;
		this.weight=w;
	}
	
	@Override
	public int compareTo(Node n) {
		return this.weight-n.weight;
	}
}



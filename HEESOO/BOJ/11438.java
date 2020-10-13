import java.util.*;
import java.io.*;

class Main {
	static ArrayList<ArrayList<Integer>> list;
	static int[] depth;
	static int[][] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int maxDepth=0;
		int check=1;
		while(check<=n) {
			check<<=1;
			maxDepth++;
		}
		
		list=new ArrayList<>();
		for(int i=0;i<n+1;i++) list.add(new ArrayList<>());
		depth=new int[n+1];
		parent=new int[n+1][maxDepth+1];
		
		for(int i=0;i<n-1;i++) {
			String[] s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			list.get(a).add(b);
			list.get(b).add(a);
		}
		dfs(1, 1);
		setParent(n, maxDepth);
		
		int m=Integer.parseInt(br.readLine());
		for(int i=0;i<m;i++) {
			String[] s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			System.out.println(solve(a, b, maxDepth));
			
		}
	}
	
	
	public static void dfs(int node, int cnt) {
		depth[node]=cnt;
		for(int n:list.get(node)) {
			if(depth[n]!=0) continue;
			parent[n][0]=node;
			dfs(n, cnt+1);
		}
	}
	
	public static void setParent(int n, int maxDepth) {
		for(int i=1;i<maxDepth;i++) {
			for(int j=1;j<=n;j++) {
				parent[j][i]=parent[parent[j][i-1]][i-1];
			}
		}
	}
	
	public static int solve(int a, int b, int maxDepth) {
		if(depth[a]>depth[b]) {
			int temp=a;
			a=b;
			b=temp;
		}
		for(int i=maxDepth-1;i>=0;i--) {
			if(depth[a]<=depth[parent[b][i]]) b=parent[b][i];
		}
		
		if(a==b) return a;
		
		for(int i=maxDepth-1;i>=0;i--) {
			if(parent[a][i]!=parent[b][i]) {
				a=parent[a][i];
				b=parent[b][i];
			}
		}
		return parent[a][0];
	}
}

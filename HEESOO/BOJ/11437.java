import java.util.*;

class Main {
	static int n;
	static ArrayList<ArrayList<Integer>> list;
	static int[] depth, parent;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		list=new ArrayList<>();
		for(int i=0;i<=n;i++) {
			list.add(new ArrayList<Integer>());
		}		
		for(int i=0;i<n-1;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		depth=new int[n+1];
		parent=new int[n+1];
		dfs(1,1);
		
		int m=sc.nextInt();
		for(int i=0;i<m;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			System.out.println(solve(a,b));
		}
	}
	
    public static void dfs(int node, int cnt) {
    	depth[node]=cnt;
    	
    	for(int child:list.get(node)) {
    		if(depth[child]==0) {
    			dfs(child, cnt+1);
    			parent[child]=node;
    		}
    	}
    }
    
    public static int solve(int a, int b) {
    	while(depth[a]>depth[b]) {
    		a=parent[a];
    	}
    	while(depth[a]<depth[b]) {
    		b=parent[b];
    	}
    	
    	while(a!=b) {
    		a=parent[a];
    		b=parent[b];
    	}
    	
    	return a;
    }
    
}

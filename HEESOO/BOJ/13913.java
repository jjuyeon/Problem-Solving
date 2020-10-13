import java.util.*;

class Main {
	static StringBuilder sb;
	static int[] parent;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		
		int[] time=new int[100001];
		int[] prev=new int[100001];
		Arrays.fill(time, -1);
		
		Stack<Integer> st=new Stack<>();
		Queue<Integer> q=new LinkedList<>();
		q.offer(n);
		time[n]=0;
		
		while(!q.isEmpty()) {
			int x=q.poll();
			if(x==k) {
				while(x!=n) {
					st.push(x);
					x=prev[x];
				}
				st.push(n);
				break;
			}
			
			int[] dotX= {-1,1,x};
			for(int i=0;i<3;i++) {
				int next=dotX[i]+x;
				if(next<0 || next>100000 || time[next]!=-1) continue;
				time[next]=time[x]+1;
				prev[next]=x;
				q.offer(next);
			}
			
		}
		
		System.out.println(time[k]);
		while(!st.isEmpty()) {
			System.out.print(st.pop()+" ");
		}
	}
	
}

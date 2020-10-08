import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author HEESOO
 *
 */
public class Main {
	static int[][] graph;
	static boolean[] visit;
	public static void dfs(int s) {
		if(visit[s]) return;
		
		visit[s]=true;
		System.out.print(s+" ");
		for(int i=1;i<visit.length;i++)
			if(!visit[i]&&graph[s][i]==1)
				dfs(i);
	}
	public static void bfs(int s) {
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(s);
		visit[s]=true;
		while(!q.isEmpty()) {
			int now=q.poll();
			System.out.print(now+" ");
			for(int i=1;i<visit.length;i++) {
				if(graph[now][i]==1&&!visit[i]) {
					q.add(i);
					visit[i]=true;
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n=scan.nextInt();
		int m=scan.nextInt();
		int v=scan.nextInt();
		graph=new int[n+1][n+1];
		visit=new boolean[n+1];
		for(int i=0;i<m;i++) {
			int x=scan.nextInt();
			int y=scan.nextInt();
			graph[x][y]=1;
			graph[y][x]=1;
		}
		
		dfs(v);
		System.out.println();
		Arrays.fill(visit, false);
		bfs(v);
	}
}

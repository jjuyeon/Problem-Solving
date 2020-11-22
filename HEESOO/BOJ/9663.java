import java.util.Scanner;

/**
 * 
 * @author HEESOO
 *
 */
public class Main {
	static int n;
	static int answer;
	static boolean visit[][];
	public static void dfs(int x){
		if(x==n){
			answer++;
			return;
		}
		for(int i=0;i<n;i++){
			if(!check(x, i)) continue;
			visit[x][i]=true;
			dfs(x+1);
			visit[x][i]=false;
		}
	}
	public static boolean check(int x, int y){
		for(int i=0;i<n;i++){
			if(i<=y&&visit[x][i]) return false;
			if(i<=x&&visit[i][y]) return false;
			if(x+i<n&&y+i<n&&visit[x+i][y+i]) return false;
			if(x-i>=0&&y-i>=0&&visit[x-i][y-i]) return false;
			if(x-i>=0&&y+i<n&&visit[x-i][y+i]) return false;
			if(x+i<n&&y-i>=0&&visit[x+i][y-i]) return false;
		}
		return true;
	}
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		n=input.nextInt();
		visit=new boolean[n][n];
		answer=0;
		
		dfs(0);
		System.out.println(answer);
	}
}
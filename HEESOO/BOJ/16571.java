import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;		
		
		int[][] map=new int[3][3];
		int zero=0;
		
		for(int i=0;i<3;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==0) zero++;
			}
		}
		
		int win=game(zero%2!=0? 1:2, map);
		char answer;
		if(win==1) answer='W';
		else if(win==0) answer='D';
		else answer='L';
		System.out.println(answer);
	}
	
	public static int game(int now, int[][] map) {
//		if(isWin(now, map)) return 1;
		int min=2;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(map[i][j]==0) {
					map[i][j]=now;
					if(isWin(now, map)) min=Math.min(min, -1);
					
					min=Math.min(min, game(now==1? 2:1, map));
					map[i][j]=0;
				}
			}
		}
		
		if(min==1) return -1;
		else if(min==0 || min==2) return 0;
		else return 1;
	}
	
	public static boolean isWin(int now, int[][] map) {
		for(int i=0;i<3;i++) {
			if(map[i][0]==now && map[i][0]==map[i][1] && map[i][1]==map[i][2]) return true;
		}
		
		for(int j=0;j<3;j++) {
			if(map[0][j]==now && map[0][j]==map[1][j] && map[1][j]==map[2][j]) return true;
		}
		
		if(map[0][0]==now && map[0][0]==map[1][1] && map[1][1]==map[2][2]) return true;
		if(map[0][2]==now && map[0][2]==map[1][1] && map[1][1]==map[2][0]) return true;
		
		return false;
	}
}

package tree;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * (1,1)에서 출발해서 (N,M)까지 가는 경로의 수를 구하세요
 */

public class MapSearch_2차원배열_경로출력 {
	static int N, RouteCnt, maxDistance, minDistance;
	static int[][] map;
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("MapSearch.txt"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N+1][N+1];
		for(int r = 1; r<=N; r++) {
			for(int c = 1; c<=N; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		
		RouteCnt = 0; maxDistance = 0; minDistance = Integer.MAX_VALUE;
		System.out.println("-------dfs를 통한 최단경로-------");
		dfs(1, 1, new boolean[N+1][N+1], 0);
		System.out.println("총 갈 수 있는 경로의 수 : " + RouteCnt);
		System.out.println("길이가 제일 긴 경로: " + maxDistance);
		System.out.println("길이가 제일 짧은 경로: " + minDistance);
		
		System.out.println("\n-------bfs를 통한 최단경로-------");
		minDistance = bfs();
		System.out.println("최단 경로 길이: " + minDistance);
	}
	
	static int[] dr = {-1,1,0,0}; // 상하좌우
	static int[] dc = {0,0,-1,1};
	
	private static void dfs(int r, int c, boolean[][] v, int distanceCnt) { // 갈 수 있는 모든 경로의 경우의 수를 구할 수 있음

		v[r][c] = true;

		if(r == N && c == N) {
			RouteCnt++;
			maxDistance = Math.max(maxDistance, distanceCnt);
			minDistance = Math.min(minDistance, distanceCnt);
			System.out.println("dfs 경로 " + RouteCnt);
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(v[i][j]) {
						System.out.printf("(%d, %d) -> ", i ,j);
					}
				}
			}
			System.out.println("End");
			return;
		}
		
		for(int l = 0; l < 4; l++) {
			int nr = r + dr[l];
			int nc = c + dc[l];
			
			if(nr>=1 && nr<=N && nc>=1 && nc<=N) {
				if(!v[nr][nc] && map[nr][nc] == 1) {
					dfs(nr, nc, v, distanceCnt+1); // 재귀로 길을 찾아감
					v[nr][nc] = false; // 해당 경로를 다 찾아서 함수가 끝났다면 방문배열도 원상태로 바꿔준다 ( 그래야 다음 경로에 대해서도 방문 가능 )
				}
			}
		}
	
	}
	
	static class Point{
		int r, c, cnt;
		Point prev;
		
		Point(int r, int c, int cnt, Point prev){
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.prev = prev;
		}
	}
	
	private static int bfs() { // 최단 거리를 찾으면 끝냄 = 최단 거리만 구할 수 있음
		boolean[][] v = new boolean[N+1][N+1];
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(1, 1, 0, null));
		v[1][1] = true;
		
		Point p = null;
		while(!queue.isEmpty()) {
			p = queue.poll();

			if(p.r == N && p.c == N) { // 도착점 도달 = 최단 거리 (왜? 동작방식 생각해보삼)
				printRoute(p);
				System.out.println("End");
				break;
			}
			
			for(int i=0; i<4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				if(nr>=1 && nr<=N && nc>=1 && nc<=N) {
					if(!v[nr][nc] && map[nr][nc] == 1) {
						queue.offer(new Point(nr,nc,p.cnt+1, p));
						v[nr][nc] = true;
					}
				}
			}
		}
		
		return p.cnt;
	}
	
	private static void printRoute(Point p) {
		if(p == null) {
			return;
		}
		printRoute(p.prev);
		System.out.printf("(%d, %d) -> ", p.r, p.c); 
	}
}

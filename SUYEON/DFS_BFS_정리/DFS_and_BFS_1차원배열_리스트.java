package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
7 6 0 // 노드 수, 간선 수, 시작 점
0 1 // 간선의 정보
0 2 
1 3
1 4
2 5
2 6
 */
public class DFS_and_BFS_1차원배열_리스트 {
	static int N, M, S;
	static int[][] adjMat;
	static ArrayList<Integer>[] adjList;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 노드 수 (루트 노드 0부터 시작)
		M = sc.nextInt(); // 간선 수
		S = sc.nextInt(); // 시작점
		adjMat = new int[N][N];
		adjList = new ArrayList[N];
		for(int i=0; i<N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			int s = sc.nextInt(); // 간선의 시작점
			int e = sc.nextInt(); // 간선의 도착점
			adjMat[s][e] = 1;
			adjMat[e][s] = 1; // 양방향
			adjList[s].add(e);
			adjList[e].add(s);
		}
		
		System.out.println("===DFS===");
		dfs_with_matrix(S, new boolean[N]); // 인자: 시작점 , 방문 체크 배열
		System.out.println("\n===BFS===");
		bfs_with_matrix(S); // 인자: 시작점
		
		System.out.println();
		
		System.out.println("===DFS with list ===");
		dfs_with_list(S, new boolean[N]);
		System.out.println("\n===BFS with list===");
		bfs_with_list(S);
	}
	
	private static void dfs_with_matrix(int s, boolean[] v) {
		v[s] = true; // 방문했음
		System.out.print(s + " ");
		
		for(int i=0; i<N; i++) {
			if(adjMat[s][i] == 1 && !v[i]) {
				dfs_with_matrix(i, v);
			}
		}
	}
	
	private static void dfs_with_list(int s, boolean[] v) {
		v[s] = true;
		System.out.print(s + " ");
		for(int i=0; i<adjList[s].size(); i++) {
			int node = adjList[s].get(i);
			if(!v[node]) {
				dfs_with_list(node, v);
			}
		}
	}
	
	private static void bfs_with_matrix(int s) {
		boolean[] v = new boolean[N];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(s);
		v[s] = true; // 방문 체크하고 큐에 넣어줌
		while(!queue.isEmpty()) {
			int p = queue.poll(); // 큐에서 빼서 방문 완료하고
//			v[p] = true; // 이러면 안된다!
			/**
			 * v[p] = true;을 여기에 쓰면 안되는 이유 : 트리일 때는 괜찮지만, 그래프일 때는 상하관계가 없으므로 경로에서 자식노드가 형제노드를 방문할 수 있다.
			 * 이때, 형제노드는 아직 방문하지 않은 노드로 인식되기 때문에 큐에 있음에도 불구하고 또 넣어지는 중복이 발생할 수 있다.
			 * 이렇게 계속 쓰레기 값(불필요한 값)이 들어가기 때문에 Runtime error가 발생할 수 있다.
			 */
			System.out.print(p + " ");
			for(int i=0; i<N; i++) { 
				if(adjMat[p][i] == 1 && !v[i]) { // 해당 정점과 연결된 정점 중 방문하지 않은 정점을 다시 큐에 넣어줌
					queue.add(i);
					v[i] = true;
				}
			}
		}
	}
	
	private static void bfs_with_list(int s) {
		boolean[] v = new boolean[N];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(s);
		v[s] = true;
		while(!queue.isEmpty()) {
			int node = queue.poll();
			System.out.print(node + " ");
			for(int i=0; i<adjList[node].size(); i++) {
				int nextNode = adjList[node].get(i);
				if(!v[nextNode]) {
					queue.offer(nextNode);
					v[nextNode] = true;
				}
			}
		}
	}
}

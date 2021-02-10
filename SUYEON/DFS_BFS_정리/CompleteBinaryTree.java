package tree;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {

	private char[] nodes;
	private int lastIndex=0;
	private final int SIZE;
	
	public CompleteBinaryTree(int size) {
		super();
		SIZE = size;
		nodes = new char[size+1];
	}
	
	public boolean isEmpty() {
		return lastIndex == 0;
	}
	
	public boolean isFull() {
		return lastIndex == SIZE;
	}
	
	public void add(char e) {
		if(isFull()) {
			System.out.println("포화상태입니다.");
			return;
		}
		nodes[++lastIndex] = e;
	}
	
	public void bfs() {
		if(isEmpty()) return;
		
		// 노드의 탐색 순서번호를 큐로 관리
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(1);
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.println("현재 탐색 인덱스: " + current + ", " + "인덱스의 값: " + nodes[current]);
			// 왼쪽자식
			if(current*2 <= lastIndex) {
				queue.offer(current*2);
			}
			// 오른쪽자식
			if(current*2+1 <= lastIndex) {
				queue.offer(current*2+1);
			}
		}
	}
	
	public void bfs_with_level() {
		if(isEmpty()) return;
		
		// 노드의 탐색 순서번호를 큐로 관리
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(1);
		
		int current, size, level = 0;
		
		while(!queue.isEmpty()) {
			size = queue.size();
			
			System.out.println("level "+level+": ");
			while(--size>=0) {
				current = queue.poll();
				System.out.println("현재 탐색 인덱스: " + current + ", " + "인덱스의 값: " + nodes[current]);
				// 왼쪽자식
				if(current*2 <= lastIndex) {
					queue.offer(current*2);
				}
				// 오른쪽자식
				if(current*2+1 <= lastIndex) {
					queue.offer(current*2+1);
				}	
			}
			System.out.println("------탐색 끝------");
			++level;
		}
	}
	
	// 전위순회
	public void dfs_with_preorder(int current) {
		if(current > lastIndex) return; // 기저조건
		
		// V->L->R
		System.out.println(nodes[current]); // 방문 관리 처리
		dfs_with_preorder(current*2);
		dfs_with_preorder(current*2+1);
	}
	
	// 중위순회
	public void dfs_with_inorder(int current) {
		if(current > lastIndex) return; // 기저조건
		
		// L->V->R
		dfs_with_inorder(current*2);
		System.out.println(nodes[current]); // 방문 관리 처리
		dfs_with_inorder(current*2+1);
	}	
		
	// 후위순회
	public void dfs_with_postorder(int current) {
		if(current > lastIndex) return; // 기저조건
		
		// L->R->V
		dfs_with_postorder(current*2);
		dfs_with_postorder(current*2+1);
		System.out.println(nodes[current]); // 방문 관리 처리
	}
	
}

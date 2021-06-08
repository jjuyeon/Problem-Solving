package tree;

public class CompleteBinaryTreeTest {
	public static void main(String[] args) {
		int size = 9;
		CompleteBinaryTree tree = new CompleteBinaryTree(size);
		
		for(int i=0; i<size; i++) {
			tree.add((char)(65+i));
		}
		
//		tree.bfs();
//		tree.bfs_with_level();
		tree.dfs_with_preorder(1); // 루트 노드는 인덱스가 1
//		tree.dfs_with_inorder(1);
//		tree.dfs_with_postorder(1);
	}
}

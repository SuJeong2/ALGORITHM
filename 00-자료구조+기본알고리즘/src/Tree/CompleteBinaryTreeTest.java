package Tree;

public class CompleteBinaryTreeTest {
	public static void main(String[] args) {
		
		int size = 9;
		CompleteBinaryTree tree = new CompleteBinaryTree(size);
		
		/*
		//이런식의 트리 구조
				A
		  	  B   C
			D  E F G
		  H  I
		 
		//배열 저장 형태
		0 1 2 3 4 5 6 7 8 9
		  A B C D E F G H I
		 */
		for(int i=0; i<size; i++) {
			tree.add((char)(65+i));
		}
		
		tree.printTree();
	}
}

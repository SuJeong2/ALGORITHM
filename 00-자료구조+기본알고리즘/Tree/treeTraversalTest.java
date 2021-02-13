package com.ssafy.day0213;

public class treeTraversalTest {

	public static void main(String[] args) {
		
		int size = 9;
		treeTraversal tree = new treeTraversal(size);
		
		/*
		트리 구조
				A
			B		C
		  D   E    F  G
		H  I
		
		배열 구조
		0 1 2 3 4 5 6 7 8 9
		  A B C D E F G H I
		 */
		for(int i=0; i<size; i++) {
			tree.add((char)(65+i));
		}

		//전위순회 : 부모 - 왼쪽 - 오른쪽 VLR
		//A B D H I E C F G 
		System.out.print("전위순회 : ");
		tree.preorder_traversal(1);
		System.out.println();
		
		//중위순회 : 왼쪽 - 부모 - 오른쪽 LVR
		//H D I B E A F C G
		System.out.print("중위순회 : ");
		tree.inorder_traversal(1);
		System.out.println();
		
		//후위순회 : 왼쪽 - 오른쪽 - 부모 LRV
		//H I D E B F G C A
		System.out.print("전위순회 : ");
		tree.postorder_traversal(1);
		System.out.println();
	}

}

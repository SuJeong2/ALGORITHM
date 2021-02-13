package com.ssafy.day0213;

import java.util.LinkedList;
import java.util.Queue;

public class treeTraversal {
	
	//트리 형태 - 배열로 구현
	private char[] nodes;
	private int lastIndex;
	private final int SIZE;

	public treeTraversal(int size) {
		super();
		SIZE = size;
		nodes = new char[size + 1];
	}

	public boolean isEmpty() {
		return lastIndex == 0;
	}

	public boolean isFull() {
		return lastIndex == SIZE;
	}

	public void add(char e) {
		if (isFull()) {
			System.out.println("포화상태입니다.");
			return;
		}
		nodes[++lastIndex] = e;
	}
	
	/*
	Preorder traversal 전위순회
	부모 -> 왼쪽 자식 -> 오른쪽 자식 : VLR
	 */
	public void preorder_traversal(int current) {
		if(current>lastIndex) return;
		
		System.out.print(nodes[current] +" "); //부모 방문 처리
		
		preorder_traversal(current*2); //왼쪽 자식 호출
		preorder_traversal(current*2+1); //오른쪽 자식 호출
	}
	
	/*
	Inorder traversal 중위순회
	왼쪽 자식 -> 부모노드 -> 오른쪽 자식 : LVR
	 */
	public void inorder_traversal(int current) {
		if(current>lastIndex) return;
		
		inorder_traversal(current*2); //왼쪽 자식 호출

		System.out.print(nodes[current] +" "); //부모 방문 처리
		
		inorder_traversal(current*2+1); //오른쪽 자식 호출
	}
	
	/*
	Postorder traversal 후위순회
	왼쪽 자식 -> 오른쪽 자식 -> 부모노드 : LRV
	 */
	public void postorder_traversal(int current) {
		if(current>lastIndex) return;
		
		postorder_traversal(current*2); //왼쪽 자식 호출
				
		postorder_traversal(current*2+1); //오른쪽 자식 호출
		
		System.out.print(nodes[current] +" "); //부모 방문 처리
	}
}

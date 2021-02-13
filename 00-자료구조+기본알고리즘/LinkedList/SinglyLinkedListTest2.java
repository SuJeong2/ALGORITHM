package LinkedList;

public class SinglyLinkedListTest2 {

	public static void main(String[] args) {

		SinglyLinkedList2 list = new SinglyLinkedList2();
		
		list.addtoLast("A");
		System.out.println(list.getLastNode()); //A null
		list.printList(); //A
		
		list.addtoLast("B");
		list.printList(); //A B
		
		list.addtoFirst("C");
		list.printList(); //C A B		
		System.out.println(list.getLastNode()); //B null
		
		Node2 preNode = list.getNode("A"); //A의 노드 값을 받아옴
		list.insertAfterNode(preNode, "D"); //A 노드 뒤에 "D" 노드를 넣겠다.
		list.printList(); //C A D B
		
		//B 노드의 값을 받아와서, 이 노드의 전 노드를 출력 -> D 출력
		//D에 연결된 B 노드에 대한 정보 출력
		//Node.link가 또 다른 노드이기 때문에 link.toString으로 출력되기 때문
		System.out.println(list.getPreviousNode(list.getNode("B")));
		//Node [ data= D, link= Node [ data= B, link= null]]
		
		list.deleteNode("A");
		list.printList(); //C D B
		list.deleteNode("D");
		list.printList(); //C B
		
		list.deleteNode("F"); //지우려는 노드가 존재하지 않습니다.
		list.printList(); //C B
		
		
		list.deleteNode("B");
		list.printList(); //C
		list.deleteNode("C");
		list.printList(); //빈 리스트 출력
		
		System.out.println(list.getLastNode()); //빈 리스트이기 때문에 null 출력

	}

}

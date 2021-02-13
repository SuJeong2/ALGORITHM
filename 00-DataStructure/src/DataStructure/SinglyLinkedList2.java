package DataStructure;

public class SinglyLinkedList2 {

	private Node2 head=null;
	
	/*
	addtoFirst(String)
	:리스트의 첫 번째 노드로 삽입
	- 새로운 노드를 만들어서 입력 받은 data를 넣고, link에는 head가 가리키고 있는 값을 넣음
	- 리스트가 빈 리스트일 경우 : null이 들어가서 newNode가 마지막 노드가 되고
	- 리스트가 빈 리스트가 아닐 경우 : head가 가리기고 있던 노드 주소가 들어가서 newNode가 가리키게 됨
	
	- head에 newNode 값을 넣어서 head가 새로운 노드를 첫 번 째 노드로 가리키게 함
	 */
	public void addtoFirst(String data){
		Node2 newNode = new Node2(data, head);
		head = newNode;
	}
	
	/*
	addtoLast(String)
	:리스트의 마지막 노드로 삽입
	-1) 빈 리스트일 경우 : head가 null을 가리킬 경우 -> 맨 앞에 노드를 추가하는 것과 같음
	-2) 빈 리스트가 아닐 경우 : 마지막 노드를 가져와야 함
		- getLastNode()를 통해서 마지막 노드의 주소 값을 lastNode에 저장
		- 새로운 노드를 만들고 link에는 null -> 새로운 노드가 마지막 노드가 되기 때문에
		- 마지막 노드의 link에 새로운 노드의 주소 값을 넣어서 새로 만든 노드를 가리키게 함
	 */
	public void addtoLast(String data) {
		//빈 리스트라면 끝에 넣는 것 == 맨 앞 노드에 넣는 것
		if(head==null) {
			addtoFirst(data);
			return;
		}
		
		Node2 lastNode = getLastNode();
		
		//빈 리스트일 경우는 위에서 체크해줬기 때문에
		//lastNode == null 이 되는 경우는 없지만 이중 체크
		if(lastNode != null) {
			Node2 newNode = new Node2(data, null);
			lastNode.link=newNode;
		}
	}
	
	/*
	getLastNode()
	: 리스트에서 가장 마지막 노드의 주소를 반환
	- currNode에 head 주소를 넣어서 쭉 링크를 타며 노드 탐색
	- currNoderk null일 경우 빈 리스트를 의미
	- 빈 리스트가 아닐 경우 : currNode.link를 통해서 마지막 노드 탐색
		. currNode.link == null -> 현재 노드의 링크 필드가 null이다
		-> 이 노드가 마지막 노드임을 의미 -> 이 노드의 주소를 반환
	 */
	public Node2 getLastNode() {
		Node2 currNode = head;
		
		if(currNode!=null) {
			while(currNode.link!=null) {
				currNode=currNode.link;
			}
		}
		
		return currNode;
	}
	
	/*
	insertAfterNode(Node2, String)
	: 어떤 노드 뒤에 삽입할지 노드 정보를 받아서 그 노드 뒤에 새로운 노드 추가
	- 파라미터로 받은 preNode가 null인지 아닌지 확인
	- null 일 경우, 이전 노드가 존재하지 않는다.
	
	- null 이 아닐 경우 -> 이전 노드가 존재
		- 새로운 노드를 만들고, 이전 노드가 가리키던 값을 link 값으로 준다.
		-> 이전 노드가 가리키던 노드를 가리키게 됨
		
		-이전 노드 링크 필드에 새로운 노드 주소를 준다.
		-> 이전 노드가 새로운 노드를 가리키게 된다.
	 */
	public void insertAfterNode(Node2 preNode, String data) {
		
		if(preNode == null) {
			System.out.println("존재하지 않는 노드");
			return;
		}
		
		Node2 newNode = new Node2(data, preNode.link);
		preNode.link=newNode;
	}
	
	/*
	getNode(String)
	: 파라미터로 받은 값과 같은 data를 가지고 있는 노드를 반환
	
	- currNode = head : head부터 탐색
	- currNode != null : currNode ==null은 마지막 노드를 의미함. 마지막 노드일 경우 for문 마침
	- currNode = currNode.link : 노드의 링크가 가리키는 노드 주소를 받음
	
	-  currNode.getData().equals(data) 
		: 현재 노드의 data 값과 파라미터로 받은 data가 같을 경우
		: 현재 currNode의 주소를 반환
	- for문을 빠져나왔을 경우 : 해당 노드를 찾지 못햇다 : null반환
	 */
	public Node2 getNode(String data) {
		for(Node2 currNode = head; currNode!=null; currNode = currNode.link) {
			if(currNode.getData().equals(data)) {
				//currNode.data.equals(data)
				return currNode;
			}
		}
		
		return null;
	}
	
	/*
	getPreviousNode(Node2)
	: 노드 값을 받아서, 이 노드의 전 노드를 반환
	
	- currNode는 head, head부터 탐색
	- head != null : 빈 리스트가 아닐 경우 링크를 타면서 탐색
	
	- nextNode : 현재 노드가 가리키는 노드 가 null이 되면 -> 마지막 노드임
	- nextNode 와 target노드의 값이 같으면, 현재 노드가 target의 전 노드가 됨
	(target의 주소를 가지고 있는 노드 -> nextNode /
	 nextNode + target의 주소를 링크 필드에 담고 있는 노드 -> currNode)
	 즉 currNode의 링크필드에 targetNode의 주소 값이 담겨 있음 -> currNode가 target의 이전 노드
	 */
	public Node2 getPreviousNode(Node2 target) {
		
		Node2 currNode = head, nextNode=null;
		if(currNode!=null) {
			while( (nextNode=currNode.link) != null) {
				if(nextNode==target) {
					return currNode;
				}
				currNode=nextNode;
			}
		}
		
		return null;
	}
	
	/*
	deleteNode(String)
	: 문자열을 받아서 그 데이터를 가진 노드를 삭제
	
	- head==null : 빈 리스트
	- tagetNode : getNode()를 통해 data와 같은 데이터를 가지고 있는 노드를 찾아야 함
		- targetNode == null : 찾는 노드가 없다
		
	- previousNode : getPreviousNode()를 통해 지우려고 하는 targetNode의 전 노드를 찾는다.
		- previousNode == null : 이전 노드가 없다.
		- tagetNode == head : target노드와 헤드가 가리키는 노드와 같다 
		==> 리스트의 첫 번째 노드를 삭제할 것이다.
		==> head = targetNode.link : head가 지우려고 하는 targetNode가 가리키던 노드를 가리키도록 함
		
		- 그렇지 않을 경우,
		- previousNode가 targetNode가 가리키던 노드를 가리킬 수 있도록 링크 필드 값을 복사
		
		-지우려는 targetNode의 링크 필드를 null 처리
	 */
	public void deleteNode(String data) {
		if(head==null) {
			System.out.println("빈 리스트 입니다.");
			return;
		}
		
		Node2 targetNode = getNode(data);
		if(targetNode==null) {
			System.out.println("지우려는 노드가 존재하지 않습니다.");
			return;
		}
		
		Node2 previousNode = getPreviousNode(targetNode);
		if(previousNode==null /*targetNode==head*/) {
			head = targetNode.link;
		}
		else {
			previousNode.link=targetNode.link;
		}
		targetNode.link=null;
	}
	
	/*
	printList()
	: 리스트의 데이터 값을 출력
	- head부터 마지막 노드가 나올 때까지, 노드의 데이터 값을 출력
	 */
	public void printList() {
		System.out.print(" List = (");
		for(Node2 currNode=head; currNode!=null; currNode = currNode.link) {
			System.out.print(currNode.data+" ");
		}
		System.out.println(")");
	}
}

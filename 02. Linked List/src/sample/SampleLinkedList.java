package sample;

/* 연결 리스트 전체를 설계하는 설계도 */
class LinkedList {
	private Node head;		//앞 노드를 가리킴
	private Node tail;		//뒤 노드를 가리킴
	private int size = 0;	//몇 개의 요소가 이 리스트 안에 포함되어 있는지 보여줄 변수
 
	/* 각각의 노드를 설계하는 설계도 */
	private class Node{
    	private Object data; //데이터를 담는 부분
    	private Node next;	//다음 노드를 가리키는 부분
    	
    	/* 객체 초기화하는 부분 */
    	public Node(Object input) {
    		this.data = input; //인풋 값을 data에 넘겨줌
    		this.next = null; //다음 노드를 가리키는 부분은 null로 설정
    	}
    	public String toString() { //노드 객체를 프린트하는 함수
    		return String.valueOf(this.data);
    	}
    }
	
	/* 새로운 노드를 연결리스트의 맨 처음에 추가해주는 함수 */
	public void addFirst(Object input) {
		Node newNode = new Node(input); //Node라는 객체를 만들어줌
		
		/* head는 '연결리스트의 맨 처음 노드'의 reference를 가지고 있음.
		 * 따라서 'newNode.next = head'는 head의 reference, 
		 * 즉 '연결리스트의 맨 처음 노드'를 newNode의 next에 할당해준다는 것을 뜻함.
		 * 쉽게 말해서 newNode가 '연결리스트의 맨 처음 노드'를 가리키게 만들어준다는 뜻 */
		newNode.next = head; 
		/* '연결리스트의 맨 처음 노드'는 이제 newNode이므로, 새로운 head는 newNode임 */
		head =newNode;
		size++; //노드 하나 추가해주었으므로 사이즈 증가
        
		/* 만약 '연결리스트의 맨 처음 노드', 즉 head가 가리키는 다음 노드가 없다면,
		 * 이 연결리스트에는 단 하나의 노드만 있다는 뜻임. 따라서 이 '단 하나의 노드'는
		 * head이자 동시에 tail이 되어야 함. */
		if(head.next == null) { 
			tail = head;
		}
	}
	
	/* 새로운 노드를 연결리스트의 맨 뒤에 추가해주는 함수 */
	public void addLast(Object input) {
		Node newNode = new Node(input); //Node라는 객체를 만들어줌
		
		/* 만약 연결리스트에 아무것도 없는 상태라면, 앞에 추가하나 뒤에 추가하나 차이가 없음.
		 * 따라서 addFirst 함수를 사용해도 됨. */
		if(size == 0) {
			addFirst(input);			
		}
		
		/* 만약 연결리스트에 다른 노드가 있는 상황이라면, 맨 마지막 노드 뒤에 연결해 주어야 함.
		 * 이때 '맨 마지막 노드'는 tail이 reference를 가지고(=가리키고)있음.
		 * 따라서 맨 마지막 노드의 다음에 연결해주기 위해서 tail.next에 newNode를 할당함.*/
		else {
			tail.next = newNode;
			/* newNode를 연결해주었으므로 새로운 맨 마지막 노드는 newNode가 되고,
			 * tail은 newNode를 가리킴 */
			tail = newNode;
			size++; //노드 하나 추가해주었으므로 사이즈 증가
		}
	}
	
	/* index 값이 주어지면 그 인덱스 번호에 대한 노드를 반환해주는 함수 */
	Node node(int index) {
		Node x = head; //우선 head가 가르기는 맨 처음 노드를 x에 할당해줌 
		/* 맨 처음 노드를 타고 타고 들어가서 우리가 원하는 인덱스 번호의 노드를 찾아냄.*/
		for( int i=0 ; i<index ; i++) {
			x = x.next;
		}
		return x;
	}
	
	/* k 인덱스 위치에 노드 input을 추가하는 함수 */
	public void add(int k, Object input) {
		/* 만약 맨 처음 위치라면 그냥 addFirst를 사용하여 추가할 것. */
		if(k == 0) {
			addFirst(input);
		}
		/* 만약 맨 처음 위치가 아니라면 */
		else {
			Node temp1 = node(k-1); //추가하고 싶은 위치의 앞쪽 노드
			Node temp2 = temp1.next; //추가하고 싶은 위치의 뒷쪽 노드
			Node newNode = new Node(input); //추가할 노드 생성
			temp1.next = newNode; //앞쪽 노드 뒤에 newNode를 연결
			newNode.next = temp2; //newNode의 뒤에 뒷쪽 노드를 연결
			size++; //노드 하나 추가해주었으므로 사이즈 증가	
			/* 만약 새로운 노드의 다음 노드가 null이라면, 이 새로운 노드는 tail이 되어야 함. */
			if(newNode.next == null) {  
				tail = newNode;
			}
		}
	}
	
	/* 맨 처음에 있는 노드를 제거해서 반환하는 함수 */
	public Object removeFirst() {
		/* head의 reference, 즉 맨 처음 노드를 temp가 가리킴.
		 * head의 next가 가리키는 노드, 즉 앞에서 두 번째 노드가 새로운 head가 됨. */
		Node temp = head;
		head = head.next;
		/* 맨 처음 노드의 데이터를 returnData가 받게 하고, temp를 null로 만듬. */
		Object returnData = temp.data;
		temp = null;
		size--;  //노드 하나 제거해주었으므로 사이즈 감소
		return returnData;
	}
	
	/* k번째 있는 노드를 제거해서 반환하는 함수 */
	public Object remove(int k) {
		/* 만약 k가 0이라면, 맨 처음 노드를 제거하는 것이므로 removeFirst 함수를 사용 */
		if(k == 0) {
			return removeFirst();
		}
		
		/* 만약 k가 0이 아니라면, 
		 * node 함수를 이용해 k-1번째에 있는 노드를 찾아서 
		 * temp에 넣음. 그리고 temp의 next를 사용하여 k번째 노드를 todoDeleted에 반환.
		 * 그리고 k+1번째에 있는 노드를 temp.next에 연결해줌. */
		Node temp = node(k-1);
		Node todoDeleted = temp.next;
		temp.next = temp.next.next;
		/* returnData에 todoDeleted의 데이터를 반환해줌 */
		Object returnData = todoDeleted.data;
		/* 만약 삭제하려는 노드가 마지막 노드였다면 */
		if(todoDeleted == tail) {
			tail = temp; //temp가 새로운 tail이 됨
		}
		todoDeleted = null; //삭제하려는 노드를 없애줌.
		size--;
		return returnData; //데이터를 반환함.
	}
	
	/* 맨 마지막 노드를 제거해서 반환하는 함수 */
	public Object removeLast() {
		return remove(size-1); //remove 함수를 사용하여 제거
	}
}


public class SampleLinkedList {
	public static void main(String[] args) {
		LinkedList numbers = new LinkedList(); //LinkedList 클래스를 인스턴스화
	    numbers.addFirst(30);
	    numbers.addFirst(20);	
	    numbers.addFirst(10);
	    numbers.addLast(10);
	    numbers.addLast(20);
	    numbers.addLast(30);
	    numbers.add(1, 15);
	}
}

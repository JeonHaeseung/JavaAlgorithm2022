package sample;

/* ���� ����Ʈ ��ü�� �����ϴ� ���赵 */
class LinkedList {
	private Node head;		//�� ��带 ����Ŵ
	private Node tail;		//�� ��带 ����Ŵ
	private int size = 0;	//�� ���� ��Ұ� �� ����Ʈ �ȿ� ���ԵǾ� �ִ��� ������ ����
 
	/* ������ ��带 �����ϴ� ���赵 */
	private class Node{
    	private Object data; //�����͸� ��� �κ�
    	private Node next;	//���� ��带 ����Ű�� �κ�
    	
    	/* ��ü �ʱ�ȭ�ϴ� �κ� */
    	public Node(Object input) {
    		this.data = input; //��ǲ ���� data�� �Ѱ���
    		this.next = null; //���� ��带 ����Ű�� �κ��� null�� ����
    	}
    	public String toString() { //��� ��ü�� ����Ʈ�ϴ� �Լ�
    		return String.valueOf(this.data);
    	}
    }
	
	/* ���ο� ��带 ���Ḯ��Ʈ�� �� ó���� �߰����ִ� �Լ� */
	public void addFirst(Object input) {
		Node newNode = new Node(input); //Node��� ��ü�� �������
		
		/* head�� '���Ḯ��Ʈ�� �� ó�� ���'�� reference�� ������ ����.
		 * ���� 'newNode.next = head'�� head�� reference, 
		 * �� '���Ḯ��Ʈ�� �� ó�� ���'�� newNode�� next�� �Ҵ����شٴ� ���� ����.
		 * ���� ���ؼ� newNode�� '���Ḯ��Ʈ�� �� ó�� ���'�� ����Ű�� ������شٴ� �� */
		newNode.next = head; 
		/* '���Ḯ��Ʈ�� �� ó�� ���'�� ���� newNode�̹Ƿ�, ���ο� head�� newNode�� */
		head =newNode;
		size++; //��� �ϳ� �߰����־����Ƿ� ������ ����
        
		/* ���� '���Ḯ��Ʈ�� �� ó�� ���', �� head�� ����Ű�� ���� ��尡 ���ٸ�,
		 * �� ���Ḯ��Ʈ���� �� �ϳ��� ��常 �ִٴ� ����. ���� �� '�� �ϳ��� ���'��
		 * head���� ���ÿ� tail�� �Ǿ�� ��. */
		if(head.next == null) { 
			tail = head;
		}
	}
	
	/* ���ο� ��带 ���Ḯ��Ʈ�� �� �ڿ� �߰����ִ� �Լ� */
	public void addLast(Object input) {
		Node newNode = new Node(input); //Node��� ��ü�� �������
		
		/* ���� ���Ḯ��Ʈ�� �ƹ��͵� ���� ���¶��, �տ� �߰��ϳ� �ڿ� �߰��ϳ� ���̰� ����.
		 * ���� addFirst �Լ��� ����ص� ��. */
		if(size == 0) {
			addFirst(input);			
		}
		
		/* ���� ���Ḯ��Ʈ�� �ٸ� ��尡 �ִ� ��Ȳ�̶��, �� ������ ��� �ڿ� ������ �־�� ��.
		 * �̶� '�� ������ ���'�� tail�� reference�� ������(=����Ű��)����.
		 * ���� �� ������ ����� ������ �������ֱ� ���ؼ� tail.next�� newNode�� �Ҵ���.*/
		else {
			tail.next = newNode;
			/* newNode�� �������־����Ƿ� ���ο� �� ������ ���� newNode�� �ǰ�,
			 * tail�� newNode�� ����Ŵ */
			tail = newNode;
			size++; //��� �ϳ� �߰����־����Ƿ� ������ ����
		}
	}
	
	/* index ���� �־����� �� �ε��� ��ȣ�� ���� ��带 ��ȯ���ִ� �Լ� */
	Node node(int index) {
		Node x = head; //�켱 head�� ������� �� ó�� ��带 x�� �Ҵ����� 
		/* �� ó�� ��带 Ÿ�� Ÿ�� ���� �츮�� ���ϴ� �ε��� ��ȣ�� ��带 ã�Ƴ�.*/
		for( int i=0 ; i<index ; i++) {
			x = x.next;
		}
		return x;
	}
	
	/* k �ε��� ��ġ�� ��� input�� �߰��ϴ� �Լ� */
	public void add(int k, Object input) {
		/* ���� �� ó�� ��ġ��� �׳� addFirst�� ����Ͽ� �߰��� ��. */
		if(k == 0) {
			addFirst(input);
		}
		/* ���� �� ó�� ��ġ�� �ƴ϶�� */
		else {
			Node temp1 = node(k-1); //�߰��ϰ� ���� ��ġ�� ���� ���
			Node temp2 = temp1.next; //�߰��ϰ� ���� ��ġ�� ���� ���
			Node newNode = new Node(input); //�߰��� ��� ����
			temp1.next = newNode; //���� ��� �ڿ� newNode�� ����
			newNode.next = temp2; //newNode�� �ڿ� ���� ��带 ����
			size++; //��� �ϳ� �߰����־����Ƿ� ������ ����	
			/* ���� ���ο� ����� ���� ��尡 null�̶��, �� ���ο� ���� tail�� �Ǿ�� ��. */
			if(newNode.next == null) {  
				tail = newNode;
			}
		}
	}
	
	/* �� ó���� �ִ� ��带 �����ؼ� ��ȯ�ϴ� �Լ� */
	public Object removeFirst() {
		/* head�� reference, �� �� ó�� ��带 temp�� ����Ŵ.
		 * head�� next�� ����Ű�� ���, �� �տ��� �� ��° ��尡 ���ο� head�� ��. */
		Node temp = head;
		head = head.next;
		/* �� ó�� ����� �����͸� returnData�� �ް� �ϰ�, temp�� null�� ����. */
		Object returnData = temp.data;
		temp = null;
		size--;  //��� �ϳ� �������־����Ƿ� ������ ����
		return returnData;
	}
	
	/* k��° �ִ� ��带 �����ؼ� ��ȯ�ϴ� �Լ� */
	public Object remove(int k) {
		/* ���� k�� 0�̶��, �� ó�� ��带 �����ϴ� ���̹Ƿ� removeFirst �Լ��� ��� */
		if(k == 0) {
			return removeFirst();
		}
		
		/* ���� k�� 0�� �ƴ϶��, 
		 * node �Լ��� �̿��� k-1��°�� �ִ� ��带 ã�Ƽ� 
		 * temp�� ����. �׸��� temp�� next�� ����Ͽ� k��° ��带 todoDeleted�� ��ȯ.
		 * �׸��� k+1��°�� �ִ� ��带 temp.next�� ��������. */
		Node temp = node(k-1);
		Node todoDeleted = temp.next;
		temp.next = temp.next.next;
		/* returnData�� todoDeleted�� �����͸� ��ȯ���� */
		Object returnData = todoDeleted.data;
		/* ���� �����Ϸ��� ��尡 ������ ��忴�ٸ� */
		if(todoDeleted == tail) {
			tail = temp; //temp�� ���ο� tail�� ��
		}
		todoDeleted = null; //�����Ϸ��� ��带 ������.
		size--;
		return returnData; //�����͸� ��ȯ��.
	}
	
	/* �� ������ ��带 �����ؼ� ��ȯ�ϴ� �Լ� */
	public Object removeLast() {
		return remove(size-1); //remove �Լ��� ����Ͽ� ����
	}
}


public class SampleLinkedList {
	public static void main(String[] args) {
		LinkedList numbers = new LinkedList(); //LinkedList Ŭ������ �ν��Ͻ�ȭ
	    numbers.addFirst(30);
	    numbers.addFirst(20);	
	    numbers.addFirst(10);
	    numbers.addLast(10);
	    numbers.addLast(20);
	    numbers.addLast(30);
	    numbers.add(1, 15);
	}
}

package baekjoon2605;
import java.util.Scanner;

class LinkedList {
  private Node head;
  private Node tail;
  private boolean isEmpty;

  public LinkedList(){
    this.isEmpty = true;
    this.head = null;
    this.tail = null;
  }

  class Node {
    private Object data;
    private Node next;

    public Node(Object input){
      this.data = input;
      this.next = null;
    }
  }
  /* �� ó���� ��带 �����ϴ� �Լ� */
  public void addFirst(Node newNode) {
	  newNode.next = head; 
	  head = newNode;

		if(head.next == null) { 
		  tail = head;
	  }
	}
  /* �� �������� ��带 �����ϴ� �Լ� */
  public void addLast(Node newNode) {

		if(isEmpty == true) {
		  addFirst(newNode);			
		}

		else {
		  tail.next = newNode;
		  tail = newNode;
		}
	}

  /* ����� number ��ŭ ������ �̵���Ų ��ġ�� �ִ� �Լ� */
  public void changeLine (int n, int number){
    Node newNode = new Node(n);
    
    /* ���� �л� 1�̶�� */
    if(isEmpty == true){
      addFirst(newNode);
      isEmpty = false;
    }

    /* �л� 1�� �ƴ϶�� */
    else{
      /* ���� �� ���������� ���� �ϴ� ����� */
      if(number == 0){
        addLast(newNode);
      }
      /* ���� �� ������ ���� �ϴ� ����� */
      else if(n-number==1){
        addFirst(newNode);
      }
      /* ���� �߰� ��������� �����ϴ� ����� */
      else{
        Node temp = head;
        for( int i=1 ; i<(n-number-1) ; i++ ){
          temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
      }
    }
  }

  public void printLine(int n) {
    Node temp = head;
    for(int i = 1 ; i<=n ; i++){
      System.out.printf("%d ", temp.data);
      temp = temp.next;
    }
  }

}

public class Baekjoon2605 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    
    int n = in.nextInt(); //�л� �� �Է¹ޱ�

    LinkedList list = new LinkedList(); //�ν��Ͻ� ����

    for(int i=1; i<=n ; i++){ //�л� �ϳ��ϳ� �� �����ֱ�
      list.changeLine( i, in.nextInt());
    }
    list.printLine(n);
  }
}
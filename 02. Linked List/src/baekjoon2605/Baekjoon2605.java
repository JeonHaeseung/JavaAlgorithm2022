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
  /* 맨 처음에 노드를 연결하는 함수 */
  public void addFirst(Node newNode) {
	  newNode.next = head; 
	  head = newNode;

		if(head.next == null) { 
		  tail = head;
	  }
	}
  /* 맨 마지막에 노드를 연결하는 함수 */
  public void addLast(Node newNode) {

		if(isEmpty == true) {
		  addFirst(newNode);			
		}

		else {
		  tail.next = newNode;
		  tail = newNode;
		}
	}

  /* 사람을 number 만큼 앞으로 이동시킨 위치에 넣는 함수 */
  public void changeLine (int n, int number){
    Node newNode = new Node(n);
    
    /* 만약 학생 1이라면 */
    if(isEmpty == true){
      addFirst(newNode);
      isEmpty = false;
    }

    /* 학생 1이 아니라면 */
    else{
      /* 만약 맨 마지막으로 가야 하는 노드라면 */
      if(number == 0){
        addLast(newNode);
      }
      /* 만약 맨 앞으로 가야 하는 노드라면 */
      else if(n-number==1){
        addFirst(newNode);
      }
      /* 만약 중간 어디쯤으로 가야하는 노드라면 */
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
    
    int n = in.nextInt(); //학생 수 입력받기

    LinkedList list = new LinkedList(); //인스턴스 생성

    for(int i=1; i<=n ; i++){ //학생 하나하나 줄 세워주기
      list.changeLine( i, in.nextInt());
    }
    list.printLine(n);
  }
}
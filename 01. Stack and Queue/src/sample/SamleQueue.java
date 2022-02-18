package sample;

import java.util.NoSuchElementException;

/* queue 클래스를 선언. 이 클래스 안에는 node 클래스와 add, remove, peek, isEmpty 메소드가 있다. */
class Queue<T>{     
  class Node<T>{    //node 클래스를 선언. Queue 안에 노드가 쌓인다고 생각하면 된다.
    private T data; //Node 안에 들어있을 데이터
    private Node<T> next;   //다음 노드를 가리키는 부분.

    public Node(T data){    //메소드명 Node는 data를 받으면 내부 변수에 저장한다.
      this.data = data;     //내부 변수에 저장
    }
    
  }

  private Node<T> first;  //first라는 객체 선언
  private Node<T> last;   //last라는 객체 선언

  public void add(T item){
    /* t라는 Node 객체를 메모리에 할당(인스턴스화), item의 값을 이 노드에 저장 */
    Node<T> t = new Node<T>(item); 
    /* 만약 큐에 넣는 첫 노드가 아니라면 */
    if(last != null){
       last.next = t;   //last의 뒤에 t를 이어 붙이기
    }

    last = t;           //t를 새로운 last로 만들기
    /* 만약 큐에 넣는 첫 노드라면(만약 큐가 원래 비어있다면) */
    if(first == null){
      first = last;     //first와 last의 주소 동일시하기
    }
  }

  public T remove(){
    /* 만약 큐가 비어있다면 */
    if(first == null){
      throw new NoSuchElementException(); //throw는 자바의 예외던지기임. 우리가 import한 "java.util.NoSuchElementException"에서 이 예외를 받아 처리함.
    }

    T data = first.data;  //first의 데이터 백업
    first = first.next;   //first의 다음 노드가 first 자리 이어받음

    if(first == null){    //이어받고 나서 first가 null이면 큐 안에 데이터가 없다는 뜻
      last = null;        //last 또한 null로 만들어준다.
    }
    return data;  //데이터 반환
  }

  /* queue의 first에 있는 data가 무엇인지 확인한다 */
  public T peek(){
    /* 만약 큐가 비어있다면 */
    if(first == null){
      throw new NoSuchElementException(); //throw는 자바의 예외던지기임. 우리가 import한 "java.util.NoSuchElementException"에서 이 예외를 받아 처리함.
    }
    return first.data; //first의 data 반환
  }
  
  /* queue가 비어있는지 확인한다 */
  public boolean isEmpty(){
    return first == null;   //큐가 비어있으면 true, 큐가 채워져 있으면 false를 반환
  }
}

/*자바에서 public static void main(String[] args)이 있는 class의 이름은 무조건 파일명과 같아야 한다. 
영상에서는 Test.java 파일이여서 class명을 Test라고 지었지만, 본인의 파일명이 SamleQueue.java라면 SamleQueue으로 고쳐야 함.*/
public class SamleQueue {
  public static void main(String[] args) {
    /* q라는 Queue 객체를 메모리에 할당(인스턴스화) */
    Queue<Integer> q = new Queue<Integer>();
    q.add(1);
    q.add(2);
    q.add(3);
    q.add(4);
    System.out.println(q.remove());
    System.out.println(q.remove());
    System.out.println(q.peek());
    System.out.println(q.remove());
    System.out.println(q.isEmpty());
    System.out.println(q.remove());
    System.out.println(q.isEmpty());
  }
}